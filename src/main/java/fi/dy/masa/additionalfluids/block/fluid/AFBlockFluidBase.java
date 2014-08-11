package fi.dy.masa.additionalfluids.block.fluid;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class AFBlockFluidBase extends BlockFluidClassic
{
	protected Fluid fluid;
	protected String blockName;

	public AFBlockFluidBase(String blockName, Fluid fluid)
	{
		this(blockName, fluid, Material.water);
	}

	public AFBlockFluidBase(String blockName, Fluid fluid, Material material)
	{
		super(FluidRegistry.getFluid(blockName), material);
		//verifyIsFluid(fluidName);
		this.setBlockName(blockName);
		this.setHardness(100.0f);
		this.setLightOpacity(3);
		this.blockName = blockName;
		this.fluid = fluid;
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
/*
	private static Fluid verifyIsFluid(String fluidName)
	{
		Fluid fluid = FluidRegistry.getFluid(fluidName);

		if (fluid.canBePlacedInWorld() == true)
		{
			ReflectionHelper.setPrivateValue(Fluid.class, fluid, null, "block");
		}

		return fluid;
	}
*/
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.checkCanStay(world, x, y, z, world.rand);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		this.checkCanStay(world, x, y, z, rand);
		super.updateTick(world, x, y, z, rand);
	}

	@Override
	public String getUnlocalizedName()
	{
		return "fluid." + this.blockName;
	}

	protected void checkCanStay(World world, int x, int y, int z, Random rand)
	{
	}
}

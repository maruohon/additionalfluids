package fi.dy.masa.additionalfluids.block.fluid;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;

public class AFBlockFluidBase extends BlockFluidClassic
{
	protected String fluidName;

	public AFBlockFluidBase(String fluidName)
	{
		this(fluidName, Material.water);
	}

	public AFBlockFluidBase(String fluidName, Material material)
	{
		super(FluidRegistry.getFluid(fluidName), material);
		//verifyIsFluid(fluidName);
		this.setBlockName(fluidName);
		this.setHardness(100.0f);
		this.setLightOpacity(3);
		this.fluidName = fluidName;
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
		return "fluid." + this.fluidName;
	}

	protected void checkCanStay(World world, int x, int y, int z, Random rand)
	{
	}
}

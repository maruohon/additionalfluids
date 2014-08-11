package fi.dy.masa.additionalfluids;

import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fi.dy.masa.additionalfluids.block.fluid.AFBlockFluidBase;
import fi.dy.masa.additionalfluids.block.fluid.BlockFluidMilk;
import fi.dy.masa.additionalfluids.reference.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class AdditionalFluids
{
	@Instance(Reference.MOD_ID)
	public static AdditionalFluids instance;

	public AFBlockFluidBase blockFluidMilk;
	public Fluid fluidMilk;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		fluidMilk = registerFluid("milk", 1050, EnumRarity.common);
		blockFluidMilk = new BlockFluidMilk(fluidMilk);
		GameRegistry.registerBlock(blockFluidMilk, blockFluidMilk.getUnlocalizedName());
		//RegistryUtils.overwriteEntry(Item.itemRegistry, "minecraft:milk_bucket", Items.milk_bucket);
		FluidContainerRegistry.registerFluidContainer(new FluidContainerData(FluidRegistry.getFluidStack("milk", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.milk_bucket), new ItemStack(Items.bucket)));
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
	}

/*
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
*/
	public static Fluid registerFluid(String fluidName, int density, int lightLevel, int temp, EnumRarity rarity)
	{
		Fluid fluid = new Fluid(fluidName);
		if (FluidRegistry.registerFluid(fluid) == false)
		{
			fluid = FluidRegistry.getFluid(fluidName);
		}
		if (density != 0)
		{
			fluid.setDensity(density);
		}
		if (lightLevel >= 0)
		{
			fluid.setLuminosity(lightLevel);
		}
		fluid.setRarity(rarity);
		//fluid.setUnlocalizedName(fluidName + ".still");
		fluid.setUnlocalizedName(fluidName);

		return fluid;
	}

	public static Fluid registerFluid(String fluidName, int density, EnumRarity rarity)
	{
		return registerFluid(fluidName, density, -1, -1, rarity);
	}
}


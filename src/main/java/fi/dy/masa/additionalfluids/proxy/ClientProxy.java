package fi.dy.masa.additionalfluids.proxy;

import net.minecraft.block.Block;
import net.minecraftforge.fluids.Fluid;
import fi.dy.masa.additionalfluids.AdditionalFluids;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerTextures()
	{
		Block block = AdditionalFluids.instance.blockFluidMilk;
		Fluid fluid = AdditionalFluids.instance.fluidMilk;
		fluid.setIcons(block.getIcon(0, 0), block.getIcon(2, 0)); // FIXME
	}
}

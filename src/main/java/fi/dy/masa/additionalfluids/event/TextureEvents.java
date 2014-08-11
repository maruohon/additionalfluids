package fi.dy.masa.additionalfluids.event;

import net.minecraft.block.Block;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fi.dy.masa.additionalfluids.AdditionalFluids;

public class TextureEvents
{
	@SubscribeEvent
	public void registerTextures(TextureStitchEvent.Post event)
	{
		if (event.map.getTextureType() == 0)
		{
			Block block = AdditionalFluids.instance.blockFluidMilk;
			Fluid fluid = AdditionalFluids.instance.fluidMilk;
			fluid.setIcons(block.getIcon(0, 0), block.getIcon(2, 0)); // FIXME
		}
	}
}

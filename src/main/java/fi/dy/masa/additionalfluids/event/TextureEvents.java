package fi.dy.masa.additionalfluids.event;

import net.minecraftforge.client.event.TextureStitchEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fi.dy.masa.additionalfluids.AdditionalFluids;

public class TextureEvents
{
	@SubscribeEvent
	public void registerTextures(TextureStitchEvent.Post event)
	{
		if (event.map.getTextureType() == 0)
		{
			AdditionalFluids.proxy.registerTextures();
		}
	}
}

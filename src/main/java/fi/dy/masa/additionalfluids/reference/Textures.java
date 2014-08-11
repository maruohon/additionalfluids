package fi.dy.masa.additionalfluids.reference;

public class Textures
{
	public static String getFluidName(String name)
	{
		return Reference.MOD_ID + ":fluid." + name;
	}

	public static String getItemName(String name)
	{
		return Reference.MOD_ID + ":item." + name;
	}

	public static String getTextureName(String name)
	{
		return Reference.MOD_ID + ":" + name;
	}

	public static String getTileName(String name)
	{
		return Reference.MOD_ID + ":tile." + name;
	}
}

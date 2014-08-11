package fi.dy.masa.additionalfluids.block.fluid;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fi.dy.masa.additionalfluids.reference.Textures;

public class BlockFluidMilk extends AFBlockFluidBase
{
	@SideOnly(Side.CLIENT)
	public IIcon iconFlow;

	public BlockFluidMilk()
	{
		super("milk");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Textures.getFluidName("milk.still"));
		this.iconFlow = iconRegister.registerIcon(Textures.getFluidName("milk.still")); // TODO
	}

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
    	if (side == 0 || side == 1)
    	{
    		return this.blockIcon;
    	}

    	return this.iconFlow;
    }
}

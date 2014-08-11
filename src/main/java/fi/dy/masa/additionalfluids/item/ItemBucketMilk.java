package fi.dy.masa.additionalfluids.item;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class ItemBucketMilk extends ItemBucketBase
{
	public int hash;
	private Item vanillaMilkBucket;

	public ItemBucketMilk(Block fluidBlock)
	{
		super(fluidBlock);
		this.setUnlocalizedName("bucket.milk");
		this.setTextureName("minecraft:bucket_milk");
		this.vanillaMilkBucket = Items.milk_bucket;
		this.hash = this.vanillaMilkBucket.hashCode();
	}

	@Override
	public int hashCode()
	{
		return this.vanillaMilkBucket.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj == this.vanillaMilkBucket || obj == this;
	}
}

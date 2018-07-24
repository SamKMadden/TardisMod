package net.tardis.mod.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.tardis.mod.common.data.TimeLord;

public class ItemFobWatch extends ItemBase {
	
	public ItemFobWatch() {
		this.setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(!worldIn.isRemote) {
			if(!TimeLord.isTimeLord(playerIn)) {
				TimeLord.setTimeLord(playerIn);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}


package carslo.hk.mcmod.test.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

import carslo.hk.mcmod.test.itemgroup.OurItemsItemGroup;
import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class ManaToIronItem extends Hk400testModElements.ModElement {
	@ObjectHolder("hk400test:mana_to_iron")
	public static final Item block = null;
	public ManaToIronItem(Hk400testModElements instance) {
		super(instance, 32);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OurItemsItemGroup.tab).maxStackSize(1).rarity(Rarity.UNCOMMON));
			setRegistryName("mana_to_iron");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Nutze \u00A7310 Mana \u00A7rum 1 Eisen zu bekommen"));
		}
	}
}

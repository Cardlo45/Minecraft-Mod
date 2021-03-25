
package carslo.hk.mcmod.test.itemgroup;

@Hk400testModElements.ModElement.Tag
public class OurItemsItemGroup extends Hk400testModElements.ModElement {

	public OurItemsItemGroup(Hk400testModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabour_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NewItemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;

}

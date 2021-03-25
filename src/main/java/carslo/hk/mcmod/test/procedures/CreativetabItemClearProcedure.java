package carslo.hk.mcmod.test.procedures;

@Hk400testModElements.ModElement.Tag
public class CreativetabItemClearProcedure extends Hk400testModElements.ModElement {

	public CreativetabItemClearProcedure(Hk400testModElements instance) {
		super(instance, 13);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CreativetabItemClear!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(CreativetabItem.block, (int) (1));
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 999);
		}

	}

}

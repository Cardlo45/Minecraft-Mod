package carslo.hk.mcmod.test.procedures;

@Hk400testModElements.ModElement.Tag
public class NewItemItemInInventoryTickProcedure extends Hk400testModElements.ModElement {

	public NewItemItemInInventoryTickProcedure(Hk400testModElements instance) {
		super(instance, 6);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NewItemItemInInventoryTick!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				System.err.println("Failed to load dependency sourceentity for procedure NewItemItemInInventoryTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");

		livingsourceentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH)
				.setBaseValue((livingsourceentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() * 1.01));

	}

}

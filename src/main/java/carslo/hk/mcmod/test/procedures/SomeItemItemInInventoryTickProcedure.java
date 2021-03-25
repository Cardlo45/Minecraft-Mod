package carslo.hk.mcmod.test.procedures;

@Hk400testModElements.ModElement.Tag
public class SomeItemItemInInventoryTickProcedure extends Hk400testModElements.ModElement {

	public SomeItemItemInInventoryTickProcedure(Hk400testModElements instance) {
		super(instance, 9);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SomeItemItemInInventoryTick!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		LivingEntity livingentity = (LivingEntity) dependencies.get("entity");
		livingentity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);

	}

}

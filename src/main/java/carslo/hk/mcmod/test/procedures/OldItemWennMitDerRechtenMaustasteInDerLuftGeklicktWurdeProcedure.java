package carslo.hk.mcmod.test.procedures;

@Hk400testModElements.ModElement.Tag
public class OldItemWennMitDerRechtenMaustasteInDerLuftGeklicktWurdeProcedure extends Hk400testModElements.ModElement {

	public OldItemWennMitDerRechtenMaustasteInDerLuftGeklicktWurdeProcedure(Hk400testModElements instance) {
		super(instance, 7);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OldItemWennMitDerRechtenMaustasteInDerLuftGeklicktWurde!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		LivingEntity livingentity = (LivingEntity) dependencies.get("entity");
		livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
		livingentity.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
		livingentity.getAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).setBaseValue(0);
		livingentity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
		livingentity.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0);

	}

}

package carslo.hk.mcmod.test.procedures;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class SomeItemDroppedProcedure extends Hk400testModElements.ModElement {
	public SomeItemDroppedProcedure(Hk400testModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SomeItemDropped!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		LivingEntity livingentity = (LivingEntity) dependencies.get("entity");
		livingentity.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
	}
}

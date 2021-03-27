package carslo.hk.mcmod.test.procedures;

import net.minecraft.entity.Entity;

import java.util.Map;

import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class ManaSwordManaTestProcedure extends Hk400testModElements.ModElement {
	public ManaSwordManaTestProcedure(Hk400testModElements instance) {
		super(instance, 39);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ManaSwordManaTest!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hk400testModVariables.PlayerVariables())).mana) >= 20);
	}
}

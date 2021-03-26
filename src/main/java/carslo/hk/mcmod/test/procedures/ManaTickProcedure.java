package carslo.hk.mcmod.test.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class ManaTickProcedure extends Hk400testModElements.ModElement {
	public ManaTickProcedure(Hk400testModElements instance) {
		super(instance, 30);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ManaTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("ManaSetup")) != 1)) {
			entity.getPersistentData().putDouble("ManaLevel", 1);
			entity.getPersistentData().putDouble("Mana", 100);
			entity.getPersistentData().putDouble("MaxMana", 100);
			entity.getPersistentData().putDouble("ManaSetup", 1);
		}
		if (((entity.getPersistentData().getDouble("ManaLevel")) < 1)) {
			entity.getPersistentData().putDouble("ManaLevel", 1);
		} else if (((entity.getPersistentData().getDouble("MaxMana")) < 100)) {
			entity.getPersistentData().putDouble("MaxMana", 100);
		} else if (((entity.getPersistentData().getDouble("Mana")) < 0)) {
			entity.getPersistentData().putDouble("Mana", 0);
		}
		if (((entity.getPersistentData().getDouble("Mana")) > (entity.getPersistentData().getDouble("MaxMana")))) {
			entity.getPersistentData().putDouble("Mana", ((entity.getPersistentData().getDouble("Mana")) - 0.1));
		}
		if (((entity.getPersistentData().getDouble("Mana")) < (entity.getPersistentData().getDouble("MaxMana")))) {
			entity.getPersistentData().putDouble("Mana", ((entity.getPersistentData().getDouble("Mana")) + 0.01));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}

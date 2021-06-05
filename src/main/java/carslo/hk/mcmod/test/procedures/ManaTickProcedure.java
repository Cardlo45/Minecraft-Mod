package carslo.hk.mcmod.test.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;
import carslo.hk.mcmod.test.Hk400testMod;

@Hk400testModElements.ModElement.Tag
public class ManaTickProcedure extends Hk400testModElements.ModElement {
	public ManaTickProcedure(Hk400testModElements instance) {
		super(instance, 35);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Hk400testMod.LOGGER.warn("Failed to load dependency entity for procedure ManaTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hk400testModVariables.PlayerVariables())).mana) < 0)) {
			{
				double _setval = (double) 0;
				entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hk400testModVariables.PlayerVariables())).maxmana) < 0)) {
			{
				double _setval = (double) 0;
				entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.maxmana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hk400testModVariables.PlayerVariables())).mana) < (((entity
						.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).maxmana) + 0.5))
				&& (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).mana) > (((entity
								.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).maxmana) - 0.5)))) {
			{
				double _setval = (double) ((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).maxmana);
				entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Hk400testModVariables.PlayerVariables())).mana) < ((entity
							.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Hk400testModVariables.PlayerVariables())).maxmana))) {
				{
					double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Hk400testModVariables.PlayerVariables())).mana) + 0.1);
					entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new Hk400testModVariables.PlayerVariables())).mana) > ((entity
							.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Hk400testModVariables.PlayerVariables())).maxmana))) {
				{
					double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new Hk400testModVariables.PlayerVariables())).mana) - 0.2);
					entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
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

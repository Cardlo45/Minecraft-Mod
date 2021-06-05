package carslo.hk.mcmod.test.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModElements;
import carslo.hk.mcmod.test.Hk400testMod;

@Hk400testModElements.ModElement.Tag
public class GmCmdProcedure extends Hk400testModElements.ModElement {
	public GmCmdProcedure(Hk400testModElements instance) {
		super(instance, 17);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Hk400testMod.LOGGER.warn("Failed to load dependency entity for procedure GmCmd!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				Hk400testMod.LOGGER.warn("Failed to load dependency cmdparams for procedure GmCmd!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Hk400testMod.LOGGER.warn("Failed to load dependency x for procedure GmCmd!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Hk400testMod.LOGGER.warn("Failed to load dependency y for procedure GmCmd!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Hk400testMod.LOGGER.warn("Failed to load dependency z for procedure GmCmd!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Hk400testMod.LOGGER.warn("Failed to load dependency world for procedure GmCmd!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double gamemode = 0;
		String player = "";
		String change = "";
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).length() <= 0)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nutzung: '/gm {0,1,2,3} [Spieler]'"), (false));
			}
		} else {
			if ((((gamemode) <= 3) && ((gamemode) >= 0))) {
				gamemode = (double) new Object() {
					int convert(String s) {
						try {
							return Integer.parseInt(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nutzung: '/gm {0,1,2,3} [Spieler]'"), (false));
				}
			}
			if (((gamemode) == 0)) {
				change = (String) "survival";
			} else if (((gamemode) == 1)) {
				change = (String) "creative";
			} else if (((gamemode) == 2)) {
				change = (String) "adventure";
			} else if (((gamemode) == 3)) {
				change = (String) "spectator";
			}
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).length() > 0)) {
				player = (String) (new Object() {
					public String getText() {
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText());
			} else {
				player = (String) (entity.getDisplayName().getString());
			}
			if (world instanceof ServerWorld) {
				((World) world).getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
						(("gamemode ") + "" + ((change)) + "" + (" ") + "" + ((player))));
			}
		}
	}
}

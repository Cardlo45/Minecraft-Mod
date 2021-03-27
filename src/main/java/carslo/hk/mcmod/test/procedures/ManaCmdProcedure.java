package carslo.hk.mcmod.test.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModElements;
import carslo.hk.mcmod.test.Hk400testMod;

@Hk400testModElements.ModElement.Tag
public class ManaCmdProcedure extends Hk400testModElements.ModElement {
	public ManaCmdProcedure(Hk400testModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ManaCmd!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure ManaCmd!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double count = 0;
		String type = "";
		String logplayer = "";
		String exeplayer = "";
		exeplayer = (String) (entity.getDisplayName().getString());
		count = (double) new Object() {
			int convert(String s) {
				try {
					return Integer.parseInt(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("2");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()));
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("help"))) {
			for (int index0 = 0; index0 < (int) (1); index0++) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A72Basics Tests and Notes"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A76===================="), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("/mana: {needed} [optional]"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Types: mana, maxmana"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("help"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("set {type} {count}"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("add {type} {count}"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("remove {type} {count}"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("reset {type}"), (false));
				}
			}
			Hk400testMod.LOGGER.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" used help.")));
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("set"))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("mana"))) {
				count = (double) (count);
				Hk400testMod.LOGGER
						.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" set his mana to: ") + "" + ((count)) + "" + (".")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("\u00A7aSet mana to: ") + "" + ((count)) + "" + ("."))),
							(false));
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("maxmana"))) {
				count = (double) (count);
				Hk400testMod.LOGGER
						.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" set his maxmana to: ") + "" + ((count)) + "" + (".")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("\u00A7aSet maxmana to: ") + "" + ((count)) + "" + ("."))),
							(false));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent("\u00A74Use /mana help syntax, more information on my Discord."), (false));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("add"))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("mana"))) {
				count = (double) ((count) + (count));
				Hk400testMod.LOGGER
						.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" added: ") + "" + ((count)) + "" + (" to his mana.")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("\u00A7aAdded ") + "" + ((count)) + "" + (" to your mana."))),
							(false));
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("maxmana"))) {
				count = (double) ((count) + (count));
				Hk400testMod.LOGGER
						.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" added: ") + "" + ((count)) + "" + (" to his maxmana.")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent((("\u00A7aAdded ") + "" + ((count)) + "" + (" to your maxmana."))), (false));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent("\u00A74Use /mana help syntax, more information on my Discord."), (false));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("remove"))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("mana"))) {
				count = (double) ((count) - (count));
				Hk400testMod.LOGGER
						.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" removed: ") + "" + ((count)) + "" + (" from his mana.")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity)
							.sendStatusMessage(new StringTextComponent((("\u00A7aRemoved ") + "" + ((count)) + "" + (" from your mana."))), (false));
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("maxmana"))) {
				count = (double) ((count) - (count));
				Hk400testMod.LOGGER
						.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" removed: ") + "" + ((count)) + "" + (" from his maxmana.")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent((("\u00A7aRemoved ") + "" + ((count)) + "" + (" from your maxmana."))), (false));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74Use /mana help syntax, more information on my Discord"),
							(false));
				}
			}
		} else if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("reset"))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("mana"))) {
				count = (double) 100;
				Hk400testMod.LOGGER.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" resetedhis mana.")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aReseted your mana."), (false));
				}
			} else if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("maxmana"))) {
				count = (double) 100;
				Hk400testMod.LOGGER.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" resetedhis maxmana.")));
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aReseted your maxmana."), (false));
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74Use /mana help syntax, more information on my Discord"),
							(false));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74Use /mana help syntax, more information on my Discord."),
						(false));
			}
		}
	}
}

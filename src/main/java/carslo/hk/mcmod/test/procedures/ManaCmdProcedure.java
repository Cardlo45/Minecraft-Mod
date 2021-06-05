package carslo.hk.mcmod.test.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;
import carslo.hk.mcmod.test.Hk400testMod;

@Hk400testModElements.ModElement.Tag
public class ManaCmdProcedure extends Hk400testModElements.ModElement {
	public ManaCmdProcedure(Hk400testModElements instance) {
		super(instance, 36);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Hk400testMod.LOGGER.warn("Failed to load dependency entity for procedure ManaCmd!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				Hk400testMod.LOGGER.warn("Failed to load dependency cmdparams for procedure ManaCmd!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double count = 0;
		String type = "";
		String logplayer = "";
		String exeplayer = "";
		exeplayer = (String) (entity.getDisplayName().getString());
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("2");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).length() > 0)) {
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
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("/mana: {ben\u00F6tigt} [optional]"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Typen: Mana, MaxMana"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("help"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("set {Typ} {Anzahl}"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("add {Typ} {Anzahl}"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("remove {Typ} {Anzahl}"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("reset {Typ}"), (false));
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
					{
						double _setval = (double) (count);
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER
							.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" set his mana to: ") + "" + ((count)) + "" + (".")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity)
								.sendStatusMessage(new StringTextComponent((("\u00A7aMana zu: ") + "" + ((count)) + "" + (" gesetzt."))), (false));
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
					{
						double _setval = (double) (count);
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.maxmana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER
							.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" set his maxmana to: ") + "" + ((count)) + "" + (".")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity)
								.sendStatusMessage(new StringTextComponent((("\u00A7aMaxMana zu: ") + "" + ((count)) + "" + (" gesetzt."))), (false));
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A74Nutz /mana help f\u00FCr Befehls-Syntax. Mehr Infos im Wiki."), (false));
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
					{
						double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).mana) + (count));
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER
							.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" added: ") + "" + ((count)) + "" + (" to his mana.")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent((("\u00A7a") + "" + ((count)) + "" + (" auf dein Mana draufgerechnet."))), (false));
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
					{
						double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).maxmana) + (count));
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.maxmana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER
							.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" added: ") + "" + ((count)) + "" + (" to his maxmana.")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent((("\u00A7a") + "" + ((count)) + "" + (" auf dein MaxMana draufgerechnet."))), (false));
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A74Nutz /mana help f\u00FCr Befehls-Syntax. Mehr Infos im Wiki."), (false));
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
					{
						double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).mana) - (count));
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER
							.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" removed: ") + "" + ((count)) + "" + (" from his mana.")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent((("\u00A7a") + "" + ((count)) + "" + (" von deiner Mana abgezogen."))), (false));
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
					{
						double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).maxmana) - (count));
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.maxmana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER.info(
							(("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" removed: ") + "" + ((count)) + "" + (" from his maxmana.")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent((("\u00A7a") + "" + ((count)) + "" + (" von deiner MaxMana abgezogen."))), (false));
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A74Nutz /mana help f\u00FCr Befehls-Syntax. Mehr Infos im Wiki."), (false));
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
					{
						double _setval = (double) 100;
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" resetedhis mana.")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aDeine Mana wurde auf den Standartwert gesetzt."),
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
					{
						double _setval = (double) 100;
						entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.maxmana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Hk400testMod.LOGGER.info((("\u00A76Mana Command: ") + "" + ((exeplayer)) + "" + (" resetedhis maxmana.")));
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aDeine MaxMana wurde auf den Standartwert gesetzt."),
								(false));
					}
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A74Nutz /mana help f\u00FCr Befehls-Syntax. Mehr Infos im Wiki."), (false));
					}
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent("\u00A74Nutz /mana help f\u00FCr Befehls-Syntax. Mehr Infos im Wiki."), (false));
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity)
						.sendStatusMessage(new StringTextComponent("\u00A74Nutz /mana help f\u00FCr Befehls-Syntax. Mehr Infos im Wiki."), (false));
			}
		}
	}
}

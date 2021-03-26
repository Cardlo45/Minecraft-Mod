package carslo.hk.mcmod.test.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class DeathProcedure extends Hk400testModElements.ModElement {
	public DeathProcedure(Hk400testModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Death!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure Death!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Death!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		IWorld world = (IWorld) dependencies.get("world");
		double count = 0;
		double x = 0;
		double y = 0;
		double z = 0;
		double power = 0;
		if (((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).contains("help"))) {
			for (int index0 = 0; index0 < (int) (1); index0++) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Death Command: {needed} [optional]"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("help: Show this help Page"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("help: /death help"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("explode: Let soemthing explode"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("explode: /death explode {count} {power} [{x} {y} {z}]"),
							(false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(
							new StringTextComponent(
									"explode: Count: Number of Explosions, Power: Power of explosions (Vanilla handling), X;Y;Z: Coopdinates"),
							(false));
				}
			}
		} else if (((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText()).contains("explode"))) {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("1");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).length() <= 0)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wrong Usage: use /death help for more Information."), (false));
				}
			} else {
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
						String param = (String) cmdparams.get("1");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText()));
				if ((((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("2");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())).length() <= 0)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wrong Usage: use /death help for more Information."),
								(false));
					}
				} else {
					power = (double) new Object() {
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
							String param = (String) cmdparams.get("3");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText())).length() <= 0)) {
						x = (double) (entity.getPosX());
						y = (double) (entity.getPosY());
						z = (double) (entity.getPosZ());
					} else {
						x = (double) new Object() {
							int convert(String s) {
								try {
									return Integer.parseInt(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("3");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText()));
						if ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("4");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())).length() <= 0)) {
							y = (double) (entity.getPosY());
							z = (double) (entity.getPosZ());
						} else {
							y = (double) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("4");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText()));
							if ((((new Object() {
								public String getText() {
									String param = (String) cmdparams.get("5");
									if (param != null) {
										return param;
									}
									return "";
								}
							}.getText())).length() <= 0)) {
								z = (double) (entity.getPosZ());
							} else {
								z = (double) new Object() {
									int convert(String s) {
										try {
											return Integer.parseInt(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("5");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText()));
								if ((((new Object() {
									public String getText() {
										String param = (String) cmdparams.get("6");
										if (param != null) {
											return param;
										}
										return "";
									}
								}.getText())).length() > 0)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("To many Arguments"), (false));
									}
								}
							}
						}
					}
					for (int index1 = 0; index1 < (int) ((count)); index1++) {
						if (world instanceof World && !world.getWorld().isRemote) {
							world.getWorld().createExplosion(null, (int) (x), (int) (y), (int) (z), (float) (power), Explosion.Mode.BREAK);
						}
					}
				}
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wrong Usage: use /death help for more Information."), (false));
			}
		}
	}
}

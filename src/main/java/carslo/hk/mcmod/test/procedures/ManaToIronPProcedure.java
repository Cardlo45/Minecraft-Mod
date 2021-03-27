package carslo.hk.mcmod.test.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class ManaToIronPProcedure extends Hk400testModElements.ModElement {
	public ManaToIronPProcedure(Hk400testModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ManaToIronP!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ManaToIronP!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ManaToIronP!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ManaToIronP!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ManaToIronP!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hk400testModVariables.PlayerVariables())).Mana) >= 10)) {
			{
				double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).Mana) - 10);
				entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.IRON_INGOT, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cDu hast nicht genug Mana"), (false));
			}
		}
	}
}

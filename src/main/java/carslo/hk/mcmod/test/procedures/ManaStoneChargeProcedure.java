package carslo.hk.mcmod.test.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import carslo.hk.mcmod.test.item.ManaStoneItem;
import carslo.hk.mcmod.test.item.InfusedManaStoneItem;
import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;
import carslo.hk.mcmod.test.Hk400testMod;

@Hk400testModElements.ModElement.Tag
public class ManaStoneChargeProcedure extends Hk400testModElements.ModElement {
	public ManaStoneChargeProcedure(Hk400testModElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Hk400testMod.LOGGER.warn("Failed to load dependency entity for procedure ManaStoneCharge!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Hk400testModVariables.PlayerVariables())).mana) >= 100)) {
			{
				double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).mana) - 100);
				entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ManaStoneItem.block, (int) (1));
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(InfusedManaStoneItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cDu hast nicht genug Mana"), (false));
			}
		}
	}
}

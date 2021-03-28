package carslo.hk.mcmod.test.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import carslo.hk.mcmod.test.item.ManaCookieItem;
import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class ManaCookieConsumedProcedure extends Hk400testModElements.ModElement {
	public ManaCookieConsumedProcedure(Hk400testModElements instance) {
		super(instance, 46);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ManaCookieConsumed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
				new Hk400testModVariables.PlayerVariables())).mana) <= ((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).maxmana))) {
			{
				double _setval = (double) (((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Hk400testModVariables.PlayerVariables())).mana) + 5);
				entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ManaCookieItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}

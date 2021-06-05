package carslo.hk.mcmod.test.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

import carslo.hk.mcmod.test.item.CreativetabItem;
import carslo.hk.mcmod.test.Hk400testModElements;
import carslo.hk.mcmod.test.Hk400testMod;

@Hk400testModElements.ModElement.Tag
public class CreativetabItemClearProcedure extends Hk400testModElements.ModElement {
	public CreativetabItemClearProcedure(Hk400testModElements instance) {
		super(instance, 23);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Hk400testMod.LOGGER.warn("Failed to load dependency entity for procedure CreativetabItemClear!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(CreativetabItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 999,
					((PlayerEntity) entity).container.func_234641_j_());
		}
	}
}

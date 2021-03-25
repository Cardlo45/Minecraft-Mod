package carslo.hk.mcmod.test.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class NewItemItemInInventoryTickProcedure extends Hk400testModElements.ModElement {
	public NewItemItemInInventoryTickProcedure(Hk400testModElements instance) {
		super(instance, 6);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NewItemItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		LivingEntity livingentity = (LivingEntity) dependencies.get("entity");
		if ((!(livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() > 30))) {
			livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH)
					.setBaseValue((livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + 0.1));
		} else {
			if (((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.REDSTONE, (int) (1)))
					: false)) {
				if ((livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() >= 30)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(Items.REDSTONE, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
					livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
				}
			}
		}
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {
		PlayerEntity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = event.getWorld();
		ItemStack itemstack = event.getFilledBucket();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("itemstack", itemstack);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}

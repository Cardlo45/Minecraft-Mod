package carslo.hk.mcmod.test.procedures;

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
					.setBaseValue((livingentity.getAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + 0.01));
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

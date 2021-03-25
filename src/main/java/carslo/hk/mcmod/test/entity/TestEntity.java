
package carslo.hk.mcmod.test.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class TestEntity extends Hk400testModElements.ModElement {
	public static EntityType entity = null;
	public TestEntity(Hk400testModElements instance) {
		super(instance, 3);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(1.5f, 1.5f)).build("test")
						.setRegistryName("test");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -13421773, -6710887, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("test_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 1.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("hk400test:textures/sheep-pig-chicken-mount.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			setCustomName(new StringTextComponent("Test"));
			setCustomNameVisible(true);
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.1, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.goalSelector.addGoal(2, new LookAtGoal(this, AgeableEntity.class, (float) 12));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean processInteract(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			boolean retval = true;
			super.processInteract(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		public void travel(Vec3d dir) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof LivingEntity) {
					this.setAIMoveSpeed((float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
					float forward = ((LivingEntity) entity).moveForward;
					float strafe = ((LivingEntity) entity).moveStrafing;
					super.travel(new Vec3d(strafe, 0, forward));
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(dir);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.7.1
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer Body;
		private final ModelRenderer Wing0;
		private final ModelRenderer Wing1;
		private final ModelRenderer Leg0;
		private final ModelRenderer Leg1;
		private final ModelRenderer Leg2;
		private final ModelRenderer Leg3;
		public Modelcustom_model() {
			textureWidth = 76;
			textureHeight = 76;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 24.0F, 0.0F);
			Head.setTextureOffset(0, 25).addBox(-4.0F, -22.5F, -19.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(12, 43).addBox(-4.5F, -20.5F, -16.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
			Head.setTextureOffset(12, 43).addBox(3.5F, -20.5F, -16.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
			Head.setTextureOffset(0, 11).addBox(-3.0F, -21.2F, -24.3F, 6.0F, 6.0F, 8.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(7.0F, 12.0F, -11.0F);
			Body.setTextureOffset(0, 42).addBox(-14.0F, -10.0F, 0.0F, 14.0F, 10.0F, 24.0F, 0.0F, false);
			Body.setTextureOffset(0, 61).addBox(-12.0F, -7.0F, 24.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			Body.setTextureOffset(0, 61).addBox(-5.0F, -7.0F, 24.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
			Wing0 = new ModelRenderer(this);
			Wing0.setRotationPoint(3.0F, 24.0F, 1.0F);
			setRotationAngle(Wing0, 0.0F, -0.2618F, 0.0F);
			Wing0.setTextureOffset(16, 25).addBox(-16.0F, -16.0F, -6.0F, 9.0F, 1.0F, 16.0F, 0.0F, false);
			Wing1 = new ModelRenderer(this);
			Wing1.setRotationPoint(19.0F, 24.0F, -5.0F);
			setRotationAngle(Wing1, 0.0F, 0.2618F, 0.0F);
			Wing1.setTextureOffset(16, 25).addBox(-16.0F, -16.0F, -6.0F, 9.0F, 1.0F, 16.0F, 0.0F, false);
			Leg0 = new ModelRenderer(this);
			Leg0.setRotationPoint(-5.0F, 15.0F, -8.0F);
			Leg0.setTextureOffset(0, 47).addBox(-1.5F, -3.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg0.setTextureOffset(12, 52).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			Leg0.setTextureOffset(0, 54).addBox(-1.5F, 6.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg1 = new ModelRenderer(this);
			Leg1.setRotationPoint(7.0F, 15.0F, -8.0F);
			Leg1.setTextureOffset(0, 47).addBox(-3.5F, -3.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg1.setTextureOffset(12, 52).addBox(-3.0F, -3.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			Leg1.setTextureOffset(0, 54).addBox(-3.5F, 6.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg2 = new ModelRenderer(this);
			Leg2.setRotationPoint(-5.0F, 15.0F, 8.0F);
			Leg2.setTextureOffset(0, 47).addBox(-1.5F, -3.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg2.setTextureOffset(12, 52).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			Leg2.setTextureOffset(0, 54).addBox(-1.5F, 6.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg3 = new ModelRenderer(this);
			Leg3.setRotationPoint(7.0F, 15.0F, 8.0F);
			Leg3.setTextureOffset(0, 47).addBox(-3.5F, -3.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			Leg3.setTextureOffset(12, 52).addBox(-3.0F, -3.0F, 0.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
			Leg3.setTextureOffset(0, 54).addBox(-3.5F, 6.1F, -0.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			Body.render(matrixStack, buffer, packedLight, packedOverlay);
			Wing0.render(matrixStack, buffer, packedLight, packedOverlay);
			Wing1.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg0.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg1.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg2.render(matrixStack, buffer, packedLight, packedOverlay);
			Leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Leg0.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Wing1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.Wing0.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}

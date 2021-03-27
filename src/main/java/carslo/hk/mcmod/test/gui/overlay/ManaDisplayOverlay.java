
package carslo.hk.mcmod.test.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import carslo.hk.mcmod.test.Hk400testModVariables;
import carslo.hk.mcmod.test.Hk400testModElements;

@Hk400testModElements.ModElement.Tag
public class ManaDisplayOverlay extends Hk400testModElements.ModElement {
	public ManaDisplayOverlay(Hk400testModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				Minecraft
						.getInstance().fontRenderer
								.drawString(
										"Level: " + ((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new Hk400testModVariables.PlayerVariables())).ManaLevel) + "",
										posX + -48, posY + -35, -3355444);
				Minecraft.getInstance().fontRenderer.drawString("Mana: "
						+ (int) ((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).Mana)
						+ "/" + (int) ((entity.getCapability(Hk400testModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Hk400testModVariables.PlayerVariables())).MaxMana)
						+ "", posX + -49, posY + -23, -3355444);
			}
		}
	}
}

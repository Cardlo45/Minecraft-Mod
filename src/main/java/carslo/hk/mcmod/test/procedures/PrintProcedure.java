package carslo.hk.mcmod.test.procedures;

@Hk400testModElements.ModElement.Tag
public class PrintProcedure extends Hk400testModElements.ModElement {

	public PrintProcedure(Hk400testModElements instance) {
		super(instance, 5);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {

		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent("Hello World"));
		}

	}

}

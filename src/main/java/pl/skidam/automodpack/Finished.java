package pl.skidam.automodpack;

import net.minecraft.client.MinecraftClient;

public class Finished {

    boolean AutoModpackUpdated;
    boolean ModpackUpdated;
    boolean Done;


    // TODO try make boolens public and use them there but call this class by AutoModpack.java


    public Finished(boolean Done, boolean AutoModpackUpdated, boolean ModpackUpdated) {

        this.AutoModpackUpdated = AutoModpackUpdated;
        this.ModpackUpdated = ModpackUpdated;
        this.Done = Done;

        if (Done) {
            Thread.currentThread().setPriority(10);

            AutoModpack.LOGGER.info("Here you are!");

            new ToastExecutor(7);

        }

        if (!AutoModpackUpdated || !ModpackUpdated) {
            return;
        }

        if (AutoModpackUpdated) {
            AutoModpack.LOGGER.info("AutoModpack updated!");
        }

        if (ModpackUpdated) {
            AutoModpack.LOGGER.info("Modpack updated!");
        }

        if (MinecraftClient.getInstance().currentScreen == null) {
            return;
        }

        MinecraftClient.getInstance().execute(() -> {
            MinecraftClient.getInstance().setScreen(new ConfirmScreen());
        });

    }
}

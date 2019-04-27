package xyz.brassgoggledcoders.techniques;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.input.Keyboard;
import xyz.brassgoggledcoders.techniques.gui.GuiTechniqueRadialMenu;

@EventBusSubscriber(modid = Techniques.ID, value = Side.CLIENT)
public class ClientEventHandler {
    public static final KeyBinding OPEN_GUI = new KeyBinding("techniques.key.gui.open",
            KeyConflictContext.UNIVERSAL, Keyboard.KEY_G, "Gameplay");

    static {
        ClientRegistry.registerKeyBinding(OPEN_GUI);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (OPEN_GUI.isKeyDown()) {
                if (Minecraft.getMinecraft().currentScreen == null) {
                    Minecraft.getMinecraft().displayGuiScreen(new GuiTechniqueRadialMenu());
                }
            }
        }
    }
}

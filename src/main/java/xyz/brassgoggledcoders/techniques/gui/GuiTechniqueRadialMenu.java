package xyz.brassgoggledcoders.techniques.gui;

import net.minecraft.client.Minecraft;

import java.io.IOException;

public class GuiTechniqueRadialMenu extends GuiRadialMenu {
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (mouseButton == 0) {
            Minecraft.getMinecraft().displayGuiScreen(null);
        }
    }
}

package xyz.brassgoggledcoders.techniques.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import xyz.brassgoggledcoders.techniques.ConfigHandler;

public class GuiRadialMenu extends GuiScreen {
    private static final double OUTER_RADIUS = 80;
    private static final double INNER_RADIUS = 60;
    private static final double ANGLE_PER_ITEM = 360F / 10;

    private final ScaledResolution scaledResolution;

    private int animationTimer;

    public GuiRadialMenu() {
        scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        animationTimer = 20;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (animationTimer > 0) {
            animationTimer--;
        }
        GlStateManager.pushMatrix();

        GlStateManager.disableTexture2D();

        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();

        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferBuilder = tessellator.getBuffer();

        double mouseAngle = AngleHelper.getMouseAngle();
        mouseAngle -= 270;
        mouseAngle = AngleHelper.correctAngle(mouseAngle);

        for (int i = 0; i < 10; i++) {
            double currAngle = ANGLE_PER_ITEM * i;
            double nextAngle = currAngle + ANGLE_PER_ITEM;
            currAngle = AngleHelper.correctAngle(currAngle);
            nextAngle = AngleHelper.correctAngle(nextAngle);

            boolean mouseIn = mouseAngle > currAngle && mouseAngle < nextAngle;

            currAngle = Math.toRadians(currAngle);
            nextAngle = Math.toRadians(nextAngle);

            double innerRadius = ((INNER_RADIUS - animationTimer - (mouseIn ? 2 : 0)) / 100F) * (257F / (float) scaledResolution.getScaledHeight());
            double outerRadius = ((OUTER_RADIUS - animationTimer + (mouseIn ? 2 : 0)) / 100F) * (257F / (float) scaledResolution.getScaledHeight());

            bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);

            float r, g, b, alpha;

            if (mouseIn) {
                r = (float) ConfigHandler.visual.selectRed / (float) 255;
                g = (float) ConfigHandler.visual.selectGreen / (float) 255;
                b = (float) ConfigHandler.visual.selectBlue / (float) 255;
                alpha = (float) ConfigHandler.visual.selectAlpha / (float) 255;
            } else {
                r = (float) ConfigHandler.visual.menuRed / (float) 255;
                g = (float) ConfigHandler.visual.menuGreen / (float) 255;
                b = (float) ConfigHandler.visual.menuBlue / (float) 255;
                alpha = (float) ConfigHandler.visual.menuAlpha / (float) 255;
            }

            bufferBuilder.pos(Math.cos(currAngle) * scaledResolution.getScaledHeight() / scaledResolution.getScaledWidth() * innerRadius, Math.sin(currAngle) * innerRadius, 0).color(r, g, b, alpha).endVertex();
            bufferBuilder.pos(Math.cos(currAngle) * scaledResolution.getScaledHeight() / scaledResolution.getScaledWidth() * outerRadius, Math.sin(currAngle) * outerRadius, 0).color(r, g, b, alpha).endVertex();
            bufferBuilder.pos(Math.cos(nextAngle) * scaledResolution.getScaledHeight() / scaledResolution.getScaledWidth() * outerRadius, Math.sin(nextAngle) * outerRadius, 0).color(r, g, b, alpha).endVertex();
            bufferBuilder.pos(Math.cos(nextAngle) * scaledResolution.getScaledHeight() / scaledResolution.getScaledWidth() * innerRadius, Math.sin(nextAngle) * innerRadius, 0).color(r, g, b, alpha).endVertex();

            tessellator.draw();
        }

        GlStateManager.popMatrix();
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.popMatrix();

        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();

        GlStateManager.popMatrix();
    }
}

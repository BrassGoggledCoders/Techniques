package xyz.brassgoggledcoders.techniques.gui;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

public class AngleHelper {
    public static double getMouseAngle() {
        Minecraft mc = Minecraft.getMinecraft();
        return getRelativeAngle(mc.displayWidth * 0.5D, mc.displayHeight * 0.5D, Mouse.getX(), Mouse.getY());
    }

    private static double getRelativeAngle(double originX, double originY, double x, double y) {
        double angle = -Math.toDegrees(Math.atan2(x - originX, y - originY));

        return correctAngle(angle);
    }

    public static double correctAngle(double angle) {
        if (angle < 0) {
            angle += 360;
        } else if (angle > 360) {
            angle -= 360;
        }
        return angle;
    }
}

package xyz.brassgoggledcoders.techniques;

import net.minecraftforge.common.config.Config;

@Config(modid = Techniques.ID)
public class ConfigHandler {
    public static Visual visual = new Visual();

    public static class Visual {
        @Config.RangeInt(min = 0, max = 255)
        public int selectRed = 255;
        @Config.RangeInt(min = 0, max = 255)
        public int selectBlue = 0;
        @Config.RangeInt(min = 0, max = 255)
        public int selectGreen = 0;
        @Config.RangeInt(min = 0, max = 255)
        public int selectAlpha = 153;

        @Config.RangeInt(min = 0, max = 255)
        public int menuRed = 0;
        @Config.RangeInt(min = 0, max = 255)
        public int menuBlue = 0;
        @Config.RangeInt(min = 0, max = 255)
        public int menuGreen = 0;
        @Config.RangeInt(min = 0, max = 255)
        public int menuAlpha = 153;
    }
}

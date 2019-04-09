package xyz.brassgoggledcoders.techniques;

import com.teamacronymcoders.base.BaseModFoundation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static xyz.brassgoggledcoders.techniques.Techniques.*;

@Mod(modid = ID, name = NAME, version = VERSION, dependencies = DEPEND)
public class Techniques extends BaseModFoundation<Techniques> {
    public static final String ID = "techniques";
    public static final String NAME = "Techniques";
    public static final String VERSION = "@VERSION@";
    public static final String DEPEND = "required-after:base[0.0.0,)";

    public Techniques() {
        super(ID, NAME, VERSION, CreativeTabs.MISC);
    }

    @Override
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    @EventHandler
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public Techniques getInstance() {
        return this;
    }
}

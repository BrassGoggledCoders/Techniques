package xyz.brassgoggledcoders.techniques;

import com.teamacronymcoders.base.BaseModFoundation;
import com.teamacronymcoders.base.registrysystem.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.techniques.api.techniquetool.BasicTechniqueTool;
import xyz.brassgoggledcoders.techniques.api.techniquetool.ITechniqueTool;
import xyz.brassgoggledcoders.techniques.api.techniqueuser.BasicTechniqueUser;
import xyz.brassgoggledcoders.techniques.api.techniqueuser.ITechniqueUser;
import xyz.brassgoggledcoders.techniques.item.ItemWhip;
import xyz.brassgoggledcoders.techniques.nbt.NBTEmptyStorage;

import static xyz.brassgoggledcoders.techniques.Techniques.*;

@Mod(modid = ID, name = NAME, version = VERSION, dependencies = DEPEND)
public class Techniques extends BaseModFoundation<Techniques> {
    public static final String ID = "techniques";
    public static final String NAME = "Techniques";
    public static final String VERSION = "@VERSION@";
    public static final String DEPEND = "required-after:base@[0.0.0,)";

    public Techniques() {
        super(ID, NAME, VERSION, CreativeTabs.MISC);
    }

    @Override
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        registerCapabilities();
    }

    @Override
    public void registerItems(ItemRegistry registry) {
        super.registerItems(registry);
        registry.register(new ItemWhip());
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
    public boolean hasConfig() {
        return false;
    }

    @Override
    public Techniques getInstance() {
        return this;
    }


    public void registerCapabilities() {
        CapabilityManager.INSTANCE.register(ITechniqueTool.class, new NBTEmptyStorage<>(), BasicTechniqueTool::new);
        CapabilityManager.INSTANCE.register(ITechniqueUser.class, new NBTEmptyStorage<>(), BasicTechniqueUser::new);
    }
}

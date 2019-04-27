package xyz.brassgoggledcoders.techniques.api;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import xyz.brassgoggledcoders.techniques.api.techniquetool.ITechniqueTool;
import xyz.brassgoggledcoders.techniques.api.techniqueuser.ITechniqueUser;

public class TechniqueCapabilities {
    @CapabilityInject(ITechniqueTool.class)
    public static Capability<ITechniqueTool> TOOL;

    @CapabilityInject(ITechniqueUser.class)
    public static Capability<ITechniqueUser> USER;
}

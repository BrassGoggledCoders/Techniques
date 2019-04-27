package xyz.brassgoggledcoders.techniques.api.techniquetool;

import xyz.brassgoggledcoders.techniques.api.technique.ITechnique;

import java.util.List;

public interface ITechniqueTool {
    List<ITechnique> allowedTechniques();

    boolean canPreformTechnique(ITechnique technique);
}

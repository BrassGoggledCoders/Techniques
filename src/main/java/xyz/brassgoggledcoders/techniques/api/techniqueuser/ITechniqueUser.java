package xyz.brassgoggledcoders.techniques.api.techniqueuser;

import gnu.trove.map.TIntObjectMap;
import xyz.brassgoggledcoders.techniques.api.technique.ITechnique;

import java.util.List;

public interface ITechniqueUser {
    ITechnique getActiveTechnique();

    void setActiveTechnique(ITechnique technique);

    TIntObjectMap<ITechnique> getQuickSelectTechniques();

    List<ITechnique> getLearnedTechniques();

    void learnTechnique(ITechnique technique);
}

package xyz.brassgoggledcoders.techniques.api.techniqueuser;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import xyz.brassgoggledcoders.techniques.api.technique.ITechnique;
import xyz.brassgoggledcoders.techniques.techniques.NoTechnique;

import java.util.ArrayList;
import java.util.List;

public class BasicTechniqueUser implements ITechniqueUser {
    private ITechnique activeTechnique;
    private TIntObjectMap<ITechnique> quickSelect;
    private ArrayList<ITechnique> learnedTechniques;

    public BasicTechniqueUser() {
        this.activeTechnique = new NoTechnique();
        this.quickSelect = new TIntObjectHashMap<>();
        this.learnedTechniques = new ArrayList<>();
    }

    @Override
    public ITechnique getActiveTechnique() {
        return activeTechnique;
    }

    @Override
    public void setActiveTechnique(ITechnique technique) {
        this.activeTechnique = technique;
    }

    @Override
    public TIntObjectMap<ITechnique> getQuickSelectTechniques() {
        return quickSelect;
    }

    @Override
    public List<ITechnique> getLearnedTechniques() {
        return learnedTechniques;
    }

    @Override
    public void learnTechnique(ITechnique technique) {
        this.learnedTechniques.add(technique);
    }
}

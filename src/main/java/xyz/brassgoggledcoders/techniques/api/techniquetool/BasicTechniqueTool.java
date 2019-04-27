package xyz.brassgoggledcoders.techniques.api.techniquetool;

import com.google.common.collect.Lists;
import xyz.brassgoggledcoders.techniques.api.technique.ITechnique;
import xyz.brassgoggledcoders.techniques.techniques.NoTechnique;

import java.util.List;

public class BasicTechniqueTool implements ITechniqueTool {
    private final List<ITechnique> allowedTechniques;

    public BasicTechniqueTool() {
        this(new NoTechnique());
    }

    public BasicTechniqueTool(ITechnique... allowedTechniques) {
        this(Lists.newArrayList(allowedTechniques));
    }

    public BasicTechniqueTool(List<ITechnique> allowedTechniques) {
        this.allowedTechniques = allowedTechniques;
    }

    @Override
    public List<ITechnique> allowedTechniques() {
        return this.allowedTechniques;
    }

    @Override
    public boolean canPreformTechnique(ITechnique technique) {
        return allowedTechniques.contains(technique);
    }
}

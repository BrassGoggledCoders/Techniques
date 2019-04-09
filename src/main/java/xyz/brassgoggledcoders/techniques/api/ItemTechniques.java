package xyz.brassgoggledcoders.techniques.api;

import java.util.List;

public interface ItemTechniques {
    List<Technique> allowedTechniques();

    boolean canPreformTechnique(Technique technique);
}

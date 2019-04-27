package xyz.brassgoggledcoders.techniques.techniques;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xyz.brassgoggledcoders.techniques.Techniques;
import xyz.brassgoggledcoders.techniques.api.Property;
import xyz.brassgoggledcoders.techniques.api.technique.ITechnique;

public class NoTechnique extends IForgeRegistryEntry.Impl<ITechnique> implements ITechnique {
    public NoTechnique() {
        this.setRegistryName(new ResourceLocation(Techniques.ID, "no"));
    }

    @Override
    public boolean perform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker, Property<Float> damage) {
        return false;
    }

    @Override
    public boolean canPerform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker) {
        return true;
    }
}

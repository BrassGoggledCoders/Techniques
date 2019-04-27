package xyz.brassgoggledcoders.techniques.techniques;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.techniques.Techniques;
import xyz.brassgoggledcoders.techniques.api.Property;
import xyz.brassgoggledcoders.techniques.api.technique.Technique;

public class UnarmedStrikeTechnique extends Technique {
    public UnarmedStrikeTechnique() {
        this.setRegistryName(new ResourceLocation(Techniques.ID, "unarmed_strike"));
    }

    @Override
    public boolean perform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker, Property<Float> damage) {
        damage.set(damage.get() * 1.25F);
        return false;
    }

    @Override
    public boolean canPerform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker) {
        return entityAttacker.getActiveItemStack().isEmpty();
    }
}

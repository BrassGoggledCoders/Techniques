package xyz.brassgoggledcoders.techniques.techniques;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.techniques.Techniques;
import xyz.brassgoggledcoders.techniques.api.Property;
import xyz.brassgoggledcoders.techniques.api.technique.Technique;

public class BlindingTrickTechnique extends Technique {
    public BlindingTrickTechnique() {
        this.setRegistryName(new ResourceLocation(Techniques.ID, "blinding_trick"));
    }

    @Override
    public boolean perform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker, Property<Float> damage) {
        entityTarget.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 400));
        return true;
    }
}

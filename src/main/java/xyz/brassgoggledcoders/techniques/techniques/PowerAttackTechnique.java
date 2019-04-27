package xyz.brassgoggledcoders.techniques.techniques;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import xyz.brassgoggledcoders.techniques.Techniques;
import xyz.brassgoggledcoders.techniques.api.Property;
import xyz.brassgoggledcoders.techniques.api.technique.Technique;

import java.util.Random;

public class PowerAttackTechnique extends Technique {
    private final Random random = new Random();

    public PowerAttackTechnique() {
        this.setRegistryName(new ResourceLocation(Techniques.ID, "power_attack"));
    }

    @Override
    public boolean perform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker, Property<Float> damage) {
        if (random.nextDouble() > 0.4) {
            damage.set(damage.get() * 2);
            return false;
        } else {
            return true;
        }
    }
}

package xyz.brassgoggledcoders.techniques.api.technique;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xyz.brassgoggledcoders.techniques.api.Property;
import xyz.brassgoggledcoders.techniques.api.TechniqueCapabilities;
import xyz.brassgoggledcoders.techniques.api.techniquetool.ITechniqueTool;

public interface ITechnique extends IForgeRegistryEntry<ITechnique> {
    /**
     * @param entityTarget Entity being attacked
     * @param entityAttacker Entity in the process of attacking
     * @param damage Property representing the damage the entity will be taking
     *
     * @return whether or not to cancel the current LivingDamageEvent
     */
    boolean perform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker, Property<Float> damage);

    /**
     * @param entityTarget Entity being attacked
     * @param entityAttacker Entity in the process of attacking
     *
     * @return whether the Entity can Perform this Technique on this
     */
    default boolean canPerform(EntityLivingBase entityTarget, EntityLivingBase entityAttacker) {
        ItemStack usedWeapon = entityAttacker.getActiveItemStack();
        if (!usedWeapon.isEmpty()) {
            ITechniqueTool tool = usedWeapon.getCapability(TechniqueCapabilities.TOOL, null);
            if (tool != null) {
                return tool.canPreformTechnique(this);
            }
        }
        return false;
    }
}

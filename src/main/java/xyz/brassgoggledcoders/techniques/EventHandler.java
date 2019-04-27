package xyz.brassgoggledcoders.techniques;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.RegistryBuilder;
import xyz.brassgoggledcoders.techniques.api.Property;
import xyz.brassgoggledcoders.techniques.api.TechniqueCapabilities;
import xyz.brassgoggledcoders.techniques.api.technique.ITechnique;
import xyz.brassgoggledcoders.techniques.techniques.NoTechnique;
import xyz.brassgoggledcoders.techniques.api.techniqueuser.ITechniqueUser;
import xyz.brassgoggledcoders.techniques.techniques.BlindingTrickTechnique;
import xyz.brassgoggledcoders.techniques.techniques.PowerAttackTechnique;
import xyz.brassgoggledcoders.techniques.techniques.UnarmedStrikeTechnique;

@EventBusSubscriber(modid = Techniques.ID)
public class EventHandler {
    @SubscribeEvent
    public static void createTechniqueRegistry(RegistryEvent.NewRegistry newRegistryEvent) {
        new RegistryBuilder<ITechnique>()
                .setDefaultKey(new ResourceLocation(Techniques.ID, "no"))
                .setName(new ResourceLocation(Techniques.ID, "techniques"))
                .setType(ITechnique.class)
                .create();
    }

    @SubscribeEvent
    public static void registerTechniques(RegistryEvent.Register<ITechnique> techniqueRegistryEvent) {
        techniqueRegistryEvent.getRegistry().registerAll(
                new NoTechnique(),
                new BlindingTrickTechnique(),
                new PowerAttackTechnique(),
                new UnarmedStrikeTechnique()
        );
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onEntityAttacked(LivingDamageEvent event) {
        Entity attackingEntity = event.getSource().getTrueSource();
        if (attackingEntity instanceof EntityLivingBase) {
            ITechniqueUser user = attackingEntity.getCapability(TechniqueCapabilities.USER, null);
            if (user != null) {
                ITechnique activeTechnique = user.getActiveTechnique();
                EntityLivingBase targetedEntity = event.getEntityLiving();
                EntityLivingBase attackingEntityLiving = (EntityLivingBase) attackingEntity;
                if (activeTechnique.canPerform(targetedEntity, attackingEntityLiving)) {
                    if (user.getActiveTechnique().perform(targetedEntity, attackingEntityLiving,
                            new Property<>(event::getAmount, event::setAmount))) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}

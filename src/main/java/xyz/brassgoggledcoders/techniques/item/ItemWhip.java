package xyz.brassgoggledcoders.techniques.item;

import com.google.common.collect.Multimap;
import com.teamacronymcoders.base.items.IRightClickEntity;
import com.teamacronymcoders.base.items.ItemBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemWhip extends ItemBase implements IRightClickEntity {
    public ItemWhip() {
        super("whip");
    }

    @Override
    public boolean rightClickEntity(ItemStack itemStack, Entity target, EntityPlayer entityPlayer, World entityWorld, EnumHand hand) {
        entityPlayer.attackTargetEntityWithCurrentItem(target);
        return true;
    }

    @Override
    @Nonnull
    @SuppressWarnings("deprecation")
    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 4D, 0));
        } else {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 2D, 0));
        }

        multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));

        return multimap;
    }
}

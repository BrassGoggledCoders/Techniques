package xyz.brassgoggledcoders.techniques.api;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public interface Technique {
    boolean apply(Entity entity, EntityPlayer entityPlayer);
}

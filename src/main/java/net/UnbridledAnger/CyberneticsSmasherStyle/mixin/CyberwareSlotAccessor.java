package net.UnbridledAnger.CyberneticsSmasherStyle.mixin;

import com.perigrine3.createcybernetics.api.CyberwareSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = CyberwareSlot.class, remap = false)
public interface CyberwareSlotAccessor {

    @Mutable
    @Accessor(value = "size", remap = false)
    void smasherstyle$setSize(int size);
}
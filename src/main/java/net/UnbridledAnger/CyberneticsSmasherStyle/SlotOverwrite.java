
package net.UnbridledAnger.CyberneticsSmasherStyle;

import com.perigrine3.createcybernetics.api.CyberwareSlot;
import net.UnbridledAnger.CyberneticsSmasherStyle.mixin.CyberwareSlotAccessor;

public final class SlotOverwrite {

    private SlotOverwrite() {
    }

    public static void apply() {
        setCapacity(CyberwareSlot.BRAIN, Config.BRAIN_CAPACITY.get());
        setCapacity(CyberwareSlot.EYES, Config.EYES_CAPACITY.get());
        setCapacity(CyberwareSlot.HEART, Config.HEART_CAPACITY.get());
        setCapacity(CyberwareSlot.LUNGS, Config.LUNGS_CAPACITY.get());
        setCapacity(CyberwareSlot.ORGANS, Config.ORGANS_CAPACITY.get());

        setCapacity(CyberwareSlot.RARM, Config.RIGHT_ARM_CAPACITY.get());
        setCapacity(CyberwareSlot.LARM, Config.LEFT_ARM_CAPACITY.get());
        setCapacity(CyberwareSlot.RLEG, Config.RIGHT_LEG_CAPACITY.get());
        setCapacity(CyberwareSlot.LLEG, Config.LEFT_LEG_CAPACITY.get());

        setCapacity(CyberwareSlot.MUSCLE, Config.MUSCLE_CAPACITY.get());
        setCapacity(CyberwareSlot.BONE, Config.BONE_CAPACITY.get());
        setCapacity(CyberwareSlot.SKIN, Config.SKIN_CAPACITY.get());
    }

    private static void setCapacity(CyberwareSlot slot, int capacity) {
        ((CyberwareSlotAccessor) (Object) slot)
                .smasherstyle$setSize(capacity);
    }
}

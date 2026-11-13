
package net.UnbridledAnger.CyberneticsSmasherStyle;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    private static final ModConfigSpec.Builder BUILDER =
            new ModConfigSpec.Builder();

    static {
        BUILDER.push("cyberware_capacity");

        BRAIN_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the brain.")
                .defineInRange("brainCapacity", 10, 5, 100);

        EYES_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the eyes.")
                .defineInRange("eyesCapacity", 10, 5, 100);

        HEART_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the heart.")
                .defineInRange("heartCapacity", 12, 6, 100);

        LUNGS_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the lungs.")
                .defineInRange("lungsCapacity", 12, 6, 100);

        ORGANS_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the organs.")
                .defineInRange("organsCapacity", 12, 6, 100);

        RIGHT_ARM_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the right arm.")
                .defineInRange("rightArmCapacity", 12, 6, 100);

        LEFT_ARM_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the left arm.")
                .defineInRange("leftArmCapacity", 12, 6, 100);

        RIGHT_LEG_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the right leg.")
                .defineInRange("rightLegCapacity", 10, 5, 100);

        LEFT_LEG_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the left leg.")
                .defineInRange("leftLegCapacity", 10, 5, 100);

        MUSCLE_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the muscles.")
                .defineInRange("muscleCapacity", 10, 5, 100);

        BONE_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the bones.")
                .defineInRange("boneCapacity", 10, 5, 100);

        SKIN_CAPACITY = BUILDER
                .comment("Maximum cyberware slots for the skin.")
                .defineInRange("skinCapacity", 10, 5, 100);

        BUILDER.pop();
    }

    public static final ModConfigSpec.IntValue BRAIN_CAPACITY;
    public static final ModConfigSpec.IntValue EYES_CAPACITY;
    public static final ModConfigSpec.IntValue HEART_CAPACITY;
    public static final ModConfigSpec.IntValue LUNGS_CAPACITY;
    public static final ModConfigSpec.IntValue ORGANS_CAPACITY;
    public static final ModConfigSpec.IntValue RIGHT_ARM_CAPACITY;
    public static final ModConfigSpec.IntValue LEFT_ARM_CAPACITY;
    public static final ModConfigSpec.IntValue RIGHT_LEG_CAPACITY;
    public static final ModConfigSpec.IntValue LEFT_LEG_CAPACITY;
    public static final ModConfigSpec.IntValue MUSCLE_CAPACITY;
    public static final ModConfigSpec.IntValue BONE_CAPACITY;
    public static final ModConfigSpec.IntValue SKIN_CAPACITY;

    public static final ModConfigSpec SERVER_SPEC = BUILDER.build();

}

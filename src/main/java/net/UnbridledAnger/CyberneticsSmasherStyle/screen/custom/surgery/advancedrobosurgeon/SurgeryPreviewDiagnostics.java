package net.UnbridledAnger.CyberneticsSmasherStyle.screen.custom.surgery.advancedrobosurgeon;

import com.perigrine3.createcybernetics.common.capabilities.PlayerCyberwareData;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Local preview data for the independent Advanced Robosurgeon screen.
 * Kept in the addon so the screen does not depend on the original Robosurgeon's
 * client-only diagnostics implementation.
 */
public final class SurgeryPreviewDiagnostics {
    private SurgeryPreviewDiagnostics() {}

    public record EnergyPreview(int generatedPerTick, int requiredPerTick, boolean sufficient) {}

    public record Preview(List<Component> warnings, EnergyPreview energy) {
        public Preview {
            warnings = List.copyOf(warnings);
        }

        public boolean hasWarnings() {
            return !warnings.isEmpty();
        }
    }

    public static Preview emptyPreview() {
        return new Preview(List.of(), new EnergyPreview(0, 100, false));
    }

    public static Preview analyze(
            Player player,
            PlayerCyberwareData data,
            Function<Integer, ItemStack> stackLookup,
            Predicate<Integer> isStaged,
            Predicate<Integer> isMarkedForRemoval
    ) {
        // The detailed diagnostic analyzer is owned by the upstream screen. The
        // independent screen retains its own warning list and energy display.
        return emptyPreview();
    }

    public static Preview addWarning(Preview preview, Component warning) {
        List<Component> warnings = new ArrayList<>(preview.warnings());
        warnings.add(warning);
        return new Preview(warnings, preview.energy());
    }
}

package net.UnbridledAnger.CyberneticsSmasherStyle.screen.custom.surgery.advancedrobosurgeon;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class AdvancedRobosurgeonMarkerManager {

    public static class AdvancedRobosurgeonMarker {

        public final int offX, offY;
        public final AdvancedRobosurgeonScreen.ViewMode parent;
        public final AdvancedRobosurgeonScreen.ViewMode target;
        public final Component tooltip;
        public final boolean animated;

        public AdvancedRobosurgeonMarker(int x, int y, AdvancedRobosurgeonScreen.ViewMode parent,
                      AdvancedRobosurgeonScreen.ViewMode target, Component tip,
                      boolean animated) {

            this.offX = x;
            this.offY = y;
            this.parent = parent;
            this.target = target;
            this.tooltip = tip;
            this.animated = animated;
        }

        public AdvancedRobosurgeonMarker(int x, int y, AdvancedRobosurgeonScreen.ViewMode parent,
                      AdvancedRobosurgeonScreen.ViewMode target, Component tip) {

            this(x, y, parent, target, tip, true);
        }
    }

    private final List<AdvancedRobosurgeonMarker> markers = new ArrayList<>();
    private AdvancedRobosurgeonMarker hovered = null;
    private final ResourceLocation icon;

    private boolean enabled = true;

    public AdvancedRobosurgeonMarkerManager(ResourceLocation iconTexture) {
        this.icon = iconTexture;
    }

    public void add(AdvancedRobosurgeonMarker marker) {
        markers.add(marker);
    }

    public void clear() {
        markers.clear();
    }

    public AdvancedRobosurgeonMarker getHovered() {
        return hovered;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (!enabled) hovered = null;
    }

    public void render(GuiGraphics gui, int modelX, int modelY,
                       double mouseX, double mouseY,
                       AdvancedRobosurgeonScreen.ViewMode viewMode, float markerPhase,
                       Font font) {

        if (!enabled) {
            hovered = null;
            return;
        }

        RenderSystem.setShaderTexture(0, icon);
        hovered = null;

        for (AdvancedRobosurgeonMarker marker : markers) {

            boolean visible = marker.parent == viewMode;
            if (!visible) continue;

            int px = modelX + marker.offX;
            int py = modelY + marker.offY;

            float amp =
                    (marker.parent == AdvancedRobosurgeonScreen.ViewMode.FULL_BODY &&
                            (marker.target == AdvancedRobosurgeonScreen.ViewMode.LARM ||
                                    marker.target == AdvancedRobosurgeonScreen.ViewMode.RARM)) ? 30f :
                            (marker.parent == AdvancedRobosurgeonScreen.ViewMode.FULL_BODY &&
                                    (marker.target == AdvancedRobosurgeonScreen.ViewMode.LLEG ||
                                            marker.target == AdvancedRobosurgeonScreen.ViewMode.RLEG)) ? 14f :
                                    4f;

            if (marker.animated && viewMode.allowMarkerAnimation) {
                float offset =
                        (marker.parent == AdvancedRobosurgeonScreen.ViewMode.FULL_BODY &&
                                (marker.target == AdvancedRobosurgeonScreen.ViewMode.LLEG ||
                                        marker.target == AdvancedRobosurgeonScreen.ViewMode.RLEG) &&
                                marker.offX == -2)
                                ? -amp * markerPhase
                                : amp * ((marker.offX > 0) ? -markerPhase : markerPhase);

                px += (int) offset;
            }

            if (mouseX >= px && mouseX <= px + 16 && mouseY >= py && mouseY <= py + 16)
                hovered = marker;

            gui.pose().pushPose();
            gui.pose().translate(0, 0, 200);

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();

            float alpha = (hovered == marker) ? 1f : 0.2f;
            gui.setColor(1f, 1f, 1f, alpha);

            gui.blit(icon, px, py, 0, 0, 16, 16, 16, 16);

            gui.setColor(1f, 1f, 1f, 1f);
            RenderSystem.disableBlend();
            gui.pose().popPose();
        }

        if (hovered != null)
            gui.renderTooltip(font, hovered.tooltip, (int) mouseX, (int) mouseY);
    }

    public AdvancedRobosurgeonScreen.ViewMode tryClick(double mouseX, double mouseY,
                                               int modelX, int modelY, float markerPhase,
                                               AdvancedRobosurgeonScreen.ViewMode viewMode) {

        if (!enabled) return null;

        for (AdvancedRobosurgeonMarker marker : markers) {

            boolean visible = marker.parent == viewMode;
            if (!visible) continue;

            int px = modelX + marker.offX;
            int py = modelY + marker.offY;

            float amp =
                    (marker.parent == AdvancedRobosurgeonScreen.ViewMode.FULL_BODY &&
                            (marker.target == AdvancedRobosurgeonScreen.ViewMode.LARM ||
                                    marker.target == AdvancedRobosurgeonScreen.ViewMode.RARM)) ? 30f :
                            (marker.parent == AdvancedRobosurgeonScreen.ViewMode.FULL_BODY &&
                                    (marker.target == AdvancedRobosurgeonScreen.ViewMode.LLEG ||
                                            marker.target == AdvancedRobosurgeonScreen.ViewMode.RLEG)) ? 14f :
                                    4f;

            if (marker.animated && viewMode.allowMarkerAnimation) {
                float offset =
                        (marker.parent == AdvancedRobosurgeonScreen.ViewMode.FULL_BODY &&
                                (marker.target == AdvancedRobosurgeonScreen.ViewMode.LLEG ||
                                        marker.target == AdvancedRobosurgeonScreen.ViewMode.RLEG) &&
                                marker.offX == -2)
                                ? -amp * markerPhase
                                : amp * ((marker.offX > 0) ? -markerPhase : markerPhase);

                px += (int) offset;
            }

            if (mouseX >= px && mouseX <= px + 16 &&
                    mouseY >= py && mouseY <= py + 16)
                return marker.target;
        }
        return null;
    }
}
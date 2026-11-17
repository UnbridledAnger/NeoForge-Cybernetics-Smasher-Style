package net.UnbridledAnger.CyberneticsSmasherStyle.client;

import net.UnbridledAnger.CyberneticsSmasherStyle.SmasherStyle;
import net.UnbridledAnger.CyberneticsSmasherStyle.screen.ModMenuTypes;
import net.UnbridledAnger.CyberneticsSmasherStyle.screen.custom.surgery.advancedrobosurgeon.AdvancedRobosurgeonScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = SmasherStyle.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
    private ClientModEvents() {}

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.ADVANCED_ROBOSURGEON_MENU.get(), AdvancedRobosurgeonScreen::new);
    }
}

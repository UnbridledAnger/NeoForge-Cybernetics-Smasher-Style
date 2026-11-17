package net.UnbridledAnger.CyberneticsSmasherStyle.screen;

import net.UnbridledAnger.CyberneticsSmasherStyle.SmasherStyle;
import net.UnbridledAnger.CyberneticsSmasherStyle.screen.custom.surgery.advancedrobosurgeon.AdvancedRobosurgeonMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, SmasherStyle.MODID);

    public static final DeferredHolder<MenuType<?>, MenuType<AdvancedRobosurgeonMenu>> ADVANCED_ROBOSURGEON_MENU =
            registerMenuType("advanced_robosurgeon_menu", AdvancedRobosurgeonMenu::new);

    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
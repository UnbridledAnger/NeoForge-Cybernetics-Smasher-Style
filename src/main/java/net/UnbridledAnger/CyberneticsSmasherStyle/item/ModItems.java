package net.UnbridledAnger.CyberneticsSmasherStyle.item;

import net.UnbridledAnger.CyberneticsSmasherStyle.SmasherStyle;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS=DeferredRegister.createItems(SmasherStyle.MODID);

    public static final DeferredItem<Item> netherite_leg=ITEMS.register("Netherite Leg",
            ()->new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


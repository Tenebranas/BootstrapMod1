package com.example.examplemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.example.examplemod.ExampleMod;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> SUPERSTICK = ITEMS.register("superstick",
            ()->new SuperStickItem(new Item.Properties().stacksTo(1)
                    .tab(ModCreativeModeTab.EXAMPLE_TAB)
                    .durability(128)
                    .setNoRepair()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

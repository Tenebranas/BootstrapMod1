package com.example.examplemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab EXAMPLE_TAB = new CreativeModeTab("examplemodtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SUPERSTICK.get());
        }
    };
}

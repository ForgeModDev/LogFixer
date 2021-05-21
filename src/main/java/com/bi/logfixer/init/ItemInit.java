package com.bi.logfixer.init;

import com.bi.logfixer.LogFixer;
import com.bi.logfixer.entities.ModdedSpawnEggItem;
import com.bi.logfixer.items.SocketItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LogFixer.MOD_ID);
    public static final DeferredRegister<Item> SPAWN_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, LogFixer.MOD_ID);

    // Items
    public static final RegistryObject<Item> SOCKET = ITEMS.register("socket", () -> new SocketItem(new Item.Properties()));

    // Spawn eggs
    public static final RegistryObject<Item> FAKE_WITHER_SPAWN_EGG = SPAWN_EGGS.register("wither_spawn_egg", () -> new ModdedSpawnEggItem(EntityInit.FAKE_WITHER, 0xc3366, 0x091329, new Item.Properties()));
}
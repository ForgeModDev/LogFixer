package com.bi.logfixer.init;

import com.bi.logfixer.LogFixer;
import com.bi.logfixer.entities.FakeWitherEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class EntityInit {

    private static boolean isInitialised;

    public static void initialise(final IEventBus modEventBus) {
        if (isInitialised) {
            throw new IllegalStateException("Already initialised");
        }

        ENTITIES.register(modEventBus);

        isInitialised = true;
    }

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, LogFixer.MOD_ID);

    public static final RegistryObject<EntityType<FakeWitherEntity>> FAKE_WITHER = registerEntityType("fake_wither",
            () -> EntityType.Builder.<FakeWitherEntity>of((FakeWitherEntity::new), EntityClassification.MISC)
                    .sized(0.5f, 0.5f)
    );

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntityType(final String name, final Supplier<EntityType.Builder<T>> factory) {
        return ENTITIES.register(name,
                () -> factory.get().build(new ResourceLocation(LogFixer.MOD_ID, name).toString())
        );
    }
}
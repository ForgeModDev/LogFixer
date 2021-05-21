package com.bi.logfixer.client.renderer;

import com.bi.logfixer.LogFixer;
import com.bi.logfixer.init.EntityInit;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LogFixer.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModRenderers {

    @SubscribeEvent
    public static void register(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityInit.FAKE_WITHER.get(),
                renderManager -> new RenderFakeWither(renderManager, ((IReloadableResourceManager) Minecraft.getInstance().getResourceManager()), new ResourceLocation(LogFixer.MOD_ID, "logfixer:textures/items/socket.png")));
    }
}
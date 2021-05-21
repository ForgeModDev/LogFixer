package com.bi.logfixer.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;

public class RenderFakeWither extends VillagerRenderer {
    private final ResourceLocation entityTexture;

    public RenderFakeWither(final EntityRendererManager rendererManager, final IReloadableResourceManager reloadableResourceManager, final ResourceLocation entityTexture) {
        super(rendererManager, reloadableResourceManager);
        this.entityTexture = entityTexture;
    }

    @Override
    public ResourceLocation getTextureLocation(final VillagerEntity villagerEntity) {
        return entityTexture;
    }
}
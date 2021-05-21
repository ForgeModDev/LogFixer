package com.bi.logfixer.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class FakeWitherEntity extends VillagerEntity {

    public FakeWitherEntity(final EntityType<? extends FakeWitherEntity> entityType, final World world) {
        super(entityType, world);
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        player.sendMessage(new TranslationTextComponent(player.getName() + " Clicked The Fake Villager Entity!"), player.getUUID());
        return super.mobInteract(player, hand);
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return VillagerEntity.createAttributes();
    }
}
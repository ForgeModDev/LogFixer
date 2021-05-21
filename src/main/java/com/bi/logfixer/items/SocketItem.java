package com.bi.logfixer.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collection;

public class SocketItem extends Item {

    public static String loadedPlayerName = "No one";
    private int playerSocketIndex = -2;

    public SocketItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (Thread.currentThread().getName().equals("Render thread")) {
            Collection<NetworkPlayerInfo> playersCollection = Minecraft.getInstance().getConnection().getOnlinePlayers();
            ArrayList<NetworkPlayerInfo> playerList = new ArrayList<>(playersCollection);
            if (playerSocketIndex < playersCollection.size() - 1) {
                if (loadedPlayerName.equalsIgnoreCase("No one")) {
                    playerSocketIndex++;
                    loadedPlayerName = "Everyone";
                }
                else {
                    playerSocketIndex++;
                    loadedPlayerName = playerList.get(playerSocketIndex).getProfile().getName();
                }
            }
            else {
                playerSocketIndex = -2;
                loadedPlayerName = "No one";
            }
            player.sendMessage(new TranslationTextComponent("Socket now attached to: " + loadedPlayerName), player.getUUID());
        }
        return super.use(world, player, hand);
    }
}
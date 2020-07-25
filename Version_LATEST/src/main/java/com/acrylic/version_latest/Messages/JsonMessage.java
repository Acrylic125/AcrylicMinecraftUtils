package com.acrylic.version_latest.Messages;

import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class JsonMessage {

    private TextComponent msg;

    public JsonMessage() {
        msg = new TextComponent("");
    }

    public void send(Player p) {
        p.spigot().sendMessage(msg);
    }

    public void broadcast() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            send(p);
        }
    }

    public JsonMessage setMessage(String message) {
        TextComponent msg = new TextComponent(ChatUtils.get(message));
        this.msg.addExtra(msg);
        return this;
    }

    public JsonMessage setHoverText(String message, String hover) {
        TextComponent msg = new TextComponent(ChatUtils.get(message));
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatUtils.get(hover)).create()));
        this.msg.addExtra(msg);
        return this;
    }

    public JsonMessage setHoverText(String hover) {
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatUtils.get(hover)).create()));
        this.msg.addExtra(msg);
        return this;
    }

    public JsonMessage setItem(String message, ItemStack item) {
        TextComponent msg = new TextComponent(ChatUtils.get(message));
        //msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new ComponentBuilder(ChatUtils.get(hover)).create()));
        this.msg.addExtra(msg);
        return this;
    }

    public JsonMessage setItem(String hover) {
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatUtils.get(hover)).create()));
        this.msg.addExtra(msg);
        return this;
    }
    //ew ComponentBuilder("{name:\"" + player.getName() + "\", type:\"Player\", id:\"" + player.getUniqueId() + "\"}").create())).create())

    public JsonMessage setEntity(String message, Entity entity) {
        TextComponent msg = new TextComponent(ChatUtils.get(message));
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new ComponentBuilder(ChatUtils.get("{name:\"" + entity.getName() + "\", type:\"" + entity.getType() + "\", id:\"" + entity.getUniqueId() + "\"}")).create()));
        this.msg.addExtra(msg);
        return this;
    }

    public JsonMessage setEntity(Entity entity) {
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ENTITY, new ComponentBuilder(ChatUtils.get("{name:\"" + entity.getName() + "\", type:\"" + entity.getType() + "\", id:\"" + entity.getUniqueId() + "\"}")).create()));
        this.msg.addExtra(msg);
        return this;
    }
}

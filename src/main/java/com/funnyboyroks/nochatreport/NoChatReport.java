package com.funnyboyroks.nochatreport;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoChatReport extends JavaPlugin {

    public static NoChatReport instance;

    public NoChatReport() {
        instance = this;
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {

    }
}

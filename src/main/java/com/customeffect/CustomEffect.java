package com.customeffect;

import net.advancedplugins.ae.api.AEAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomEffect extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Registering Custom AE Effect...");
        AEAPI.registerEffect(this, "Void Domain",new VoidDomain());
        getLogger().info("Custom AE Effect enabled.");
    }
}

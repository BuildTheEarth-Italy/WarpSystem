package org.bteitaly.warps;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bteitaly.warps.util.LangUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class WarpSystem extends JavaPlugin {
    @Getter
    private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // Load language files
        try {
            LangUtil.init();
            Bukkit.getConsoleSender().sendMessage(Component.text("Successfully loaded language files.", NamedTextColor.GREEN));
        } catch(Exception ex) {
            Bukkit.getLogger().log(Level.SEVERE,ex.getMessage(),ex);
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

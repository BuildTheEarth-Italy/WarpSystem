package org.bteitaly.warps;

import com.alpsbte.alpslib.io.config.ConfigNotImplementedException;
import com.alpsbte.alpslib.io.database.DatabaseConfigPaths;
import com.alpsbte.alpslib.io.database.DatabaseConnection;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bteitaly.warps.commands.AdminCommand;
import org.bteitaly.warps.commands.VisitCommand;
import org.bteitaly.warps.util.ConfigUtil;
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

        // Load Config
        try {
            ConfigUtil.init();
        } catch (ConfigNotImplementedException e) {
            Bukkit.getLogger().log(Level.SEVERE,e.getMessage(),e);
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        // Open Database connection
        DatabaseConnection.initializeDatabase(DatabaseConfigPaths.getConfig(ConfigUtil.getConfigInstance().configs[0]), true);

        // Load language files
        try {
            //  LangUtil.init();
            Bukkit.getConsoleSender().sendMessage(Component.text("Successfully loaded language files.", NamedTextColor.GREEN));
        } catch(Exception ex) {
            Bukkit.getLogger().log(Level.SEVERE,ex.getMessage(),ex);
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getCommand("visit").setExecutor(new VisitCommand());
        getCommand("visit").setTabCompleter(new VisitCommand()); // Probably not the best idea
        getCommand("warpadm").setExecutor(new AdminCommand());

    }


    @Override
    public void onDisable() {
        DatabaseConnection.shutdown();
    }

}

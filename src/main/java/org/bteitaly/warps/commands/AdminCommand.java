package org.bteitaly.warps.commands;

import org.bteitaly.warps.util.LangPaths;
import org.bteitaly.warps.util.LangUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (!(commandSender instanceof Player p)) return true;

        if (!p.hasPermission("bte.warp.admin")) {
            p.sendMessage(LangUtil.getInstance().get(p, LangPaths.Util.NO_PERMISSION));
            return true;
        }

        return false;
    }
}
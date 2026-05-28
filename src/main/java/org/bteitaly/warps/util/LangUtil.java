package org.bteitaly.warps.util;

import li.cinnazeyy.langlibs.core.LangLibAPI;
import li.cinnazeyy.langlibs.core.file.LanguageFile;
import li.cinnazeyy.langlibs.core.language.Language;
import li.cinnazeyy.langlibs.core.language.LanguageUtil;
import org.bteitaly.warps.WarpSystem;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class LangUtil extends LanguageUtil {
    private static LangUtil langUtilInstance;

    public static void init() {
        if (langUtilInstance != null) return;
        Plugin plugin = WarpSystem.getPlugin();
        LangLibAPI.register(plugin, new LanguageFile[]{
                new LanguageFile(plugin, 1.0, Language.en_GB),
                new LanguageFile(plugin, 1.0, Language.pt_PT),
                new LanguageFile(plugin, 1.0, Language.es_ES),
                new LanguageFile(plugin, 1.0, Language.it_IT)
        });
        langUtilInstance = new LangUtil();
    }

    public LangUtil() {
        super(WarpSystem.getPlugin());
    }

    public static LangUtil getInstance() {
        return langUtilInstance;
    }

    @Override
    public String get(CommandSender sender, String key) {
        return super.get(sender, key);
    }
}
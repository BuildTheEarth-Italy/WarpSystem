package org.bteitaly.warps.util;

import com.alpsbte.alpslib.io.config.ConfigNotImplementedException;
import com.alpsbte.alpslib.io.config.ConfigurationUtil;
import lombok.Getter;

import java.nio.file.Paths;

public class ConfigUtil {
    private ConfigUtil() {}

    @Getter
    private static ConfigurationUtil configInstance;

    public static void init() throws ConfigNotImplementedException {
        if (configInstance == null) {
            configInstance = new ConfigurationUtil(new ConfigurationUtil.ConfigFile[]{
                    new ConfigurationUtil.ConfigFile(Paths.get("config.yml"), 1.0, true)
            });
        }
    }
}
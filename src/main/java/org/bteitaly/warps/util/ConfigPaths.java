package org.bteitaly.warps.util;

public abstract class ConfigPaths {
    private ConfigPaths() {}

    private class Database {
        private Database()  {}
        private final String DATABASE = "database.";
        public final String URL = DATABASE + "url";
        private final String NAME = DATABASE + "db-name";
        private final String USER = DATABASE + "username";
        private final String PASSWORD = DATABASE + "password";
    }
}
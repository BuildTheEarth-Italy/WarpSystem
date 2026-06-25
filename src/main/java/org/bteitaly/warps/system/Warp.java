package org.bteitaly.warps.system;

import com.alpsbte.alpslib.io.database.DatabaseConnection;
import org.bteitaly.warps.WarpSystem;
import org.bukkit.Location;
import org.bukkit.World;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Warp {
    private final String name;
    
    private double x;
    private double y;
    private double z;
    private float pitch;
    private float yaw;
    private World world;
    private GeoLocation address;

    public Warp(String name) {
        this.name = name;
        try (ResultSet resultWarp = DatabaseConnection.getConnection()) {
            resultWarp.next();
        } catch (SQLException e) {
            WarpSystem.getPlugin().getComponentLogger().error("A coglione, c'è stato un errore");
        }

    }

    public Warp(GeoLocation address) {

    }

    public Location getLocation() {
        return new Location(world, x, y, z, yaw, pitch);
    }

    public static void add(String name, Location location) {

    }

    public void remove() {

    }
}
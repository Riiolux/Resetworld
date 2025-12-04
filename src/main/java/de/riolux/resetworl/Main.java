package de.riolux.resetworl;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Main extends JavaPlugin {

private static  Main instance;
    @Override
    public void onLoad() {
    instance = this;
        saveConfig();
        if (!getConfig().contains("isReset")) {

            getConfig().set("isReset", false);
                saveConfig();
            return;
        }


    if (getConfig().getBoolean("isReset")){


        try {
            File world = new File(Bukkit.getWorldContainer() , "world");
            File nether = new File(Bukkit.getWorldContainer() , "world_nether");
            File end = new File(Bukkit.getWorldContainer() , "world_end");
            File theend = new File(Bukkit.getWorldContainer() , "world_the_end");

            FileUtils.deleteDirectory(world);
            FileUtils.deleteDirectory(nether);
            FileUtils.deleteDirectory(end);
            FileUtils.deleteDirectory(theend);

            world.mkdirs();
            nether.mkdirs();
            end.mkdirs();

            new File(world, "data").mkdirs();
            new File(world, "datapacks").mkdirs();
            new File(world, "playerdata").mkdirs();
            new File(world, "poi").mkdirs();
            new File(world, "region").mkdirs();

            new File(nether, "data").mkdirs();
            new File(nether, "datapacks").mkdirs();
            new File(nether, "playerdata").mkdirs();
            new File(nether, "poi").mkdirs();
            new File(nether, "region").mkdirs();

            new File(end, "data").mkdirs();
            new File(end, "datapacks").mkdirs();
            new File(end, "playerdata").mkdirs();
            new File(end, "poi").mkdirs();
            new File(end, "region").mkdirs();

            new File(theend, "data").mkdirs();
            new File(theend, "datapacks").mkdirs();
            new File(theend, "playerdata").mkdirs();
            new File(theend, "poi").mkdirs();
            new File(theend, "region").mkdirs();
        } catch (IOException e) {
            throw new RuntimeException("passiert eigentlich nie (hoffentlich)");
        }

        getConfig().set("isReset", false);
        saveConfig();
    }


    }

    @Override
    public void onEnable() {

        getCommand("restartworld").setExecutor(new command());
    }

    @Override
    public void onDisable() {

    }


    public static Main getInstance() {
        return instance;
    }
}

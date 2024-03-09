package fr.mrsquaare.spigot

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin(), Listener {
    override fun onLoad() {
        logger.info("$name loaded.")
    }

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this)

        logger.info("$name enabled.")
    }

    override fun onDisable() {
        logger.info("$name disabled.")
    }

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        event.player.sendMessage("Hello, world!")

        NMS.titleBar.send(event.player, "Hello, world!")
        NMS.actionBar.send(event.player, "Hello, world!")
    }
}

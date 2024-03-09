package fr.mrsquaare.spigot.nms

import org.bukkit.entity.Player

public interface IActionBar {
    fun send(player: Player, message: String)
    fun sendAll(message: String)
}

package fr.mrsquaare.spigot.nms

import org.bukkit.entity.Player

interface ITitleBar {
    fun send(player: Player, message: String)
    fun sendAll(message: String)
}

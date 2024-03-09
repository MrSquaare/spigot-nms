package fr.mrsquaare.spigot.v1_16_R1

import fr.mrsquaare.spigot.nms.IActionBar
import net.minecraft.server.v1_16_R1.IChatBaseComponent
import net.minecraft.server.v1_16_R1.PacketPlayOutTitle
import org.bukkit.Bukkit
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer
import org.bukkit.entity.Player

public class ActionBar : IActionBar {
    override fun send(player: Player, message: String) {
        player as CraftPlayer

        val cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"$message\"}")
        val packet = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, cbc)

        player.handle.playerConnection.sendPacket(packet)
    }

    override fun sendAll(message: String) {
        for (player in Bukkit.getOnlinePlayers()) {
            send(player, message)
        }
    }
}

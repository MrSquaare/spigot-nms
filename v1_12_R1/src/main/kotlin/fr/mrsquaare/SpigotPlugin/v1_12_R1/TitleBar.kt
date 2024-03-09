package fr.mrsquaare.spigot.v1_12_R1

import fr.mrsquaare.spigot.nms.ITitleBar
import net.minecraft.server.v1_12_R1.IChatBaseComponent
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle
import org.bukkit.Bukkit
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player

public class TitleBar: ITitleBar {
    override fun send(player: Player, message: String) {
        player as CraftPlayer

        val cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"$message\"}")
        val titlePacket = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, cbc)
        val subtitlePacket = PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, cbc)

        player.handle.playerConnection.sendPacket(titlePacket)
        player.handle.playerConnection.sendPacket(subtitlePacket)
    }

    override fun sendAll(message: String) {
        for (player in Bukkit.getOnlinePlayers()) {
            send(player, message)
        }
    }
}

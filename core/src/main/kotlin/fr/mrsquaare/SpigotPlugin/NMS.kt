package fr.mrsquaare.spigot

import fr.mrsquaare.spigot.nms.IActionBar
import fr.mrsquaare.spigot.nms.ITitleBar
import org.bukkit.Bukkit

object NMS {
    val version = Bukkit.getServer().javaClass.`package`.name.split(".")[3]

    val actionBar = load("ActionBar") as IActionBar
    val titleBar = load("TitleBar") as ITitleBar

    private fun load(className: String): Any {
        val nmsClass = Class.forName("fr.mrsquaare.spigot.$version.$className")

        return nmsClass.getConstructor().newInstance()
    }
}

package moe.liar.miucareer.player

import net.minecraft.core.UUIDUtil
import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.entity.Player

class MiuPlayer(playerInfo: MiuPlayerInfo) {
    var miuPlayerInfo: MiuPlayerInfo = playerInfo

    val playerCareerBindBar: BossBar = Bukkit.createBossBar("--", BarColor.GREEN, BarStyle.SOLID)

    init {
        val p = Bukkit.getPlayer(playerInfo.uuid)
        playerCareerBindBar.isVisible = false
        playerCareerBindBar.addPlayer(p as Player)
    }
}
package moe.liar.miucareer.player

import org.bukkit.boss.BossBar
import org.bukkit.entity.Player
import java.util.*

object MiuPlayerManager {
    private val miuPlayerMap = mutableMapOf<UUID, MiuPlayer>()

    fun addMiuPlayer(miuPlayer: MiuPlayer) {
        miuPlayerMap[miuPlayer.miuPlayerInfo.uuid] = miuPlayer
    }

    fun addPlayer(player: Player) {
        val playerInfo = MiuPlayerInfo(player.uniqueId)
        val miuPlayer = MiuPlayer(playerInfo)
        addMiuPlayer(miuPlayer)
    }

    fun addByUUID(uuid: UUID) {
        val playerInfo = MiuPlayerInfo(uuid)
        val miuPlayer = MiuPlayer(playerInfo)
        addMiuPlayer(miuPlayer)
    }

    fun getMiuPlayer(uuid: UUID): MiuPlayer = miuPlayerMap[uuid] as MiuPlayer

    fun getBar(uuid: UUID): BossBar = getMiuPlayer(uuid).playerCareerBindBar

}
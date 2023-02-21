package moe.liar.miucareer.career

import moe.liar.miucareer.player.MiuPlayerManager
import org.bukkit.Bukkit
import org.bukkit.boss.BarColor
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.entity.Player
import java.util.*

object MinerManager {
    private val minerMap = mutableMapOf<UUID, Miner>()

    fun addPlayer(player: Player) {
        val uuid = player.uniqueId
        if(!minerMap.containsKey(uuid)) {
            minerMap[uuid] = Miner()
        }
    }

    fun getMiner(uuid: UUID): Miner = minerMap[uuid] as Miner


    fun updateMiner(uuid: UUID, new: Miner) {
        minerMap[uuid] = new
    }

    fun updateExp(uuid: UUID, exp: UInt = 1u, calExpLimit: (UInt) -> UInt = ::calExperienceLimit) {
        val miner = getMiner(uuid)
        val newCareerLevel = miner.careerLevel.updateExp(exp, calExpLimit)
        updateMiner(uuid, miner.copy(careerLevel = newCareerLevel))
    }

    fun showPlayerMinerBar(uuid: UUID) {
        val bar = MiuPlayerManager.getBar(uuid)
        val careerLevel = getMiner(uuid).careerLevel
        bar.setTitle("矿工 level: ${careerLevel.level} exp: ( ${careerLevel.experience} / ${careerLevel.experienceLimit} )")
        bar.progress = careerLevel.experience.toDouble() / careerLevel.experienceLimit.toDouble()
        bar.isVisible = true
    }
}
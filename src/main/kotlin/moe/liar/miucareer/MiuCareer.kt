package moe.liar.miucareer

import io.papermc.paper.configuration.constraint.Constraints.Min
import moe.liar.miucareer.career.*
import moe.liar.miucareer.player.MiuPlayerManager
import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.event.listen
import net.axay.kspigot.main.KSpigot
import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.World
import org.bukkit.inventory.ItemStack
import java.util.UUID

class MiuCareer : KSpigot() {

    override fun load() {
        componentLogger.info(
            literalText {
                text("The plugin MiuCareer was loaded!")
                color = KColors.LIGHTGREEN
            }
        )
    }

    override fun startup() {
        componentLogger.info(
            literalText {
                text("The plugin MiuCareer was enabled!")
                color = KColors.GREEN
            }
        )

        listen<PlayerJoinEvent> { e ->
            val uuid = e.player.uniqueId

            MiuPlayerManager.addPlayer(e.player)
            MinerManager.addPlayer(e.player)
        }

        listen<BlockBreakEvent> {
            val uuid = it.player.uniqueId

            MinerManager.updateExp(uuid)
            MinerManager.showPlayerMinerBar(uuid)

            ability1AfterBlockBreakEvent(MinerManager.getMiner(uuid), it)
        }
    }

    override fun shutdown() {
        componentLogger.info(
            literalText {
                text("The plugin MiuCareer was disabled!")
                color = KColors.RED
            }
        )
    }
}

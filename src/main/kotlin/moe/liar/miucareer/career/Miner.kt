package moe.liar.miucareer.career

import org.bukkit.Material
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

data class Miner(val careerLevel: CareerLevel = CareerLevel()) {
    fun getExpAfterBlockBreakEvent() = copy(careerLevel.updateExp())
}

fun ability1AfterBlockBreakEvent(miner: Miner, blockBreakEvent: BlockBreakEvent) {
    if(miner.careerLevel.level >= 5u && (0..1).random()  == 1) {
        val location = blockBreakEvent.block.location
        val coalStack = ItemStack(Material.COAL, 1)
        blockBreakEvent.block.world.dropItem(location, coalStack)
    }
}
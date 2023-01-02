package com.github.hashibiroko.spigot.spawner

import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.craftbukkit.v1_19_R1.block.CraftBlock
import org.bukkit.craftbukkit.v1_19_R1.block.CraftCreatureSpawner
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin

@Suppress("unused")
class Main : JavaPlugin(), Listener {

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    @EventHandler
    fun onBlockBreak(event: BlockBreakEvent) {
        if (event.block.type != Material.SPAWNER) return
        val craftBlock = event.block as CraftBlock
        val craftState = craftBlock.state as CraftCreatureSpawner
        craftState.dropSpawner(event.block)
        craftState.dropSpawnEgg(event.block)
    }

    private fun CraftCreatureSpawner.dropSpawner(block: Block) {
        val itemStack = data.toItemStack(1)
        block.world.dropItemNaturally(block.location, itemStack)
    }

    private fun CraftCreatureSpawner.dropSpawnEgg(block: Block) {
        val material = eggMaterial ?: return
        val itemStack = ItemStack(material, 1)
        block.world.dropItemNaturally(block.location, itemStack)
    }

    private val CraftCreatureSpawner.eggMaterial: Material?
        get() = when (spawnedType) {
            EntityType.ELDER_GUARDIAN -> Material.ELDER_GUARDIAN_SPAWN_EGG
            EntityType.WITHER_SKELETON -> Material.WITHER_SKELETON_SPAWN_EGG
            EntityType.STRAY -> Material.STRAY_SPAWN_EGG
            EntityType.HUSK -> Material.HUSK_SPAWN_EGG
            EntityType.ZOMBIE_VILLAGER -> Material.ZOMBIE_VILLAGER_SPAWN_EGG
            EntityType.SKELETON_HORSE -> Material.SKELETON_HORSE_SPAWN_EGG
            EntityType.ZOMBIE_HORSE -> Material.ZOMBIE_HORSE_SPAWN_EGG
            EntityType.DONKEY -> Material.DONKEY_SPAWN_EGG
            EntityType.MULE -> Material.MULE_SPAWN_EGG
            EntityType.EVOKER -> Material.EVOKER_SPAWN_EGG
            EntityType.VEX -> Material.VEX_SPAWN_EGG
            EntityType.VINDICATOR -> Material.VINDICATOR_SPAWN_EGG
            EntityType.CREEPER -> Material.CREEPER_SPAWN_EGG
            EntityType.SKELETON -> Material.SKELETON_SPAWN_EGG
            EntityType.SPIDER -> Material.SPIDER_SPAWN_EGG
            EntityType.ZOMBIE -> Material.ZOMBIE_SPAWN_EGG
            EntityType.SLIME -> Material.SLIME_SPAWN_EGG
            EntityType.GHAST -> Material.GHAST_SPAWN_EGG
            EntityType.ZOMBIFIED_PIGLIN -> Material.ZOMBIFIED_PIGLIN_SPAWN_EGG
            EntityType.ENDERMAN -> Material.ENDERMAN_SPAWN_EGG
            EntityType.CAVE_SPIDER -> Material.CAVE_SPIDER_SPAWN_EGG
            EntityType.SILVERFISH -> Material.SILVERFISH_SPAWN_EGG
            EntityType.BLAZE -> Material.BLAZE_SPAWN_EGG
            EntityType.MAGMA_CUBE -> Material.MAGMA_CUBE_SPAWN_EGG
            EntityType.BAT -> Material.BAT_SPAWN_EGG
            EntityType.WITCH -> Material.WITCH_SPAWN_EGG
            EntityType.ENDERMITE -> Material.ENDERMITE_SPAWN_EGG
            EntityType.GUARDIAN -> Material.GUARDIAN_SPAWN_EGG
            EntityType.SHULKER -> Material.SHULKER_SPAWN_EGG
            EntityType.SHEEP -> Material.SHEEP_SPAWN_EGG
            EntityType.COW -> Material.COW_SPAWN_EGG
            EntityType.CHICKEN -> Material.CHICKEN_SPAWN_EGG
            EntityType.SQUID -> Material.SQUID_SPAWN_EGG
            EntityType.WOLF -> Material.WOLF_SPAWN_EGG
            EntityType.OCELOT -> Material.OCELOT_SPAWN_EGG
            EntityType.HORSE -> Material.HORSE_SPAWN_EGG
            EntityType.RABBIT -> Material.RABBIT_SPAWN_EGG
            EntityType.POLAR_BEAR -> Material.POLAR_BEAR_SPAWN_EGG
            EntityType.LLAMA -> Material.LLAMA_SPAWN_EGG
            EntityType.PARROT -> Material.PARROT_SPAWN_EGG
            EntityType.VILLAGER -> Material.VILLAGER_SPAWN_EGG
            EntityType.TURTLE -> Material.TURTLE_SPAWN_EGG
            EntityType.PHANTOM -> Material.PHANTOM_SPAWN_EGG
            EntityType.COD -> Material.COD_SPAWN_EGG
            EntityType.SALMON -> Material.SALMON_SPAWN_EGG
            EntityType.PUFFERFISH -> Material.PUFFERFISH_SPAWN_EGG
            EntityType.TROPICAL_FISH -> Material.TROPICAL_FISH_SPAWN_EGG
            EntityType.DROWNED -> Material.DROWNED_SPAWN_EGG
            EntityType.DOLPHIN -> Material.DOLPHIN_SPAWN_EGG
            EntityType.CAT -> Material.CAT_SPAWN_EGG
            EntityType.PANDA -> Material.PANDA_SPAWN_EGG
            EntityType.PILLAGER -> Material.PILLAGER_SPAWN_EGG
            EntityType.RAVAGER -> Material.RAVAGER_SPAWN_EGG
            EntityType.TRADER_LLAMA -> Material.TRADER_LLAMA_SPAWN_EGG
            EntityType.WANDERING_TRADER -> Material.WANDERING_TRADER_SPAWN_EGG
            EntityType.FOX -> Material.FOX_SPAWN_EGG
            EntityType.BEE -> Material.BEE_SPAWN_EGG
            EntityType.HOGLIN -> Material.HOGLIN_SPAWN_EGG
            EntityType.PIGLIN -> Material.PIGLIN_SPAWN_EGG
            EntityType.STRIDER -> Material.STRIDER_SPAWN_EGG
            EntityType.ZOGLIN -> Material.ZOGLIN_SPAWN_EGG
            EntityType.PIGLIN_BRUTE -> Material.PIGLIN_BRUTE_SPAWN_EGG
            EntityType.AXOLOTL -> Material.AXOLOTL_SPAWN_EGG
            EntityType.GLOW_SQUID -> Material.GLOW_SQUID_SPAWN_EGG
            EntityType.GOAT -> Material.GOAT_SPAWN_EGG
            EntityType.ALLAY -> Material.ALLAY_SPAWN_EGG
            EntityType.FROG -> Material.FROG_SPAWN_EGG
            EntityType.TADPOLE -> Material.TADPOLE_SPAWN_EGG
            EntityType.WARDEN -> Material.WARDEN_SPAWN_EGG
            EntityType.PIG, // default entity type
            EntityType.DROPPED_ITEM,
            EntityType.EXPERIENCE_ORB,
            EntityType.AREA_EFFECT_CLOUD,
            EntityType.EGG,
            EntityType.LEASH_HITCH,
            EntityType.PAINTING,
            EntityType.ARROW,
            EntityType.SNOWBALL,
            EntityType.FIREBALL,
            EntityType.SMALL_FIREBALL,
            EntityType.ENDER_PEARL,
            EntityType.ENDER_SIGNAL,
            EntityType.SPLASH_POTION,
            EntityType.THROWN_EXP_BOTTLE,
            EntityType.ITEM_FRAME,
            EntityType.WITHER_SKULL,
            EntityType.PRIMED_TNT,
            EntityType.FALLING_BLOCK,
            EntityType.FIREWORK,
            EntityType.SPECTRAL_ARROW,
            EntityType.SHULKER_BULLET,
            EntityType.DRAGON_FIREBALL,
            EntityType.ARMOR_STAND,
            EntityType.EVOKER_FANGS,
            EntityType.ILLUSIONER,
            EntityType.MINECART_COMMAND,
            EntityType.BOAT,
            EntityType.MINECART,
            EntityType.MINECART_CHEST,
            EntityType.MINECART_FURNACE,
            EntityType.MINECART_TNT,
            EntityType.MINECART_HOPPER,
            EntityType.MINECART_MOB_SPAWNER,
            EntityType.GIANT,
            EntityType.ENDER_DRAGON,
            EntityType.WITHER,
            EntityType.MUSHROOM_COW,
            EntityType.SNOWMAN,
            EntityType.IRON_GOLEM,
            EntityType.LLAMA_SPIT,
            EntityType.ENDER_CRYSTAL,
            EntityType.TRIDENT,
            EntityType.GLOW_ITEM_FRAME,
            EntityType.MARKER,
            EntityType.CHEST_BOAT,
            EntityType.FISHING_HOOK,
            EntityType.LIGHTNING,
            EntityType.PLAYER,
            EntityType.UNKNOWN,
            -> null
        }
}
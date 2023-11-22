package fr.berzaak.superguilds.gui;

import fr.berzaak.superguilds.SuperGuilds;
import fr.berzaak.superguilds.guild.GuildPlayer;
import fr.berzaak.superguilds.tier.Tier;
import fr.berzaak.superguilds.utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public final class GuildUpgradeInventory implements InventoryProvider {

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("guildupgrad")
            .provider(new GuildUpgradeInventory())
            .size(3, 9)
            .title("§6Guild Upgrad")
            .manager(SuperGuilds.getInstance().getInventoryManager())
            .build();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        GuildPlayer guildPlayer = SuperGuilds.getInstance().getGuildManager().getGuildPlayer(player.getUniqueId());
        Tier xpMultiplier = guildPlayer.getGuild().getGuildTier().getXpMultiplier();

        inventoryContents.add(ClickableItem.of(new ItemBuilder(Material.EXP_BOTTLE).name("§2XP MULTIPLIER").lore(
                "",
                "§eActual Level : " + xpMultiplier.getLevel() + "/" + xpMultiplier.getMaxLevel(),
                "§eCurrent Boost : " + xpMultiplier.getMultiplier(xpMultiplier.getLevel()),
                "",
                "§aNext Level Price : §2" + (xpMultiplier.getLevel() == xpMultiplier.getMaxLevel() ? "MAX" : xpMultiplier.getPrice(xpMultiplier.getLevel() + 1)),
                "§aNext Level Boost : §2" + (xpMultiplier.getLevel() == xpMultiplier.getMaxLevel() ? "MAX" : xpMultiplier.getMultiplier(xpMultiplier.getLevel() + 1)),
                "").build(), event -> {

            if (xpMultiplier.getLevel() == xpMultiplier.getMaxLevel()) {
                event.setCancelled(true);
                event.getWhoClicked().sendMessage("§cThat upgrade is already maxed");
                return;
            }

            xpMultiplier.setLevel(xpMultiplier.getLevel() + 1);
            event.getWhoClicked().sendMessage("§aYou just buyed an extra level for: §2" + xpMultiplier.getPrice(xpMultiplier.getLevel()));


        }));

    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}

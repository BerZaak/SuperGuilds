package fr.berzaak.superguilds.gui;

import fr.berzaak.superguilds.SuperGuilds;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import org.bukkit.entity.Player;

public final class GuildQuestInventory implements InventoryProvider {

    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("guildquests")
            .provider(new GuildQuestInventory())
            .size(1, 9)
            .title("§6Guild Quests")
            .manager(SuperGuilds.getInstance().getInventoryManager())
            .build();

    @Override
    public void init(Player player, InventoryContents inventoryContents) {


    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}

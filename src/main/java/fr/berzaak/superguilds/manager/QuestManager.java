package fr.berzaak.superguilds.manager;

import com.google.common.collect.Maps;
import fr.berzaak.superguilds.quests.Quest;
import fr.berzaak.superguilds.quests.QuestType;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.Map;

public final class QuestManager {

    private final Map<String, Quest> availableQuests;

    public QuestManager() {
        availableQuests = Maps.newHashMap();
    }

    public void loadQuests() {

        final Quest killZombie = new Quest.Builder("Kill 10 Zombie").type(QuestType.KILL_ENTITY).icon(Material.MONSTER_EGG).lore("", "§eKill Zombie").entity(EntityType.ZOMBIE).build();
        final Quest placeDirt = new Quest.Builder("Place 20 Dirt").type(QuestType.PLACE_BLOCK).material(Material.DIRT).icon(Material.GRASS).lore("", "§ePlace 20 Dirt").build();
        availableQuests.put(killZombie.getName(), killZombie);
        availableQuests.put(placeDirt.getName(), placeDirt);

    }

    public Map<String, Quest> getAvailableQuests() {
        return availableQuests;
    }
}

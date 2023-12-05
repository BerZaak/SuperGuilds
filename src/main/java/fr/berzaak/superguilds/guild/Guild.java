package fr.berzaak.superguilds.guild;

import com.google.common.collect.Sets;
import fr.berzaak.superguilds.quests.Quest;

import java.util.Optional;
import java.util.Set;

public final class Guild {

    private final Set<GuildPlayer> players = Sets.newHashSet();
    private final GuildTier guildTier;
    private final GuildPlayer owner;
    private final String name;
    private Quest quest;
    private int questData;

    public Guild(String name, GuildPlayer owner) {
        guildTier = new GuildTier(1);
        this.owner = owner;
        this.name = name;
        this.players.add(owner);
    }

    public Set<GuildPlayer> getAllPlayers() {
        return players;
    }

    public GuildTier getGuildTier() {
        return guildTier;
    }

    public GuildPlayer getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public Optional<Quest> getActiveQuest() {
        return Optional.ofNullable(quest);
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public void sendMessage(String message) {
        players.forEach(guildPlayer -> guildPlayer.toPlayer().sendMessage(message));
    }

    public void advanceQuest() {
        questData++;

        if (questData >= quest.getGoal()) {
            quest = null;
            sendMessage("§cQuest ended !");
        }
    }

}

package fr.berzaak.superguilds.quests;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public final class Quest {

    private final String name;
    private final QuestType questType;
    private final String[] lore;
    private final Material icon;
    private final Material material;
    private final EntityType entityType;
    private final int goal;
    private final ItemStack reward;

    private Quest(Builder builder) {
        this.name = builder.name;
        this.questType = builder.questType;
        this.lore = builder.lore;
        this.icon = builder.icon;
        this.material = builder.material;
        this.entityType = builder.entityType;
        this.goal = builder.goal;
        this.reward = builder.reward;
    }

    public String getName() {
        return name;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public String[] getLore() {
        return lore;
    }

    public Material getIcon() {
        return icon;
    }

    public Material getMaterial() {
        return material;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public int getGoal() {
        return goal;
    }

    public ItemStack getReward() {
        return reward;
    }

    public static class Builder {
        private final String name;
        private QuestType questType;
        private String[] lore;
        private Material icon;
        private Material material;
        private EntityType entityType;
        private int goal;
        private ItemStack reward;

        public Builder(String name) {
            this.name = name;
        }

        public Builder type(QuestType questType) {
            this.questType = questType;
            return this;
        }

        public Builder lore(String... lore) {
            this.lore = lore;
            return this;
        }

        public Builder icon(Material icon) {
            this.icon = icon;
            return this;
        }

        public Builder material(Material material) {
            this.material = material;
            return this;
        }

        public Builder entity(EntityType entityType) {
            this.entityType = entityType;
            return this;
        }

        public Builder goal(int goal) {
            this.goal = goal;
            return this;
        }

        public Builder reward(ItemStack reward) {
            this.reward = reward;
            return this;
        }

        public Quest build() {
            return new Quest(this);
        }

    }
}

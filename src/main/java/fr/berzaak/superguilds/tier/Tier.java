package fr.berzaak.superguilds.tier;

public abstract class Tier {

    private int level;

    public Tier(int level) {
        this.level = level;
    }

    public abstract String getName();

    public abstract int getMaxLevel();

    public abstract Double getMultiplier(int level);

    public abstract int getPrice(int level);

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}

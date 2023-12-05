package fr.berzaak.superguilds.tier;

public final class TierXpMultiplier extends Tier{

    public TierXpMultiplier(int level) {
        super(level);
    }

    @Override
    public String getName() {
        return "XP Multiplier";
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public Double getMultiplier(int level) {

        return switch (level) {
            case 1 -> 1.5;
            case 2 -> 2.5;
            case 3 -> 3.0;
            default -> 0.0;
        };
    }


    @Override
    public int getPrice(int level) {

        return switch (level) {
            case 1 -> 10000;
            case 2 -> 30000;
            case 3 -> 50000;
            default -> 0;
        };
    }
}

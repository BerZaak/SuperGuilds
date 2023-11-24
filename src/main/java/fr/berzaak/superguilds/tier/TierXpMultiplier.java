package fr.berzaak.superguilds.tier;

public final class TierXpMultiplier extends Tier{

    public TierXpMultiplier(int level) {
        super(level);
    }

    public TierXpMultiplier() {
        super(0);
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

        switch (level) {

            case 1:
                return 1.5;
            case 2:
                return 2.5;
            case 3:
                return 3.0;
            default:
                return 0.0;

        }
    }


    @Override
    public int getPrice(int level) {

        switch (level) {


            case 1:
                return 10000;
            case 2:
                return 30000;
            case 3:
                return 50000;
            default:
                return 0;

        }
    }
}

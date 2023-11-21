package fr.berzaak.superguilds.guild;

import fr.berzaak.superguilds.tier.TierXpMultiplier;

public final class GuildTier {

    private final TierXpMultiplier xpMultiplier;

    public GuildTier(int xpMultiplierLevel) {
        xpMultiplier = new TierXpMultiplier(xpMultiplierLevel);
    }

    public TierXpMultiplier getXpMultiplier() {
        return xpMultiplier;
    }
}

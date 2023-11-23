package fr.berzaak.superguilds.title;

import fr.berzaak.superguilds.tier.Tier;

import java.util.Optional;

public interface Title {

    String getTitle();

    Optional<Tier> getRequiredTier();

}

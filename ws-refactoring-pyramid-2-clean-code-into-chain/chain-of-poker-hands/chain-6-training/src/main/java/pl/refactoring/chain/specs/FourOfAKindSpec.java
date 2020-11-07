package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.FOUR_OF_A_KIND;

public class FourOfAKindSpec {
    public FourOfAKindSpec() {
    }

    public boolean IsFourOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    public RANKING getFourOfAKindRanking() {
        return FOUR_OF_A_KIND;
    }
}
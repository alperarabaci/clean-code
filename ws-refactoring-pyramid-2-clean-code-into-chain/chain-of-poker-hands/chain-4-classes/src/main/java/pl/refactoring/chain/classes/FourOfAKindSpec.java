package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.FOUR_OF_A_KIND;

public class FourOfAKindSpec {
    public FourOfAKindSpec() {
    }

    boolean isFourOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    RANKING getFourOfAKindRanking() {
        return FOUR_OF_A_KIND;
    }
}
package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.FOUR_OF_A_KIND;

public class FourOfAKindSpec {
    public FourOfAKindSpec() {
    }

    boolean IsFourOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }

    RANKING getFourOfAKindRanking() {
        return FOUR_OF_A_KIND;
    }
}
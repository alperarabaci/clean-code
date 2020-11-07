package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.THREE_OF_A_KIND;

public class ThreeOfAKindSpec {
    public ThreeOfAKindSpec() {
    }

    boolean isThreeOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(3);
    }

    RANKING getThreeOfAKindRanking() {
        return THREE_OF_A_KIND;
    }
}
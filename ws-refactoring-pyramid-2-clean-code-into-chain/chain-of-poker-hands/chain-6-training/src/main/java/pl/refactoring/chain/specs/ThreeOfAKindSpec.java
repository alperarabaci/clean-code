package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.THREE_OF_A_KIND;

public class ThreeOfAKindSpec implements PokerHandSpec {
    public ThreeOfAKindSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(3);
    }

    public RANKING getRanking() {
        return THREE_OF_A_KIND;
    }
}
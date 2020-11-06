package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.THREE_OF_A_KIND;

public class ThreeOfAKindSpec implements PokerHandSpec {
    public ThreeOfAKindSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(3);
    }

    public RANKING getRanking() {
        return THREE_OF_A_KIND;
    }
}
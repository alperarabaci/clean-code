package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.TWO_PAIRS;

public class TwoPairsSpec implements PokerHandSpec {
    public TwoPairsSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(3) &&
                cardSet.containsRankWithMultiplicity(2);
    }

    public RANKING getRanking() {
        return TWO_PAIRS;
    }
}
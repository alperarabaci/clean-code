package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.HIGH_CARD;

public class HighCardSpec implements PokerHandSpec {
    public HighCardSpec() {
    }

    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }

    public RANKING getRanking() {
        return HIGH_CARD;
    }
}
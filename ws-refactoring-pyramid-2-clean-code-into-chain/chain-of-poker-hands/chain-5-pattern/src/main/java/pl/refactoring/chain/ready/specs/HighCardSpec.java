package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

import static pl.refactoring.chain.ready.RANKING.HIGH_CARD;

public class HighCardSpec implements PokerHandSpec {
    public HighCardSpec() {
    }

    @Override
    public boolean isSatisfiedBy(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }

    @Override
    public RANKING getRanking() {
        return HIGH_CARD;
    }
}
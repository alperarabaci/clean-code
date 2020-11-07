package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.HIGH_CARD;

public class HighCardSpec {
    public HighCardSpec() {
    }

    boolean isHighCard(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }

    RANKING getHighCardRanking() {
        return HIGH_CARD;
    }
}
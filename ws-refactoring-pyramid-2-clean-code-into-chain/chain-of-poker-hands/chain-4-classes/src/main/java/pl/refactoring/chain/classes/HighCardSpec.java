package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.HIGH_CARD;

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
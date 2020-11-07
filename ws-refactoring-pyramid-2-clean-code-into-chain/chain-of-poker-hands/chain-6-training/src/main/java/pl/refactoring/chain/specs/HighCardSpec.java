package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

import static pl.refactoring.chain.RANKING.HIGH_CARD;

public class HighCardSpec {
    public HighCardSpec() {
    }

    public boolean isHighCard(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }

    public RANKING getHighCardRanking() {
        return HIGH_CARD;
    }
}
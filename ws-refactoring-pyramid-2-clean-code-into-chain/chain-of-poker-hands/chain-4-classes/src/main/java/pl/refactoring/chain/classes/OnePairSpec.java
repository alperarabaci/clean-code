package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.ONE_PAIR;

public class OnePairSpec {
    public OnePairSpec() {
    }

    boolean isOnePair(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4);
    }

    RANKING getOnePairRanking() {
        return ONE_PAIR;
    }
}
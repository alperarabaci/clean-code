package pl.refactoring.chain.classes;

import static pl.refactoring.chain.classes.RANKING.FLUSH;

public class FlushSpec {
    public FlushSpec() {
    }

    boolean isFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }

    RANKING getFlushRanking() {
        return FLUSH;
    }
}
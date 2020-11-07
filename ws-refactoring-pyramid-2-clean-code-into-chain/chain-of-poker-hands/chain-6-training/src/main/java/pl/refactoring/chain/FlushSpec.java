package pl.refactoring.chain;

import static pl.refactoring.chain.RANKING.FLUSH;

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
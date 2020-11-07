package pl.refactoring.chain;

public class FlushSpec {
    public FlushSpec() {
    }

    boolean isFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && !cardSet.isSequential();
    }
}
package pl.refactoring.chain;

public class StraightFlushSpec {
    public StraightFlushSpec() {
    }

    boolean isStraightFlush(CardSet cardSet) {
        return cardSet.isAllSameSuit() && cardSet.isSequential();
    }
}
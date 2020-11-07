package pl.refactoring.chain;

public class StraightSpec {
    public StraightSpec() {
    }

    boolean isStraight(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(5)
                && cardSet.isSequential();
    }
}
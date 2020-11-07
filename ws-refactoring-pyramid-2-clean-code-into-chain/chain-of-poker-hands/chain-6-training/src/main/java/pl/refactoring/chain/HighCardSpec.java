package pl.refactoring.chain;

public class HighCardSpec {
    public HighCardSpec() {
    }

    boolean isHighCard(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                !cardSet.isSequential() &&
                cardSet.hasRankDiversity(5);
    }
}
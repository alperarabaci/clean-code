package pl.refactoring.chain;

public class OnePairSpec {
    public OnePairSpec() {
    }

    boolean isOnePair(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(4);
    }
}
package pl.refactoring.chain;

public class TwoPairsSpec {
    public TwoPairsSpec() {
    }

    boolean isTwoPairs(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(1);
    }
}
package pl.refactoring.chain;

public class ThreeOfAKindSpec {
    public ThreeOfAKindSpec() {
    }

    boolean isThreeOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit()
                && cardSet.hasRankDiversity(3)
                && cardSet.containsRankWithMultiplicity(3);
    }
}
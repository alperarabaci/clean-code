package pl.refactoring.chain;

public class FourOfAKindSpec {
    public FourOfAKindSpec() {
    }

    boolean IsFourOfAKind(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(4);
    }
}
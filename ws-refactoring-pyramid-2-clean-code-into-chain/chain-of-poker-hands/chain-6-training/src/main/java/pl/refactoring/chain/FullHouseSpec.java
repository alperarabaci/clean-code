package pl.refactoring.chain;

public class FullHouseSpec {
    public FullHouseSpec() {
    }

    boolean isFullHouse(CardSet cardSet) {
        return !cardSet.isAllSameSuit() &&
                cardSet.hasRankDiversity(2) &&
                cardSet.containsRankWithMultiplicity(3);
    }
}
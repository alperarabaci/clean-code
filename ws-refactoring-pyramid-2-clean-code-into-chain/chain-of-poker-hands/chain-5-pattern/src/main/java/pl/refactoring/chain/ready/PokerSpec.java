package pl.refactoring.chain.ready;

public interface PokerSpec {
    boolean isConformedBy(CardSet cardSet);

    RANKING getRanking();
}

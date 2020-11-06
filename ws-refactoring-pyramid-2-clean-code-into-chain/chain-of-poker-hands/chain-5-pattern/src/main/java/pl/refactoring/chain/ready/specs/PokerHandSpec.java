package pl.refactoring.chain.ready.specs;

import pl.refactoring.chain.ready.CardSet;
import pl.refactoring.chain.ready.RANKING;

public interface PokerHandSpec {
    boolean isSatisfiedBy(CardSet cardSet);

    RANKING getRanking();
}

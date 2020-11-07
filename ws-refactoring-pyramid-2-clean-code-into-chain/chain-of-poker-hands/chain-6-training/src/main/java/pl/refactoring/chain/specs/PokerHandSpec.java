package pl.refactoring.chain.specs;

import pl.refactoring.chain.CardSet;
import pl.refactoring.chain.RANKING;

/**
 * alper - 07/11/2020
 */
public interface PokerHandSpec {
    boolean isSatisfiedBy(CardSet cardSet);

    RANKING getRanking();
}

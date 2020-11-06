package pl.refactoring.chain.flattening_continued;

import org.junit.jupiter.api.Test;
import pl.refactoring.chain.flattening_continued.card.Card;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.refactoring.chain.flattening_continued.card.Card.aCard;
import static pl.refactoring.chain.flattening_continued.card.RANK.*;
import static pl.refactoring.chain.flattening_continued.card.SUIT.*;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * This code is exclusive property of Wlodek Krakowski
 * for usage of attendees of trainings that are conducted by Wlodek Krakowski.
 * <p>
 * This code may not be copied or used without
 * written consent of IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * <p>
 * If willing to do so, please contact the author.
 */
public class CardSetTest {
    @Test
    public void shouldSortRanks() {
        CardSet cardSet = new CardSet(
                aCard(HEART, TEN),
                aCard(HEART, KING),
                aCard(HEART, ACE),
                aCard(HEART, QUEEN),
                aCard(HEART, JACK));

        List<Card> sortedCards = cardSet.getSortedCards();

        assertThat(sortedCards)
                .containsSequence(
                        aCard(HEART, ACE),
                        aCard(HEART, KING),
                        aCard(HEART, QUEEN),
                        aCard(HEART, JACK),
                        aCard(HEART, TEN));
    }

    @Test
    public void shouldSortRanksThanSuits() {
        CardSet cardSet = new CardSet(
                aCard(CLUB, ACE),
                aCard(HEART, KING),
                aCard(DIAMOND, ACE),
                aCard(SPADE, ACE),
                aCard(HEART, ACE));

        List<Card> sortedCards = cardSet.getSortedCards();

        assertThat(sortedCards)
                .containsSequence(
                        aCard(HEART, ACE),
                        aCard(DIAMOND, ACE),
                        aCard(CLUB, ACE),
                        aCard(SPADE, ACE),
                        aCard(HEART, KING));
    }
}

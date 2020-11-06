package pl.refactoring.chain.ready.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
public class CardDeckTest {
    private CardDeckFactory factory;

    @BeforeEach
    public void setUp() throws Exception {
        factory = new CardDeckFactory();
    }

    @Test
    public void canDrawACard() {
        CardDeck deck = factory.createDeck(4);

        Set<Card> remainingCards = deck.getRemainingCards();
        assertThat(remainingCards)
                .hasSize(4);

        Card firstRandomCard = deck.draw();

        remainingCards = deck.getRemainingCards();
        assertThat(remainingCards)
                .hasSize(3)
                .doesNotContain(firstRandomCard);

        Card secondRandomCard = deck.draw();

        remainingCards = deck.getRemainingCards();
        assertThat(remainingCards)
                .hasSize(2)
                .doesNotContain(firstRandomCard, secondRandomCard);
    }
}

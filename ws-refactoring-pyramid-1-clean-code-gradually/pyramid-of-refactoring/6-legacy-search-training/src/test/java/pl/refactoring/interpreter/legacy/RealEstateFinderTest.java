/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */

package pl.refactoring.interpreter.legacy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RealEstateFinderTest {

    private static final RealEstate WOODEN_VILLAGE_BUNGALLOW =
            new RealEstate(1, 140, EstatePlacement.VILLAGE,
                    EstateType.BUNGALLOW, EstateMaterial.WOOD);

    private static final RealEstate WOODEN_VILLAGE_HOUSE =
            new RealEstate(2, 210, EstatePlacement.VILLAGE,
                    EstateType.HOUSE, EstateMaterial.WOOD);

    private static final RealEstate BRICK_TOWN_HOUSE =
            new RealEstate(3, 230, EstatePlacement.TOWN,
                    EstateType.HOUSE, EstateMaterial.BRICK);

    private static final RealEstate BRICK_VILLAGE_BUNGALLOW =
            new RealEstate(4, 130, EstatePlacement.VILLAGE,
                    EstateType.BUNGALLOW, EstateMaterial.BRICK);

    private static final RealEstate STONE_TOWN_CASTLE =
            new RealEstate(5, 3900, EstatePlacement.TOWN,
                    EstateType.CASTLE, EstateMaterial.STONE);

    private static final RealEstate FERROCONCRETE_CITY_FLAT =
            new RealEstate(6, 40, EstatePlacement.CITY,
                    EstateType.FLAT, EstateMaterial.FERROCONCRETE);

    private static final RealEstate BRICK_CITY_FLAT =
            new RealEstate(7, 69, EstatePlacement.CITY,
                    EstateType.FLAT, EstateMaterial.BRICK);

    private static List<RealEstate> createProductRepository() {
        return Arrays.asList(WOODEN_VILLAGE_BUNGALLOW,
                WOODEN_VILLAGE_HOUSE,
                BRICK_TOWN_HOUSE,
                BRICK_VILLAGE_BUNGALLOW,
                STONE_TOWN_CASTLE,
                FERROCONCRETE_CITY_FLAT,
                BRICK_CITY_FLAT);
    }

    private static final List<RealEstate> PRODUCT_REPOSITORY = createProductRepository();
    private static final RealEstateFinder FINDER = new RealEstateFinder(PRODUCT_REPOSITORY);

    @BeforeAll
    public void setUp() {

    }

    @Test
    public void findSmallRealEstates() {
        //when
        List<RealEstate> foundResults = FINDER.byBelowArea(70);
        //then
        assertThat(foundResults)
                .hasSize(2)
                .containsExactlyInAnyOrder(FERROCONCRETE_CITY_FLAT, BRICK_CITY_FLAT);
    }

    @Test
    public void findWoodenRealEstates() {
        //when
        List<RealEstate> foundResults = FINDER.byMaterial(EstateMaterial.WOOD);

        //then
        assertThat(foundResults)
                .hasSize(2)
                .containsExactlyInAnyOrder(WOODEN_VILLAGE_BUNGALLOW, WOODEN_VILLAGE_HOUSE);
    }

    @Test
    public void findWoodenSmallProperty() {
        //when
        List<RealEstate> foundResults = FINDER.byMaterialBelowArea(EstateMaterial.WOOD, 150);

        //then
        assertThat(foundResults)
                .hasSize(1)
                .containsExactly(WOODEN_VILLAGE_BUNGALLOW);
    }

    @Test
    public void findRealEstatesInTown() {
        //when
        List<RealEstate> foundResults = FINDER.byPlacement(EstatePlacement.TOWN);

        //then
        assertThat(foundResults)
                .hasSize(2)
                .contains(BRICK_TOWN_HOUSE)
                .contains(STONE_TOWN_CASTLE);
    }

    @Test
    public void findNonVillageRealEstates() {
        //when
        List<RealEstate> foundResults = FINDER.byAvoidingPlacement(EstatePlacement.VILLAGE);

        //then
        assertThat(foundResults)
                .hasSize(4)
                .contains(STONE_TOWN_CASTLE)
                .contains(BRICK_TOWN_HOUSE)
                .contains(BRICK_CITY_FLAT)
                .contains(FERROCONCRETE_CITY_FLAT);
    }

    @Test
    public void findByAreaRange() {
        //when
        List<RealEstate> foundResults = FINDER.byAreaRange(130, 140);

        //then
        assertThat(foundResults)
                .hasSize(2)
                .contains(BRICK_VILLAGE_BUNGALLOW)
                .contains(WOODEN_VILLAGE_BUNGALLOW);
    }

    @Test
    public void findAllHouses() {
        //when
        List<RealEstate> foundResults = FINDER.byType(EstateType.HOUSE);

        //then
        assertThat(foundResults)
                .hasSize(2)
                .contains(BRICK_TOWN_HOUSE)
                .contains(WOODEN_VILLAGE_HOUSE);
    }

    @Test
    public void findStoneCastlesInTowns() {
        //when
        List<RealEstate> foundResults = FINDER.byTypePlacementMaterial(EstateType.CASTLE, EstatePlacement.TOWN, EstateMaterial.STONE);

        //then
        assertThat(foundResults)
                .hasSize(1)
                .contains(STONE_TOWN_CASTLE);
    }
}

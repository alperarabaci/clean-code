package pl.refactoring.interpreter.legacy.specs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import pl.refactoring.interpreter.legacy.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AndSpecTest {

    private static final RealEstate BRICK_VILLAGE_BUNGALLOW =
            new RealEstate(4, 130, EstatePlacement.VILLAGE,
                    EstateType.BUNGALLOW, EstateMaterial.BRICK);

    Spec yesSpec;
    Spec noSpec;

    @BeforeEach
    void setUp() {
        yesSpec = Mockito.mock(Spec.class);
        when(yesSpec.isSatisfiedBy(Mockito.any(RealEstate.class))).thenReturn(true);

        noSpec = Mockito.mock(Spec.class);
        when(noSpec.isSatisfiedBy(Mockito.any(RealEstate.class))).thenReturn(true);
    }

    @Test
    public void multipleTrue() {
        AndSpec andSpec = new AndSpecBuilder().withSpec(yesSpec, yesSpec).createAndSpec();

        assertThat(andSpec.isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW))
                .isTrue();

        Mockito.verify(yesSpec, Mockito.times(2)).isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW);
    }

    @Test
    public void multipleFalse() {
        AndSpec andSpec = new AndSpecBuilder().withSpec(noSpec, noSpec).createAndSpec();

        assertThat(andSpec.isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW))
                .isTrue();

        Mockito.verify(noSpec, Mockito.times(2)).isSatisfiedBy(BRICK_VILLAGE_BUNGALLOW);
    }

}
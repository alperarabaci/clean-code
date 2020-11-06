package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstatePlacement;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

/**
 * alper - 05/11/2020
 */
public class PlacementSpec implements Spec {

    private EstatePlacement placement;

    PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
    }

    @Override
    public boolean isSatisfiedBy(RealEstate estate) {
        return placement.equals(estate.getPlacement());
    }
}

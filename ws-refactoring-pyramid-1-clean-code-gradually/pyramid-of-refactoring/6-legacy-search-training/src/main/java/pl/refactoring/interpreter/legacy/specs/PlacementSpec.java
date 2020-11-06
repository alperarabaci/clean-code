package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstatePlacement;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

/**
 * alper - 05/11/2020
 */
public class PlacementSpec implements Spec {

    private EstatePlacement placement;

    private PlacementSpec(EstatePlacement placement) {
        this.placement = placement;
    }

    public static PlacementSpec placedIn(EstatePlacement placement) {
        return new PlacementSpec(placement);
    }

    @Override
    public boolean isSatisfiedBy(RealEstate estate) {
        return placement.equals(estate.getPlacement());
    }
}

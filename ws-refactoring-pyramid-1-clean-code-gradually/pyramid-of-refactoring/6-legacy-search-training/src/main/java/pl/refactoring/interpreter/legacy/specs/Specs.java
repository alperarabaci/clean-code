package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstateMaterial;
import pl.refactoring.interpreter.legacy.EstatePlacement;
import pl.refactoring.interpreter.legacy.EstateType;
import pl.refactoring.interpreter.legacy.Spec;

/**
 * alper - 06/11/2020
 */
public class Specs {
    /**
     * “Move static members” alt + cmd + v
     * Then select address to move.
     */
    public static AreaRangeSpec ofAreaRange(float minArea, float maxArea) {
        return new AreaRangeSpec(minArea, maxArea);
    }

    public static BelowAreaSpec blowArea(float maxBuildingArea) {
        return new BelowAreaSpec(maxBuildingArea);
    }

    public static MaterialSpec ofMaterial(EstateMaterial material) {
        return new MaterialSpec(material);
    }

    public static NotSpec not(Spec placementSpec) {
        return new NotSpec(placementSpec);
    }

    public static PlacementSpec placedIn(EstatePlacement placement) {
        return new PlacementSpec(placement);
    }

    public static TypeSpec ofType(EstateType type) {
        return new TypeSpec(type);
    }
}

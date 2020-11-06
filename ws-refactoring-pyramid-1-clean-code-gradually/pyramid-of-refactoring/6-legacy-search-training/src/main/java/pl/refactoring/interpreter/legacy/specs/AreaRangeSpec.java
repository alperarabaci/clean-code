package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

public class AreaRangeSpec implements Spec {
    private final float minArea;
    private final float maxArea;

    /**
     * @param minArea
     * @param maxArea
     */
    AreaRangeSpec(float minArea, float maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getBuildingArea() >= minArea && estate.getBuildingArea() <= maxArea;
    }
}

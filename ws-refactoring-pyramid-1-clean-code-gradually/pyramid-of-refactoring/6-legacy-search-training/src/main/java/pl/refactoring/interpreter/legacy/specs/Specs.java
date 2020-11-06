package pl.refactoring.interpreter.legacy.specs;

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
}

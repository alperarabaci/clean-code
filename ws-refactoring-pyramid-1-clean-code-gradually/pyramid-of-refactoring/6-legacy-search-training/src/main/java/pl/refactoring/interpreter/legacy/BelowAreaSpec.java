package pl.refactoring.interpreter.legacy;

public class BelowAreaSpec {

	private float maxBuildingArea;

	public BelowAreaSpec(float maxBuildingArea) {
		this.maxBuildingArea = maxBuildingArea;
	}

	public float getMaxBuildingArea() {
		return maxBuildingArea;
	}

	/**
	 * In eclipse to move method use: ⌥ ⌘ V (alt + cmd + V)
	 * @param estate
	 * @return
	 */
	boolean check(RealEstate estate) {
		return estate.getBuildingArea() < getMaxBuildingArea();
	}

}

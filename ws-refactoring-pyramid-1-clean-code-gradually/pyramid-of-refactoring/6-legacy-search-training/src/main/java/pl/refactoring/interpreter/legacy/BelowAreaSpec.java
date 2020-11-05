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
	 * In eclipse to "move refactor" use: ⌥ ⌘ V (alt + cmd + V)
	 * For full list check: https://www.shortcutfoo.com/app/dojos/eclipse-mac/cheatsheet
	 * Also cmd + shift + l open shortcut list.
	 * @param estate
	 * @return
	 */
	boolean isSatisfiedBy(RealEstate estate) {
		return estate.getBuildingArea() < getMaxBuildingArea();
	}

}

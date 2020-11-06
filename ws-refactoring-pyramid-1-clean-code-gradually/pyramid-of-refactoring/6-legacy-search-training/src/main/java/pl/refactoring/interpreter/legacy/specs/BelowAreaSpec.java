package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

public class BelowAreaSpec implements Spec {

	private float maxBuildingArea;

	/**
	 * IntelliJ IDEA refactor menu: fn + kntrl + T (eclipse style)
	 * Then select "Replace Constructor with Factory Method"
	 */
	private BelowAreaSpec(float maxBuildingArea) {
		this.maxBuildingArea = maxBuildingArea;
	}

	public static BelowAreaSpec blowArea(float maxBuildingArea) {
		return new BelowAreaSpec(maxBuildingArea);
	}

	public float getMaxBuildingArea() {
		return maxBuildingArea;
	}

	/**
	 * 1. In eclipse to "move refactor" use: ⌥ ⌘ V (alt + cmd + V)
	 * For full list check: https://www.shortcutfoo.com/app/dojos/eclipse-mac/cheatsheet
	 * Also cmd + shift + l open shortcut list.
	 * 
	 * 2. select method and extract to interface: 
	 * 2.1 cmd + shift + t
	 * 2.2 extract interface
	 * 2.3 this refactor also changed BelowAreaSpec declaration as Spec interface in RealEstateFinder 
	 * @param estate
	 * @return
	 */
	@Override
	public boolean isSatisfiedBy(RealEstate estate) {
		return estate.getBuildingArea() < getMaxBuildingArea();
	}

}

package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstateMaterial;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

/**
 * alper - 05/11/2020
 */
public class MaterialSpec implements Spec {

    private EstateMaterial material;

    public MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public EstateMaterial getMaterial() {
        return material;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getMaterial().equals(this);
    }
}

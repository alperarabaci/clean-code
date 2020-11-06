package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstateMaterial;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

/**
 * alper - 05/11/2020
 */
public class MaterialSpec implements Spec {

    private EstateMaterial material;

    private MaterialSpec(EstateMaterial material) {
        this.material = material;
    }

    public static MaterialSpec ofMaterial(EstateMaterial material) {
        return new MaterialSpec(material);
    }

    public EstateMaterial getMaterial() {
        return material;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getMaterial().equals(this.material);
    }
}

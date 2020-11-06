package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.EstateType;
import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

public class TypeSpec implements Spec {
    private final EstateType type;

    TypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getType().equals(type);
    }
}

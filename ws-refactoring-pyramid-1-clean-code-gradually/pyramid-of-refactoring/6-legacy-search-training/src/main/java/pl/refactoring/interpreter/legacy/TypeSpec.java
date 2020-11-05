package pl.refactoring.interpreter.legacy;

public class TypeSpec implements Spec {
    private final EstateType type;

    public TypeSpec(EstateType type) {
        this.type = type;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return estate.getType().equals(type);
    }
}

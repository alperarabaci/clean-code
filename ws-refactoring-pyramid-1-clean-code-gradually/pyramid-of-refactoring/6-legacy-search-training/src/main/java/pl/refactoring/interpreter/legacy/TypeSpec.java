package pl.refactoring.interpreter.legacy;

public class TypeSpec {
    private final EstateType type;

    public TypeSpec(EstateType type) {
        this.type = type;
    }

    boolean isSatisfiedBy(RealEstate estate) {
        return estate.getType().equals(type);
    }
}

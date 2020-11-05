package pl.refactoring.interpreter.legacy;

public class AndSpec {
    private final Spec firstSpec;
    private final Spec secondSpec;

    public AndSpec(Spec firstSpec, Spec secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    boolean isSatisfiedBy(RealEstate estate) {
        return secondSpec.isSatisfiedBy(estate)  && firstSpec.isSatisfiedBy(estate);
    }
}

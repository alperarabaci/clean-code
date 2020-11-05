package pl.refactoring.interpreter.legacy;

public class AndSpec implements Spec {
    private final Spec firstSpec;
    private final Spec secondSpec;

    public AndSpec(Spec firstSpec, Spec secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return secondSpec.isSatisfiedBy(estate)  && firstSpec.isSatisfiedBy(estate);
    }
}

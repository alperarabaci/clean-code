package pl.refactoring.interpreter.legacy;

public class AndSpec {
    private final Spec firstSpec;
    private final Spec secondSpec;

    public AndSpec(Spec firstSpec, Spec secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    public Spec getFirstSpec() {
        return firstSpec;
    }

    public Spec getSecondSpec() {
        return secondSpec;
    }

    boolean isSatisfiedBy(RealEstate estate) {
        return getSecondSpec().isSatisfiedBy(estate)  && getFirstSpec().isSatisfiedBy(estate);
    }
}

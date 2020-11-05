package pl.refactoring.interpreter.legacy;

public class NotSpec implements Spec {
    private final Spec spec;

    public NotSpec(Spec placementSpec) {
        this.spec = placementSpec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return !spec.isSatisfiedBy(estate);
    }
}

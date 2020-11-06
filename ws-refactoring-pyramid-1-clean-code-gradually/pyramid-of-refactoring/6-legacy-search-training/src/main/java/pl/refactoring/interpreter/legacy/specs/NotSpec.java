package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

public class NotSpec implements Spec {
    private final Spec spec;

    private NotSpec(Spec placementSpec) {
        this.spec = placementSpec;
    }

    public static NotSpec not(Spec placementSpec) {
        return new NotSpec(placementSpec);
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return !spec.isSatisfiedBy(estate);
    }
}

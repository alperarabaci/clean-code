package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

class NotSpec implements Spec {
    private final Spec spec;

    NotSpec(Spec placementSpec) {
        this.spec = placementSpec;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return !spec.isSatisfiedBy(estate);
    }
}

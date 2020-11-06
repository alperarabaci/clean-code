package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.RealEstate;
import pl.refactoring.interpreter.legacy.Spec;

import java.util.Arrays;

public class AndSpec implements Spec {

    private Spec[] specs;

    public AndSpec(Spec... specs) {
        this.specs = specs;
    }

    public boolean isSatisfiedBy(RealEstate estate) {
        return Arrays.stream(specs).allMatch(spec -> spec.isSatisfiedBy(estate));
    }

}

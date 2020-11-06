package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.Spec;

import java.util.List;

public class AndSpecBuilder {
    private List<Spec> specs;

    public AndSpecBuilder withSpec(Spec spec) {
        this.specs.add(spec);
        return this;
    }

    public AndSpecBuilder withSpec(Spec spec1, Spec spec2) {
        return withSpec(spec1).withSpec(spec2);
    }

    public AndSpecBuilder withSpec(Spec spec1, Spec spec2, Spec spec3) {
        return withSpec(spec1).withSpec(spec2).withSpec(spec3);
    }

    public AndSpec createAndSpec() {
        return new AndSpec(specs.toArray(new Spec[specs.size()]));
    }
}
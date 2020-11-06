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
        withSpec(spec1);
        withSpec(spec2);
        return this;
    }

    public AndSpecBuilder withSpec(Spec spec1, Spec spec2, Spec spec3) {
        withSpec(spec1);
        withSpec(spec2);
        withSpec(spec3);
        return this;
    }

    public AndSpec createAndSpec() {
        return new AndSpec(specs.toArray(new Spec[specs.size()]));
    }
}
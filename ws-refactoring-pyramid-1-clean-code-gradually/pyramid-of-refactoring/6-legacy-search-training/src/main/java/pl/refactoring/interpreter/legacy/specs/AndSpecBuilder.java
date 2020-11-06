package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.Spec;

public class AndSpecBuilder {
    private Spec[] specs;

    public AndSpecBuilder withSpec(Spec... specs) {
        this.specs = specs;
        return this;
    }

    public AndSpec createAndSpec() {
        return new AndSpec(specs);
    }
}
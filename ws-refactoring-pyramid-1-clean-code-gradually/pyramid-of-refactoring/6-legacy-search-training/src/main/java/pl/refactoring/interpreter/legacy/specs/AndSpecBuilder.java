package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.Spec;

import java.util.Arrays;
import java.util.List;

public class AndSpecBuilder {
    private List<Spec> specs;

    public AndSpecBuilder withSpec(Spec... specs) {
        this.specs = Arrays.asList(specs);
        return this;
    }

    public AndSpecBuilder withSpec(Spec spec) {
        this.specs.add(spec);
        return this;
    }

    public AndSpec createAndSpec() {
        return new AndSpec(specs.toArray(new Spec[specs.size()]));
    }
}
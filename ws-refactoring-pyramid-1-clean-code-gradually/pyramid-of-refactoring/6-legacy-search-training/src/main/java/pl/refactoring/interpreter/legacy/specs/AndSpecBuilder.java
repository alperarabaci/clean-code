package pl.refactoring.interpreter.legacy.specs;

import pl.refactoring.interpreter.legacy.Spec;

import java.util.ArrayList;
import java.util.List;

public class AndSpecBuilder {
    private List<Spec> specs = new ArrayList<>();

    public AndSpecBuilder withSpec(Spec spec) {
        this.specs.add(spec);
        return this;
    }

    public AndSpec createAndSpec() {
        return new AndSpec(specs.toArray(new Spec[specs.size()]));
    }
}
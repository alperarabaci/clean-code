package pl.refactoring.interpreter.legacy;

public class AndSpec {
    private final Spec specArea;
    private final Spec specMaterial;

    public AndSpec(Spec specArea, Spec specMaterial) {
        this.specArea = specArea;
        this.specMaterial = specMaterial;
    }

    public Spec getSpecArea() {
        return specArea;
    }

    public Spec getSpecMaterial() {
        return specMaterial;
    }
}

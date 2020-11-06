package pl.refactoring.interpreter.legacy;

import pl.refactoring.interpreter.legacy.specs.*;

import java.util.List;
import java.util.stream.Collectors;

import static pl.refactoring.interpreter.legacy.specs.MaterialSpec.ofMaterial;
import static pl.refactoring.interpreter.legacy.specs.PlacementSpec.placedIn;

/**
 * Copyright (c) 2020 IT Train Wlodzimierz Krakowski (www.refactoring.pl)
 * Sources are available only for personal usage by Udemy students of this course.
 */
public class RealEstateFinder {
    private List<RealEstate> repository;

    public RealEstateFinder(List<RealEstate> repository) {
        this.repository = repository;
    }

    /**
     * Replace while method with collect.
     * @param belowAreaSpec
     * @return
     */
    private List<RealEstate> bySpec(Spec belowAreaSpec) {
        /**
         * foundRealEstates variable removed.
         * alt cmd I: inline selected method or variable (IntelliJ IDEA, i will check it in Eclipse too)
         */
        return repository.stream()
                .filter(belowAreaSpec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    public List<RealEstate> byBelowArea(float maxBuildingArea){
        /**
         * spec variable removed, used inline variable
         * alt cmd I: inline selected method or variable (IntelliJ IDEA, i will check it in Eclipse too)
         */
        return bySpec(BelowAreaSpec.create(maxBuildingArea));
    }

	public List<RealEstate> byMaterial(EstateMaterial material){
        return bySpec(ofMaterial(material));
    }

    public List<RealEstate> byMaterialBelowArea(EstateMaterial material, float maxBuildingArea){
        //I don't prefer using inline variable at this method:
        Spec specArea = BelowAreaSpec.create(maxBuildingArea);
        Spec specMaterial = ofMaterial(material);

        return bySpec(new AndSpec(specArea, specMaterial));
    }

    public List<RealEstate> byPlacement(EstatePlacement placement){
        return bySpec(placedIn(placement));
    }

    public List<RealEstate> byAvoidingPlacement(EstatePlacement placement){
        return bySpec(new NotSpec(placedIn(placement)));
    }

    public List<RealEstate> byAreaRange(float minArea, float maxArea){
        /**
         * Extract to temp method
         * IntelliJ IDEA refactor menu: fn + kntrl + T (eclipse style)
         * After generate Introduce Parameter Object "inline parameter": cmd +alt + I (eclipse style)
         */
        Spec rangeAreaSpec = new AreaRangeSpec(minArea, maxArea);
        return bySpec(rangeAreaSpec);
    }

    public List<RealEstate> byType(EstateType type){
        return bySpec(new TypeSpec(type));
    }

    public List<RealEstate> byTypePlacementMaterial(EstateType type, EstatePlacement placement, EstateMaterial material){
        TypeSpec typeSpec = new TypeSpec(type);
        PlacementSpec placementSpec = placedIn(placement);
        MaterialSpec materialSpec = ofMaterial(material);

        Spec andSpec = new AndSpec(typeSpec, placementSpec, materialSpec);

        return bySpec(andSpec);
    }
}

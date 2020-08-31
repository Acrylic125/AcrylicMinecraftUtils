package com.acrylic.version_latest.Utils.Weight;

import lombok.Getter;

@Getter
public class WeightComparatorObject<C extends WeightComparator<P>,P> {

    private final float maximumWeight;
    private final C obj;

    public WeightComparatorObject(float maximumWeight, C obj) {
        this.maximumWeight = maximumWeight;
        this.obj = obj;
    }

}

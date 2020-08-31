package com.acrylic.version_latest.Utils.Weight;

import com.acrylic.version_latest.Probability.Probability;
import com.acrylic.version_latest.Utils.Weight.Exceptions.WeightOutOfBounds;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * HOW TO USE:
 * 1. Create a list that contains the object that you want to use this on.
 * 2. Instantiate this, and specify <C> as the object you want to compare.
 *    Specify <P> as the as the produced object.
 *
 *    Example:
 *      - C extends WeightComparator<Material>
 *      - P MUST be Material.
 *
 * 3. Use .get() to retrieve a random P based on it's specified weight.
 *
 * @param <C> Comparison
 * @param <P> Produced
 */
public final class WeightProducer<C extends WeightComparator<P>, P> {

    private final ArrayList<WeightComparatorObject<C,P>> weights = new ArrayList<>();
    private final int totalWeight;

    public WeightProducer(ArrayList<C> weights) {
        weights.sort(Comparator.comparingInt(WeightComparator::getWeight));
        int sum = 0;
        for (C weight : weights) {
            float s = weight.getWeight();
            if (s < 0) throw new WeightOutOfBounds();
            sum += s;
            this.weights.add(new WeightComparatorObject<>(sum,weight));
        }
        totalWeight = sum;
    }

    public P get() {
        int retrieved = getRandomWeight();
        for (WeightComparatorObject<C,P> weight : weights) {
            if (retrieved <= weight.getMaximumWeight()) return weight.getObj().getProduced();
        }
        return null;
    }

    private int getRandomWeight() {
        return new Probability().getInt(0,totalWeight);
    }


}

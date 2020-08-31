package com.acrylic.version_latest.Utils.Weight;

/**
 * Implement this method for the object to be used by WeightProducer.
 * @param <P> The object type you want to be used as an output.
 */
public interface WeightComparator<P> {

    /**
     * The weight of the object. Do note that the weight MUST BE GREATER THAN 0!
     */
    int getWeight();

    /**
     * The object you want to return IF this object gets chosen.
     */
    P getProduced();

}

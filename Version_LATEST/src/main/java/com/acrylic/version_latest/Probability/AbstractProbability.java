package com.acrylic.version_latest.Probability;

public abstract class AbstractProbability {

    /**
     * Random number generated.
     */
    double random = Math.random();

    /**
     *
     * @param chance The % chance
     * @return Outputs true if the chance randomizer is successful
     * based on the chance value.
     */
    abstract boolean chance(float chance);

    /**
     *
     * @param range1 Minimum value
     * @param range2 Maximum vlaue
     * @return A random INTEGER between range1 and range2
     */
    abstract int getInt(int range1, int range2);

    /**
     *
     * @param range1 Minimum value
     * @param range2 Maximum vlaue
     * @return A random DOUBLE between range1 and range2
     */
    abstract double getNumber(double range1, double range2);

    /**
     *
     * @param range1 Minimum value
     * @param range2 Maximum vlaue
     * @return A random FLOAT between range1 and range2
     */
    abstract float getNumber(float range1, float range2);

    protected double generateNumber(double range1, double range2) {
        double base = Math.min(range1, range2);
        return ((Math.abs(range2 - range1) + 1) * random) + base;
    }

}

package alt.sim.model;

public interface RatioInterface {

    /** Compare antecedent value with consequent for set the low or the high. */
    void compareSize();

    /** Execute the scale of the Ratio. */
    void scale();

    /**
     * @param antecedent the value of antecedent in the Ratio.
     * @param consequent the value of consequent in the Ratio.
     */
    void setRatioValue(double antecedent, double consequent);
}

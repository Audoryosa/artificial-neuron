package com.audriuskumpis;

/**
 * Interface for activation functions
 */
public interface ActivationFormula {

    /**
     * Applies given input for activation function.
     * @param input input to apply
     * @return return 1 or 0, dependent on activation function
     */
    int apply(double input);
}

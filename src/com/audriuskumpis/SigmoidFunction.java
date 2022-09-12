package com.audriuskumpis;

import static java.lang.Math.E;

public class SigmoidFunction implements ActivationFormula {

    @Override
    public int apply(double input) {
        double value = 1 / (1 + Math.pow(E, -input));
        return (int) Math.round(value);
    }
}

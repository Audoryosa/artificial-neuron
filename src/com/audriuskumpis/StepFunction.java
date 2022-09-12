package com.audriuskumpis;

public class StepFunction implements ActivationFormula {

    @Override
    public int apply(double input) {
        return input < 0 ? 0 : 1;
    }
}

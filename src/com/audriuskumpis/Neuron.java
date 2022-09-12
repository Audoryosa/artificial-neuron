package com.audriuskumpis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Neuron {

    private static final double E = Math.exp(1);

    private double[][] input;
    private double[] weight;
    private int[] output;
    private Option option;


    public Neuron(double[][] input, int[] output, Option option) {
        this.input = input;
        this.output = output;
        this.option = option;
        // init weights array
        weight = new double[input[0].length];
    }

    public double[] getWeight() {
        // randomize the weights
        randomizeWeights();
        //iterating until we get all equations equal without changing weights
        while (true) {
            // stores how many equations were equal with generated weights. Reset after all iterations
            List<Boolean> correctEquations = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                double currentRow = 0;
                // summation function
                for (int j = 0; j < input[i].length; j++) {
                    double x = input[i][j];
                    currentRow += x * weight[j];
                }

                // applying activation function
                if (getActivationFormula().apply(currentRow) == output[i]) {
                    // if calculated result is equal to output of the row, we add a flag to our list
                    correctEquations.add(true);
                } else {
                    // if at least one equation was not satisfied, randomize weights again
                    randomizeWeights();
                }
            }
            // if we get all equations satisfied, job is done
            if (correctEquations.size() == output.length && !correctEquations.contains(false)) {
                break;
            }
        }

        return weight;
    }

    /**
     * Returns activation function based on the input from constructor
     * @return an activation function: either step, or sigmoid
     */
    public ActivationFormula getActivationFormula() {
        switch (option) {
            case STEP:
                return new StepFunction();
            case SIGMOID:
                return new SigmoidFunction();
        }

        // should not happen, just making compiler happy
        throw new IllegalArgumentException();
    }

    /**
     * Randomizes weights. Adds 0.001 at every weight.
     * If weight reaches bound (10), new int value -10 < i < 10 is generated for that weight.
     * In this manner we virtually iterate through every number from -10 to 10
     */
    private void randomizeWeights() {
        int low = -10;
        int high = 10;

        Random random = new Random();

        for (int i = 0; i < weight.length; i++) {
            weight[i] += 0.001;
        }

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] > high) {
                weight[i] = random.nextInt(high-low) + low;
            }
        }
    }
}

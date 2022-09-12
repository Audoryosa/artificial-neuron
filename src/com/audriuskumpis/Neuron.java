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
        weight = new double[input[0].length];
    }

    public double[] getWeight() {
        Arrays.fill(weight, -10);
        randomizeWeights();
        while (true) {
            List<Boolean> correctEquations = new ArrayList<>();
            for (int i = 0; i < input.length; i++) {
                double currentRow = 0;
                for (int j = 0; j < input[i].length; j++) {
                    double x = input[i][j];
                    currentRow += x * weight[j];
                }

                if (getActivationFormula().apply(currentRow) == output[i]) {
                    correctEquations.add(true);
                } else {
                    randomizeWeights();
                }
            }
            if (correctEquations.size() == output.length && !correctEquations.contains(false)) {
                break;
            }
        }

        return weight;
    }

    public ActivationFormula getActivationFormula() {
        if (option == Option.STEP) {
            return new StepFunction();
        }
        return new SigmoidFunction();
    }

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

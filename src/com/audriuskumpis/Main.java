package com.audriuskumpis;

public class Main {

    public static void main(String[] args) {

        // init input values, x1 = 1
        double[][] input = new double[][] {
                {1, -0.3, 0.6},
                {1, 0.3, -0.6},
                {1, 1.2, -1.2},
                {1, 1.2, 1.2}
        };

        // output values
        int[] output = new int[] {0, 0, 1, 1};

        // create neuron with given input, expected output and activation function
        Neuron neuron = new Neuron(input, output, Option.SIGMOID);
        double[] weights = neuron.getWeight();

        // print calculated weights
        for (int i = 0; i < weights.length; i++) {
            System.out.println("w" + i + " = " + weights[i]);
        }

    }
}

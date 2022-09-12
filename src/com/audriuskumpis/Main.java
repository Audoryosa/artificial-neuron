package com.audriuskumpis;

public class Main {

    public static void main(String[] args) {

        double[][] input = new double[][] {
                {1, -0.3, 0.6},
                {1, 0.3, -0.6},
                {1, 1.2, -1.2},
                {1, 1.2, 1.2}
        };
        Neuron neuron = new Neuron(input, new int[] {0, 0, 1, 1}, Option.SIGMOID);
        double[] weights = neuron.getWeight();

        for (int i = 0; i < weights.length; i++) {
            System.out.println("w" + i + " = " + weights[i]);
        }

    }
}

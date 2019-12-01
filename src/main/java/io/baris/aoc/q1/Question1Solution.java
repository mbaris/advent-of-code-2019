package io.baris.aoc.q1;

import io.baris.aoc.util.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;

public class Question1Solution {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final String fileName = "moduleWeights.txt";
        final Stream<String> stream = FileUtil.readFileAsStream(fileName);
        System.out.println(new Question1Solution().calculateSum(stream));
    }

    public int calculateSum(Stream<String> stream) {
        return stream.mapToInt(Integer::parseInt)
                .map(this::calculateRequiredFuelForModule)
                .sum();
    }

    public int calculateSumBasic(Stream<String> stream) {
        return stream.mapToInt(Integer::parseInt)
                .map(this::calculateRequiredFuelForModuleBasic)
                .sum();
    }

    public int calculateRequiredFuelForModuleBasic(int a) {
        return a / 3 - 2;
    }


    public int calculateRequiredFuelForModule(int a) {
        if (a < 9) {
            return 0;
        }
        int requiredFuel = calculateRequiredFuelForModuleBasic(a);
        return requiredFuel + calculateRequiredFuelForModule(requiredFuel);
    }
}

package io.baris.aoc.q1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class TyrannyOfTheRocketEquationTest {

    private TyrannyOfTheRocketEquation solution = new TyrannyOfTheRocketEquation();

    @Test
    public void testForSampleInputForPart1() {
        testSampleInput(solution::calculateRequiredFuelForModuleBasic, 14, 2);
        testSampleInput(solution::calculateRequiredFuelForModuleBasic, 12, 2);
        testSampleInput(solution::calculateRequiredFuelForModuleBasic, 1969, 654);
        testSampleInput(solution::calculateRequiredFuelForModuleBasic, 100756, 33583);
    }

    @Test
    public void testSumForPart1() {
        final List<String> numbers = Arrays.asList("14", "12", "1969", "100756");
        testSum(solution::calculateSumBasic, numbers, 34241);
    }

    @Test
    public void testForSampleInputForPart2() {
        testSampleInput(solution::calculateRequiredFuelForModule, 14, 2);
        testSampleInput(solution::calculateRequiredFuelForModule, 12, 2);
        testSampleInput(solution::calculateRequiredFuelForModule, 1969, 966);
        testSampleInput(solution::calculateRequiredFuelForModule, 100756, 50346);
    }

    @Test
    public void testSumPart2() {
        final List<String> numbers = Arrays.asList("14", "12", "1969", "100756");
        testSum(solution::calculateSum, numbers, 51316);
    }

    private void testSum(StreamConsumingIntSupplier function, List<String> input, int expectedResult) {
        final Stream<String> stream = input.stream();
        final int sum = function.apply(stream);
        final String errorMessage = String.format("Output was: %s for input: %s expected result was: %s", sum, input, expectedResult);
        assertEquals(errorMessage, expectedResult, sum);
    }

    private void testSampleInput(IntFunction<Integer> consumer, int input, int expectedResult) {
        final int result = consumer.apply(input);
        final String errorMessage = String.format("Output was: %s for input: %s expected result was: %s", result, input, expectedResult);
        assertEquals(errorMessage, expectedResult, result);
    }

    private interface StreamConsumingIntSupplier {
        int apply(Stream<String> solve);
    }
}

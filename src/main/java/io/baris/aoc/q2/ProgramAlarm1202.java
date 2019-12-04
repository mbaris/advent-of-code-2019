package io.baris.aoc.q2;

import io.baris.aoc.util.FileUtil;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProgramAlarm1202 {

    private static final boolean verbose = false;

    public static void main(String[] args) throws Exception {
        final String fileName = "gravityAssistInput.txt";
        final Stream<String> stream = FileUtil.readFileAsStream(fileName);
        final Optional<String> inputString = stream.findFirst();
        inputString.ifPresent(input -> new ProgramAlarm1202().part2Solution(input));
    }

    private void part1Solution(String inputString) {
        final String[] splittedInput = inputString.split(",");
        final int[] opcode = Stream.of(splittedInput).mapToInt(Integer::parseInt).toArray();
        System.out.println("Solution: " + runInstructions(opcode, 12, 2));
    }

    private void part2Solution(String inputString) {
        IntStream.range(1, 99).parallel().forEach(i -> {
            IntStream.range(1, 99).parallel().forEach(j -> {
                final String[] splittedInput = inputString.split(",");
                final int[] opcode = Stream.of(splittedInput).mapToInt(Integer::parseInt).toArray();
                int result = runInstructions(opcode, i, j);
                if (result == 19690720) {
                    System.out.println(String.format("Noun: %s Verb: %s Solution:%s%s", i, j, i, j));
                }
            });
        });
    }

    public int runInstructions(int[] opcode, int i, int j) {
        opcode[1] = i;
        opcode[2] = j;
        processOpCodes(opcode);
        return opcode[0];
    }

    public void processOpCodes(int[] opcode) {
        int currentPosition = 0;
        while (true) {
            if (verbose) {
                System.out.println("CurrentPosition: " + currentPosition + " intCode: " + Arrays.stream(opcode).boxed().collect(Collectors.toList()));
            }
            switch (opcode[currentPosition]) {
                case 1:
                    currentPosition = addition(opcode, currentPosition);
                    break;
                case 2:
                    currentPosition = multiplication(opcode, currentPosition);
                    break;
                case 99:
                    if (verbose) {
                        System.out.println("------------------------------ halting ------------------------------");
                    }
                    return;
                default:
                    if (verbose) {
                        System.out.println("------------------------------ invalid state ------------------------------");
                    }
                    return;
            }
        }
    }

    public int addition(int[] array, int currentPosition) {
        final int firstInputIndex = array[currentPosition + 1];
        final int secondInputIndex = array[currentPosition + 2];
        final int resultPosition = array[currentPosition + 3];
        final int firstInput = array[firstInputIndex];
        final int secondInput = array[secondInputIndex];
        if (verbose) {
            System.out.println("Adding " + firstInput + " to " + secondInput + " on index" + resultPosition);
        }
        array[resultPosition] = firstInput + secondInput;
        return currentPosition + 4;
    }

    public int multiplication(int[] array, int currentPosition) {
        final int firstInputIndex = array[currentPosition + 1];
        final int secondInputIndex = array[currentPosition + 2];
        final int resultPosition = array[currentPosition + 3];
        final int firstInput = array[firstInputIndex];
        final int secondInput = array[secondInputIndex];
        if (verbose) {
            System.out.println("Multiplying " + firstInput + " with " + secondInput + " on index: " + resultPosition);
        }
        array[resultPosition] = firstInput * secondInput;
        return currentPosition + 4;
    }
}

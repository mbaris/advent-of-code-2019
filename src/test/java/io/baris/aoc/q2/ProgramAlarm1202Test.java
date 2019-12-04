package io.baris.aoc.q2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ProgramAlarm1202Test {

    private ProgramAlarm1202 programAlarm1202 = new ProgramAlarm1202();

    @Test
    public void testAddition() {
        int[] opcode1 = new int[]{1, 0, 0, 0, 99};
        programAlarm1202.processOpCodes(opcode1);
        assertArrayEquals(new int[]{2, 0, 0, 0, 99}, opcode1);

        int[] opcode2 = new int[]{1, 1, 1, 4, 99, 5, 6, 0, 99};
        programAlarm1202.processOpCodes(opcode2);
        assertArrayEquals(new int[]{30, 1, 1, 4, 2, 5, 6, 0, 99}, opcode2);

    }

    @Test
    public void testMultiplication() {
        int[] opcode1 = new int[]{2, 3, 0, 3, 99};
        programAlarm1202.processOpCodes(opcode1);
        assertArrayEquals(new int[]{2, 3, 0, 6, 99}, opcode1);

        int[] opcode2 = new int[]{2, 4, 4, 5, 99, 0};
        programAlarm1202.processOpCodes(opcode2);
        assertArrayEquals(new int[]{2, 4, 4, 5, 99, 9801}, opcode2);
    }

    @Test
    public void process() {
        int[] array = {1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
        int[] expected = {3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50};
        programAlarm1202.processOpCodes(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void runInstructions() {
        int[] array = {1, 0, 0, 3, 2, 3, 11, 0, 99, 30, 40, 50};
        int result = programAlarm1202.runInstructions(array, 9, 10);
        assertEquals(result, 3500);
    }

}
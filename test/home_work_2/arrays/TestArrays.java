package home_work_2.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Named.named;

public class TestArrays {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final static PrintStream originalOut = System.out;
    private final static int[] initArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private final static String allElementsArray = "1 2 3 4 5 6 7 8 9 0";
    private final static String eachSecondElementArray = "1 3 5 7 9";

    /**
     * Before each test case redirect the print stream from console to buffer and clear the buffer
     * */
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
    }

    /**
     * After each test case restore the print stream to a default state
     * */
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /**
     * Use ParameterizedTest to verify methods of both PrintEachSecondElement and PrintAllElements classes
     * */
    @ParameterizedTest(name="{index} - {0}")
    @DisplayName("Print all with DoWhile loop")
    @MethodSource("objectProvider")
    public void printAllWithDoWhileOperation(IArraysOperation object, String expected) {
        object.DoWhileOperation(initArray);
        assertEquals(expected, outContent.toString());
    }

    @ParameterizedTest(name="{index} - {0}")
    @DisplayName("Print all with While loop")
    @MethodSource("objectProvider")
    public void printAllWithWhileOperation(IArraysOperation object, String expected) {
        object.WhileOperation(initArray);
        assertEquals(expected, outContent.toString());
    }

    @ParameterizedTest(name="{index} - {0}")
    @DisplayName("Print all with For loop")
    @MethodSource("objectProvider")
    public void printAllWithForOperation(IArraysOperation object, String expected) {
        object.ForOperation(initArray);
        assertEquals(expected, outContent.toString());
    }

    @ParameterizedTest(name="{index} - {0}")
    @DisplayName("Print all with ForEach loop")
    @MethodSource("objectProvider")
    public void printWithForEachOperation(IArraysOperation object, String expected) {
        object.ForEachOperation(initArray);
        assertEquals(expected, outContent.toString());
    }

    public static Stream<Arguments> objectProvider() {
        return Stream.of(
                Arguments.arguments(
                        named("Print all elements", new PrintAllElements()), allElementsArray),
                Arguments.arguments(
                        named("Print each second element", new PrintEachSecondElement()), eachSecondElementArray)
        );
    }
}

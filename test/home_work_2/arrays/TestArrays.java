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

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Print all with DoWhile loop")
    public void printAllWithDoWhileOperation() {
        int[] array = {1, 2, 3};
        PrintAllElements p = new PrintAllElements();
        p.DoWhileOperation(array);
        assertEquals("1 2 3", outContent.toString());
    }
    @Test
    @DisplayName("Print all with While loop")
    public void printAllWithWhileOperation() {
        int[] array = {1, 2, 3};
        PrintAllElements p = new PrintAllElements();
        p.WhileOperation(array);
        assertEquals("1 2 3", outContent.toString());
    }
    @Test
    @DisplayName("Print all with For loop")
    public void printAllWithForOperation() {
        int[] array = {1, 2, 3};
        PrintAllElements p = new PrintAllElements();
        p.ForOperation(array);
        assertEquals("1 2 3", outContent.toString());
    }
    @ParameterizedTest(name="{index} - {0}")
    @DisplayName("Print all with ForEach loop")
    @MethodSource("objectProvider")
    public void printWithForEachOperation(IArraysOperation object, String expected) {
        outContent.reset();
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

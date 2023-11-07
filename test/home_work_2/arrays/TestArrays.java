package home_work_2.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.BeforeEach.*;

public class TestArrays {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

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
    @Test
    @DisplayName("Print all with ForEach loop")
    public void printAllWithForEachOperation() {
        int[] array = {1, 2, 3};
        PrintAllElements p = new PrintAllElements();
        p.ForEachOperation(array);
        assertEquals("1 2 3", outContent.toString());
    }
}

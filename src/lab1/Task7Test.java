package lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {
    @Test
    void shouldReturnEmptyString() {
        assertEquals("", Task7.deleteSinglesAndSpaces(" d i m a "));
    }

    @Test
    void shouldReturnSymbols() {
        assertEquals(". : ^ [ ] { } ( ) * & ? ^ % $ # @ ! | / \\", Task7.deleteSinglesAndSpaces(" . : a ^ [ ] { } ( ) * & ? ^ % $ # @ ! | / \\ "));
    }

    @Test
    void shouldReturnSameString() {
        assertEquals("Standing by my window, breathing summer breeze",
                Task7.deleteSinglesAndSpaces("Standing by my window, breathing summer breeze"));
        assertEquals("Took us by the hands and up we go",
                Task7.deleteSinglesAndSpaces(" Took us by the hands and up we go "));
    }

    @Test
    void shouldThrowEmptyStringException1() throws EmptyStringException {
        EmptyStringException exception = assertThrows(EmptyStringException.class, () -> {
            Task7.deleteSinglesAndSpaces("");
        });
        assertTrue(exception.getMessage().contains("empty string"));
    }

    void shouldThrowEmptyStringException2() throws EmptyStringException {
        EmptyStringException exception = assertThrows(EmptyStringException.class, () -> {
            Task7.deleteSinglesAndSpaces("       ");
        });
        assertTrue(exception.getMessage().contains("empty string"));
    }

}
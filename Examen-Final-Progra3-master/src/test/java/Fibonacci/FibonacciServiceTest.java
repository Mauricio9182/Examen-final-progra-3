package Fibonacci;

import com.beesion.ms.service.FibonacciService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciServiceTest {

    private final FibonacciService service = new FibonacciService();

    @Test
    void testFibonacciDefault() {
        List<Integer> result = service.generateFibonacci(new int[]{0, 1}, 9);
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8, 13, 21), result);
    }

    @Test
    void testFibonacciCustom() {
        List<Integer> result = service.generateFibonacci(new int[]{2, 3}, 5);
        assertEquals(List.of(2, 3, 5, 8, 13), result);
    }

    @Test
    void testFibonacciZero() {
        List<Integer> result = service.generateFibonacci(new int[]{5, 8}, 0);
        assertTrue(result.isEmpty());
    }

    @Test
    void testInvalidSignature() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                service.generateFibonacci(new int[]{5}, 4));
        assertEquals("La firma debe tener exactamente dos elementos.", exception.getMessage());
    }
}

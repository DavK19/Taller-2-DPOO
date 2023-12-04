package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest{

    @Test
    public void testSuma() {
        int resultado = 3+5;
        assertEquals(8, resultado, "La suma de 3 y 5 debe ser 8");
    }
}
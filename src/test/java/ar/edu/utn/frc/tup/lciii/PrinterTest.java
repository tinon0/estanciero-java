package ar.edu.utn.frc.tup.lciii;

import org.junit.jupiter.api.Test;
import static com.diogonunes.jcolor.Ansi.*;
import static com.diogonunes.jcolor.Attribute.*;
import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    @Test
    void error(){
        assertThrows(InterruptedException.class, () -> {
            Printer.println("Hola");
            throw new InterruptedException("jeje");
        });
    }
    @Test
    void pruebaJColor(){
        Printer.println(colorize("Esto es una prueba", YELLOW_TEXT(), ITALIC()));
        Printer.println(colorize("Esto es una prueba", BLACK_TEXT(), WHITE_BACK()));
        Printer.println(colorize("Esto es una prueba", CYAN_TEXT(), ITALIC()));
        Printer.println(colorize("Esto es una prueba", BLACK_TEXT(), MAGENTA_BACK()));
    }
}
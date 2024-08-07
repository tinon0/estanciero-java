package ar.edu.utn.frc.tup.lciii.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {
    @Test
    public void testPerfilConstructor(){
        Profile testProfile = new Profile("Raikou");

        assertEquals("Raikou", testProfile.getNombre());
        assertEquals(0, testProfile.getLoses());
        assertEquals(0, testProfile.getWins());
    }
}

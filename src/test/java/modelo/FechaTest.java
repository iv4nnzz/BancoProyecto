/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 9spot
 */
public class FechaTest {

    @Test
    public void testConstructorGettersSettersAndToString() {
        Fecha f = new Fecha(5, 10, 2020);
        assertEquals(5, f.getDia());
        assertEquals(10, f.getMes());
        assertEquals(2020, f.getAño());

        f.setDia(1);
        f.setMes(1);
        f.setAño(2025);
        assertEquals(1, f.getDia());
        assertEquals(1, f.getMes());
        assertEquals(2025, f.getAño());

        assertEquals("1/1/2025", f.toString());
    }
}
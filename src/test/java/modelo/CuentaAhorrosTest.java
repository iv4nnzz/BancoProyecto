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
public class CuentaAhorrosTest {

    @Test
    public void testConsignarIncrementaSaldo() {
        Fecha fecha = new Fecha(1,1,2020);
        CuentaAhorros ca = new CuentaAhorros("0001", "Carlos", 100.0, fecha);
        ca.consignar(50.0);
        assertEquals(150.0, ca.obtenerSaldo(), 1e-9);
    }

    @Test
    public void testRetirarValido() {
        Fecha fecha = new Fecha(1,1,2020);
        CuentaAhorros ca = new CuentaAhorros("0002", "Ana", 200.0, fecha);
        boolean ok = ca.retirar(50.0);
        assertTrue(ok);
        assertEquals(150.0, ca.obtenerSaldo(), 1e-9);
    }

    @Test
    public void testRetirarInvalidoNoPermiteSaldoNegativo() {
        Fecha fecha = new Fecha(1,1,2020);
        CuentaAhorros ca = new CuentaAhorros("0003", "Luis", 30.0, fecha);
        boolean ok = ca.retirar(50.0);
        assertFalse(ok);
        assertEquals(30.0, ca.obtenerSaldo(), 1e-9);
    }

    @Test
    public void testImprimirDatosContainsTipo() {
        Fecha fecha = new Fecha(1,1,2020);
        CuentaAhorros ca = new CuentaAhorros("0004", "María", 10.0, fecha);
        String datos = ca.imprimirDatos();
        assertTrue(datos.contains("CUENTA DE AHORROS") || datos.contains("Ahorros"));
    }
}
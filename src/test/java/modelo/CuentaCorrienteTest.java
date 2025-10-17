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
public class CuentaCorrienteTest {

    @Test
    public void testRetiroDentroDeCupoSobregiro() {
        Fecha fecha = new Fecha(2,2,2020);
        CuentaCorriente cc = new CuentaCorriente("1000", "Pedro", 100.0, fecha, 200.0);
        boolean ok = cc.retirar(250.0); 
        assertTrue(ok);
        assertEquals(-150.0, cc.obtenerSaldo(), 1e-9);
    }

    @Test
    public void testRetiroExcedeCupoSobregiro() {
        Fecha fecha = new Fecha(2,2,2020);
        CuentaCorriente cc = new CuentaCorriente("1001", "Sofia", 50.0, fecha, 100.0);
        boolean ok = cc.retirar(200.0);
        assertFalse(ok);
        assertEquals(50.0, cc.obtenerSaldo(), 1e-9);
    }

    @Test
    public void testConstructorSobrecargadoUsaCupoPorDefecto() {
        Fecha fecha = new Fecha(3,3,2021);
        CuentaCorriente cc = new CuentaCorriente("1002", "Marco", 0.0, fecha); 
        assertTrue(cc.getCupoSobregiro() >= 0);
    }

    @Test
    public void testImprimirDatosContainsCorriente() {
        Fecha fecha = new Fecha(4,4,2022);
        CuentaCorriente cc = new CuentaCorriente("1003", "Laura", 20.0, fecha, 500.0);
        String datos = cc.imprimirDatos();
        assertTrue(datos.contains("CUENTA CORRIENTE") || datos.contains("Corriente"));
        assertTrue(datos.contains("Cupo Sobregiro"));
    }
}
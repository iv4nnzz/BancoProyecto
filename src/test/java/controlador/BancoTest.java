/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import modelo.Cuenta;
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
import modelo.*;

public class BancoTest {

    private Banco banco;
    private Fecha fecha;

    @BeforeEach
    public void setup() {
        banco = new Banco();
        fecha = new Fecha(1,1,2020);
    }

    @Test
    public void testAgregarYBuscarCuenta() {
        CuentaAhorros ca = new CuentaAhorros("A1", "Juan", 100.0, fecha);
        banco.agregarCuenta(ca);
        Cuenta encontrada = banco.buscarCuenta("A1");
        assertNotNull(encontrada);
        assertEquals("Juan", encontrada.getNombreDueño());
    }

    @Test
    public void testRealizarConsignacionYConsultarSaldo() {
        CuentaAhorros ca = new CuentaAhorros("A2", "Rosa", 50.0, fecha);
        banco.agregarCuenta(ca);
        boolean ok = banco.realizarConsignacion("A2", 25.0);
        assertTrue(ok);
        assertEquals(75.0, banco.consultarSaldo("A2"), 1e-9);
    }

    @Test
    public void testRealizarRetiroCuentaAhorros() {
        CuentaAhorros ca = new CuentaAhorros("A3", "Pablo", 80.0, fecha);
        banco.agregarCuenta(ca);
        boolean ok = banco.realizarRetiro("A3", 30.0);
        assertTrue(ok);
        assertEquals(50.0, banco.consultarSaldo("A3"), 1e-9);
    }

    @Test
    public void testRealizarRetiroCuentaCorrienteConSobregiro() {
        CuentaCorriente cc = new CuentaCorriente("C1", "Marta", 20.0, fecha, 100.0);
        banco.agregarCuenta(cc);
        boolean ok = banco.realizarRetiro("C1", 100.0);
        assertTrue(ok);
        assertEquals(-80.0, banco.consultarSaldo("C1"), 1e-9);
    }

    @Test
    public void testObtenerDatosCuentaYListar() {
        CuentaAhorros ca = new CuentaAhorros("A4", "Gloria", 200.0, fecha);
        banco.agregarCuenta(ca);
        String datos = banco.obtenerDatosCuenta("A4");
        assertNotNull(datos);
        assertTrue(datos.contains("Gloria") || datos.contains("A4"));

        String lista = banco.listarCuentas();
        assertTrue(lista.contains("A4"));
    }

    @Test
    public void testOperacionesCuentaNoExistente() {
        assertEquals(-1, banco.consultarSaldo("NO_EXISTE"), 1e-9);
        assertFalse(banco.realizarConsignacion("NO_EXISTE", 10.0));
        assertFalse(banco.realizarRetiro("NO_EXISTE", 5.0));
        assertNull(banco.obtenerDatosCuenta("NO_EXISTE"));
    }
}

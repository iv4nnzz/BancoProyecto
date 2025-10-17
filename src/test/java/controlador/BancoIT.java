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

//test de integracion
public class BancoIT {

    @Test
    public void testFlujoCrearCuentasConsignarRetirarYListar() {
        Banco banco = new Banco();
        Fecha fecha = new Fecha(10,10,2020);

        CuentaAhorros ca = new CuentaAhorros("INT-A1", "Cliente A", 500.0, fecha);
        CuentaCorriente cc = new CuentaCorriente("INT-C1", "Cliente B", 100.0, fecha, 200.0);

        banco.agregarCuenta(ca);
        banco.agregarCuenta(cc);

        assertTrue(banco.realizarConsignacion("INT-A1", 100.0));
        assertEquals(600.0, banco.consultarSaldo("INT-A1"), 1e-9);

        assertTrue(banco.realizarRetiro("INT-A1", 200.0));
        assertEquals(400.0, banco.consultarSaldo("INT-A1"), 1e-9);

        assertTrue(banco.realizarRetiro("INT-C1", 250.0)); 
        assertEquals(-150.0, banco.consultarSaldo("INT-C1"), 1e-9);

        assertFalse(banco.realizarRetiro("INT-C1", 100.0));
        assertEquals(-150.0, banco.consultarSaldo("INT-C1"), 1e-9);

        String datosA = banco.obtenerDatosCuenta("INT-A1");
        assertTrue(datosA.contains("Cliente A"));

        String listado = banco.listarCuentas();
        assertTrue(listado.contains("INT-A1"));
        assertTrue(listado.contains("INT-C1"));
    }
}
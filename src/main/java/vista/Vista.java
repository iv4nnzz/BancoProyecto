  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author 9spot
 */
import controlador.Banco;
import modelo.*;
import javax.swing.JOptionPane;
import java.util.Calendar;

public class Vista {
    private Banco banco;
    
    public Vista() {
        this.banco = new Banco();
    }
    
    public void mostrarMenuPrincipal() {
        boolean continuar = true;
        
        while (continuar) {
            String[] opciones = {"Crear Cuenta", "Operaciones", "Listar Cuentas", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "SISTEMA BANCARIO\nSeleccione una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            
            switch (seleccion) {
                case 0:
                    crearCuenta();
                    break;
                case 1:
                    menuOperaciones();
                    break;
                case 2:
                    mostrarMensaje(banco.listarCuentas());
                    break;
                case 3:
                case -1: 
                    continuar = false;
                    mostrarMensaje("Gracias por usar el Sistema Bancario");
                    break;
            }
        }
    }
    private void realizarConsignacion(String numeroCuenta) {
        double monto = solicitarNumero("Ingrese el monto a consignar:");
        if (monto <= 0) {
            mostrarError("El monto debe ser mayor a cero");
            return;
        }
        
        if (banco.realizarConsignacion(numeroCuenta, monto)) {
            mostrarMensaje("Consignación exitosa!\nNuevo saldo: $" + 
                         String.format("%.2f", banco.consultarSaldo(numeroCuenta)));
        } else {
            mostrarError("Error al realizar la consignación");
        }
    }
    
    private void realizarRetiro(String numeroCuenta) {
        double monto = solicitarNumero("Ingrese el monto a retirar:");
        if (monto <= 0) {
            mostrarError("El monto debe ser mayor a cero");
            return;
        }
        
        if (banco.realizarRetiro(numeroCuenta, monto)) {
            mostrarMensaje("Retiro exitoso!\nNuevo saldo: $" + 
                         String.format("%.2f", banco.consultarSaldo(numeroCuenta)));
        } else {
            mostrarError("Fondos insuficientes para realizar el retiro");
        }
    }
    
    private void consultarSaldo(String numeroCuenta) {
        double saldo = banco.consultarSaldo(numeroCuenta);
        mostrarMensaje("Saldo actual: $" + String.format("%.2f", saldo));
    }
    
    private void verInformacion(String numeroCuenta) {
        String info = banco.obtenerDatosCuenta(numeroCuenta);
        mostrarMensaje(info);
    }
    
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", 
                                     JOptionPane.INFORMATION_MESSAGE);
    }
    
    private String solicitarDato(String mensaje) {
        return JOptionPane.showInputDialog(null, mensaje, "Entrada de Datos", 
                                           JOptionPane.QUESTION_MESSAGE);
    }
    
    private double solicitarNumero(String mensaje) {
        String entrada = solicitarDato(mensaje);
        if (entrada == null) return -1;
        
        try {
            return Double.parseDouble(entrada);
        } catch (NumberFormatException e) {
            mostrarError("Debe ingresar un número válido");
            return -1;
        }
    }
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", 
                                     JOptionPane.ERROR_MESSAGE);
    }
}
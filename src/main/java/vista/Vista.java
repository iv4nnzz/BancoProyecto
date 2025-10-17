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

}
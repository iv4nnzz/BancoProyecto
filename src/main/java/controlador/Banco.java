/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 9spot
 */

public class Banco {
    private ArrayList<Cuenta> cuentas;
    
    public Banco() {
        this.cuentas = new ArrayList<>();
    }
    
    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }
   
}

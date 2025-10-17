/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author 9spot
 */
public class CuentaCorriente extends Cuenta {
    private double cupoSobregiro;
    
    public CuentaCorriente(String numero, String nombreDueño, double saldo, 
                          Fecha fechaApertura, double cupoSobregiro) {
        super(numero, nombreDueño, saldo, fechaApertura);
        this.cupoSobregiro = cupoSobregiro;
    }
  
}
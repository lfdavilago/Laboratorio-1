/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author acer
 */
public class Empleado {
    private String Nombre;
    private int Horario;
    private float Salario_minino;
    private int Horas_trabajadas;
    public Empleado(String Nombre, int Horario, float Minimo) {
        this.Nombre = Nombre;
        this.Horario = Horario;
        this.Salario_minino  = Minimo;
        this.Horas_trabajadas = 0;
    }
    // Getters

    public int getHoras_trabajadas(){
        
    return Horas_trabajadas;
    }
    public String getNombre() {
        return Nombre;
    }

    public int getHorario() {
        return Horario;
    }

    public float getSalario_minino() {
        return Salario_minino;
    }
    // Metodos
    public void Contabilizar_horas(int horas_dia){
    this.Horas_trabajadas += horas_dia;
    }
}

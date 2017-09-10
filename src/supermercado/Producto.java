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
public class Producto {
    // Atributos
    private String Nombre;
    private int Cantidad;
    private float  Costo;
    private float Precio;
    private int Ventas;
    private float Ingresos;
    private int Compras;
    private float Egreso;
    private float Ganancia;
    private boolean Estado;
    // Constructor
    public Producto(String Nombre, int Cantidad, float Costo, float Precio) {
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.Costo = Costo;
        this.Precio = Precio;
        this.Ventas = 0;
        this.Ingresos = 0;
        this.Compras = 0;
        this.Egreso = 0;
        this.Ganancia = 0;
    }
    // Getters
    public String getNombre() {
        return Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public float getCosto() {
        return Costo;
    }

    public float getPrecio() {
        return Precio;
    }

    public int getVentas() {
        return Ventas;
    }

    public float getIngresos() {
        return Ingresos;
    }

    public int getCompras() {
        return Compras;
    }

    public float getEgreso() {
        return Egreso;
    }

    public float getGanancia() {
        setGanancia();
        return Ganancia;
    }
    public boolean getEstado(){
        setEstado();
        return Estado;
    }
    // Setters
    public void setCantidad(int Cantidad, int a) {
        if(a==0){
        this.Cantidad += Cantidad;}
        if(a==1){
        this.Cantidad-= Cantidad;}
        }
    
    public void setEstado(){
    if(this.Cantidad == 0){
    this.Estado = false;
    }
    
    }
    public void setVentas(int Ventas) {
        this.Ventas += Ventas;
    }

    public void setIngresos(float Ingresos) {
        this.Ingresos += Ingresos;
    }

    public void setCompras(int Compras) {
        this.Compras += Compras;
    }

    public void setEgreso(float Egreso) {
        this.Egreso += Egreso;
    }

    public void setGanancia() {
        this.Ganancia = this.Ingresos - this.Egreso;
    }
    
}

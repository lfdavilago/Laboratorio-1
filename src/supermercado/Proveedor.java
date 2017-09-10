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
public class Proveedor {
    // Atributos
    private String Nombre;
    private String[] Productos;
    private Factura[] Facturas;
    private int Cont;
    private int deudas;
    // Constructor
    public Proveedor(String Nombre, String[] productos) {
        this.Nombre = Nombre;
        this.Cont = 0;
        this.deudas = 0;
        this.Productos = productos;
        this.Facturas = new Factura[500];
    }
    // Getters
    public String getNombre() {
        return Nombre;
    }

    public String[] getProductos() {
        return Productos;
    }

    public Factura[] getFacturas() {
        return Facturas;
    }
    public int getCont(){
    return Cont;
    }
    // Metodos 
    public void Generar_factura(int codigo, String[] productos, int Cantidad[], float [] costo, float valor,int plazo,boolean estado){
    Factura factura = new Factura (codigo,this.Nombre,productos,Cantidad,costo,valor,plazo,estado);
    this.Facturas[this.Cont]=factura;
    this.Cont++;
    }
    public boolean Pagar_factura(int codigo){
    for(int i = 0; i < this.Cont ; i++){
    if(this.Facturas[i].getCodigo() == codigo){
    this.Facturas[i].Pagar_factura();
    this.deudas--;
    return true;
    }
    }
    return false;
    }
    public void Eliminar_facturas(){
    for(int i = 0; i < this.Cont ; i ++){
    if(this.Facturas[i].getEstado()==true){
    this.Facturas[i] = null;
    }
    }
    
    }
    public int Deudas(){
    for(int i = 0; i < this.Cont ; i++){
    if(this.Facturas[i].getEstado()==false){
    this.deudas++;
    }
    }
    return deudas;
    }
    
}

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
public class Factura {
    // Atributos 
    private int codigo;
    private String Nombre_proveedor;
    private String [] produtos;
    private int [] Cantidad;
    private float [] costo;
    private float Valor;
    private int Plazo;
    private boolean Estado;
    // Contructor
    public Factura(int codigo,String Nombre_proveedor, String[] produtos,int[] Cantidad,float [] costo ,float Valor, int Plazo, boolean Estado) {
        this.Nombre_proveedor = Nombre_proveedor;
        this.produtos = produtos;
        this.Valor = Valor;
        this.Plazo = Plazo;
        this.Estado = Estado;
        this.costo = costo;
        this.Cantidad = Cantidad;
        this.codigo = codigo;
    }
    // Getters

    public String getNombre_proveedor() {
        return Nombre_proveedor;
    }

    public String[] getProdutos() {
        return produtos;
    }

    public int[] getCantidad() {
        return Cantidad;
    }

    public float[] getCosto() {
        return costo;
    }

    public float getValor() {
        return Valor;
    }

    public int getPlazo() {
        return Plazo;
    }

    public boolean getEstado() {
        return Estado;
    }
    
    public int getCodigo(){
       return codigo;
    }
    // Setters
    
    public void Pagar_factura(){
    this.Estado = true;
    }
    public void Descontar_plazo(){
    this.Plazo--;
    }
}

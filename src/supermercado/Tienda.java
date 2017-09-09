/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *Administra los datos relevantes de la tienda 
 * @author Luis Felipe Dávila Goyeneche
 */
public class Tienda {
    // Atributos
    private Producto [] Productos;
    private Proveedor [] Proveedores;
    private Empleado [] Empleados;
    private String [] Jerarquia;
    private String[] Agotados;
    private int Ventas_totales;
    private int Ingreso_total;
    private int Compras_totales;
    private int Egreso_total;
    private int cantidad_productos;
    private int cantidad_proveedores;
    private int cantidad_empleados;
    private int cantidad_agotados;
    private int cantidad_deudas;
    // Constructores
    public Tienda() {
        this.Agotados = new String[500];
        this.Productos = new Producto[500];
        this.Proveedores = new Proveedor[400];
        this.Empleados = new Empleado[7];
        this.Compras_totales = 0;
        this.Egreso_total = 0;
        this.Ingreso_total = 0;
        this.Ventas_totales = 0;
        this.cantidad_productos = 0;
        this.cantidad_proveedores = 0;
        this.cantidad_empleados = 0;
        this.cantidad_agotados = 0;
        this.cantidad_deudas=0;
    }
    // Getters

    public int getCantidad_productos() {
        return cantidad_productos;
    }

    public int getCantidad_proveedores() {
        return cantidad_proveedores;
    }

    public int getCantidad_empleados() {
        return cantidad_empleados;
    }

    public int getCantidad_agotados() {
        return cantidad_agotados;
    }
    
    public Producto[] getProductos() {
        return Productos;
    }

    public Proveedor[] getProveedores() {
        return Proveedores;
    }

    public Empleado[] getEmpleados() {
        return Empleados;
    }

    public String[] getJerarquia() {
      setJerarquia();
        return Jerarquia;
    }

    public int getVentas_totales() {
        return Ventas_totales;
    }

    public int getIngreso_total() {
        return Ingreso_total;
    }

    public int getCompras_totales() {
        return Compras_totales;
    }

    public int getEgreso_total() {
        return Egreso_total;
    }
    public String[] getAgotados(){
    setAgotados();
    return Agotados;
    }
    
    // setters
    public void setJerarquia(){
     int cont = 0;
        int tamano = this.cantidad_productos;
        Producto [] auxiliar = this.Productos;
        while (tamano > 0){
        String Mayor = null;
        int mayor = 0;
        for(int i = 0; i < tamano; i++){
        if(auxiliar[i].getVentas() > mayor){
        mayor = auxiliar[i].getVentas();
        Mayor = auxiliar[i].getNombre();
        }
        }
        this.Jerarquia[cont] = Mayor;
        cont++;
        for(int i = 0; i < tamano ;i ++){
        if(auxiliar[i].getNombre().equals(Mayor)){
        auxiliar[i] = null;
        auxiliar[i] = new Producto("x",0,0,0);
        i = tamano;
        }
        }
        }
    }
    public void setAgotados(){
    for(int i = 0; i < this.cantidad_productos; i++){
    if(this.Productos[i].getEstado()==false){
    this.Agotados[this.cantidad_agotados] = this.Productos[i].getNombre();
    this.cantidad_agotados++;
    }
        }
    }
       
    // Metodos
    /**
     * 
     * @param Nombre_producto
     * @param Cantidad
     * @param n
     * @return  Arreglo de nombres de productos 
     */
    public String[] Generar_venta(String [] Nombre_producto,int [] Cantidad, int n){
    String[] a = new String [n];
    for(int i = 0; i < n ; i++){
    for(int j = 0; j < this.cantidad_productos; j++){
    if(this.Productos[j].getNombre().equals(Nombre_producto[i])){}
    if(this.Productos[j].getCantidad()>= Cantidad[i]){
    this.Productos[j].setCantidad(Cantidad[i],0);
    this.Productos[j].setVentas(Cantidad[i]);
    this.Ventas_totales+=Cantidad[i];
    this.Ingreso_total+= Cantidad[i]*this.Productos[j].getPrecio();
    this.Productos[j].setIngresos(Cantidad[i]*this.Productos[j].getPrecio());
    a[i]="Producto Vendido Exitosamente";
    }else{a[i]="Cantidad insuficiente del producto";}
    }
    }
    return a;
    }
   /**
    * 
    * @param Nombre_proveedor 
    * @param Productos
    * @param Cantidad
    * @param n
    * @param plazo
    * @param Estado
    * @return 
    */
    public boolean Generar_Compra(int codigo_factura,String Nombre_proveedor, String [] Productos, int [] Cantidad, int n,int plazo,int Estado){
        float Valor=0;
        int contador=0;
        boolean Estatus= false;
        float [] Valor_unico = new float [n];
    
        for(int u = 0;u < n ;u++){
        for(int o = 0; o < this.cantidad_productos; o++){
        if(this.Productos[o].getNombre().equals(Productos[u])){
        contador++;
        }
        }
        }
        if(contador!= n){
         return false;
    }
        
    for(int i = 0; i < this.cantidad_proveedores ; i ++){
    if (this.Proveedores[i].getNombre().equals(Nombre_proveedor)){
    for(int a = 0; a < n ; a ++){
    for(int j = 0; j < this.cantidad_productos ; i++){
    if(this.Productos[j].getNombre().equals(Productos[a])){
    this.Productos[j].setCantidad(Cantidad[a], 1);
    this.Productos[j].setCompras(Cantidad[a]);
    Valor_unico[a] = (this.Productos[j].getCosto())*Cantidad[a];
    Valor += Valor_unico[a];
    this.Compras_totales += Cantidad[a];
    this.Egreso_total+= (this.Productos[j].getCosto())*Cantidad[a];
    this.Productos[j].setEgreso((this.Productos[j].getCosto())*Cantidad[a]);
    }
    }}
    if(Estado == 1){ Estatus = true;}
    this.Proveedores[i].Generar_factura(codigo_factura,Productos, Cantidad, Valor_unico,Valor,plazo,Estatus);
    return true;
    }
    }
    
    return false;
}    
    public boolean Anadir_Producto(String Nombre, int Cantidad, float Costo, float Precio){
    if(this.cantidad_productos < 500){
    this.Productos[this.cantidad_productos]= new Producto(Nombre,Cantidad,Costo,Precio);
    this.cantidad_productos++;
    return true;
    }
    return false;
    }
    
    public boolean Anadir_Proveedor(String Nombre_proveedor, String[] productos){
    if(this.cantidad_proveedores < 400){
    this.Proveedores[this.cantidad_proveedores] = new Proveedor(Nombre_proveedor, productos);
    this.cantidad_proveedores++;
    return true;
    }
    return false;
    }
    
    public boolean Anadir_Empleado(String Nombre, int Horario, float sueldo_minimo){
    if(this.cantidad_empleados < 7){
    this.Empleados[this.cantidad_empleados] = new Empleado(Nombre, Horario,sueldo_minimo);
    this.cantidad_empleados++;
    return true;
    }
    return false;
    }
    
    public int getDeudas(int i){
    return this.Proveedores[i].Deudas();
    }
    
    public boolean pagar_Factura( int Codigo, String Nombre){
    for(int i = 0; i < this.cantidad_proveedores; i ++){
    if(this.Proveedores[i].getNombre().equals(Nombre)){
     if( this.Proveedores[i].Pagar_factura(Codigo) == true){
    return true;}else{
     return false;
     }
    }
    }
    return false;
    }
    
    public void Eliminar_facturas(){
    for(int i = 0; i < this.cantidad_proveedores; i++){
    this.Proveedores[i].Eliminar_facturas();
    }
    }
    
    
}
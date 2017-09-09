/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

import java.util.Scanner;

/**
 *
 * @author acer
 */
public class SuperMercado {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic he
        int opcion = 0;
        Tienda tienda = new Tienda();
        Scanner in = new Scanner(System.in);
    System.out.println("---------Supermercado---------");
while(opcion != 5){
    System.out.println("Menu");
    
    System.out.println("Marque el numero para la opcion deseada ");
    System.out.println("1. Articulos agotados");
    System.out.println("2. Inventario");
    System.out.println("3. Proveedores");
    System.out.println("4. Empleados");
    System.out.println("5. Salir");
    opcion = in.nextInt();
    switch (opcion){
        case 1: 
            System.out.println("-----Productos agotados en la tienda-----");
            System.out.println("Cantidad : " + tienda.getCantidad_agotados());
            System.out.println("Lista de agotados");
            String[] A = tienda.getAgotados();
            for(int i = 0; i < tienda.getCantidad_agotados(); i++){
            System.out.println("1. "+A[i]);
            }
            break;
        case 2: 
            int opcion2 = 0;
            System.out.println("-----Inventario-----");
            while(opcion2 != 6){     
            System.out.println("1. Ver inventario."); 
            System.out.println("2. Registrar compra.");
            System.out.println("3. Registrar venta.");
            System.out.println("4. Ver mejores movimientos");
            System.out.println("5. Ver ganancias");
            System.out.println("6. Regresar al menu principal");
            opcion2 = in.nextInt();
            switch(opcion2){
                case 1:
                    System.out.println("Producto     "+"Cantidad     "+"Ventas     "+"Compras    ");
                    for(int i = 0; i < tienda.getCantidad_productos(); i++){
                    System.out.println(tienda.getProductos()[i].getNombre()+"     "+tienda.getProductos()[i].getCantidad()+"     "+tienda.getProductos()[i].getVentas()+"     "+tienda.getProductos()[i].getCompras());
                    }
                    break;
                case 2: 
                    System.out.println("Para generar una compra se debe registrar el codigo de la factura de compra"
                            + "\n , el nombre del proveedor (ya registrado en el sistema) al cual se hace la compra, cantidad y lista de productos (ya registrados en sistema) comprados"
                            + "\n con su respectiva cantidad unitaria de compra.");
                    System.out.println("Ingrese el codigo de la factura:");
                    int codigo = in.nextInt();
                    System.out.println("Ingrese el estado de la factura"+"1. Cancelada \n 2. Sin cancelar");
                    int Estatus = in.nextInt();
                    int plazo = 0;
                    if(Estatus == 1){
                    System.out.println("Ingrese el plazo para pagar la factura en # de DIAS:");
                    plazo = in.nextInt();
                    }
                    System.out.println("Ingrese el nombre del proveedor");
                    String Nombre_prov = in.next();
                    System.out.println("Ingrese la cantidad de productos dististos comprados");
                    int Cantidad_productos = in.nextInt();
                    String [] Productos = new String[Cantidad_productos];
                    int [] Cantidad_unica = new int [Cantidad_productos];
                    for(int i = 0; i < Cantidad_productos; i++){
                    System.out.print("Nombre producto: ");
                    Productos[i]=in.next();
                    System.out.print("Cantidad");
                    Cantidad_unica[i]=in.nextInt();
                    System.out.println();
                    }
                   boolean e = tienda.Generar_Compra(codigo, Nombre_prov, Productos, Cantidad_unica, Cantidad_productos, plazo,Estatus);
                   if(e == true){
                   System.out.println("Compra registrada exitosamente");
                   }else{
                   System.out.println("Error en la compra. Por favor verifique que el proveedor y TODOS los productos esten registrados en el sistema");
                   }
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de productos diferentes vendidos");
                    int Cantidad_vendidos = in.nextInt();
                    String[] Nombre_productov = new String[Cantidad_vendidos];
                    int [] Cantidad_unica2 = new int [Cantidad_vendidos];
                    for(int i = 0; i < Cantidad_vendidos; i++){
                    System.out.println("Nombre del producto");
                    Nombre_productov[i]= in.next();
                    System.out.println("Cantidad vendida");
                    Cantidad_unica2 [i]= in.nextInt();
                    }
                    String[] Salida = tienda.Generar_venta(Nombre_productov, Cantidad_unica2, Cantidad_vendidos);
                    for(int i = 0; i < Cantidad_vendidos; i++){
                    System.out.println(Nombre_productov[i] + Salida[i]);    
                    }
                    break;
                case 4:
                    System.out.println("-----Mejores movimientos-----");
                    System.out.println("Top "+"Producto     "+"Ventas     "+"Ingresos     ");
                    for(int i = 0; i < tienda.getCantidad_productos(); i++){
                        int a = i+1;
                    System.out.println(a+" "+tienda.getProductos()[i].getNombre()+"     "+tienda.getProductos()[i].getVentas()+"     "+tienda.getProductos()[i].getIngresos());
                    }
                    break;
                case 5:
                    System.out.println("-----ganancias-----");
                    System.out.println("Producto     "+"Ingresos     "+"Egresos     "+"Ganancias    ");
                    for(int i = 0; i < tienda.getCantidad_productos(); i++){
                    System.out.println(tienda.getProductos()[i].getNombre()+"     "+tienda.getProductos()[i].getIngresos()+"     "+tienda.getProductos()[i].getEgreso()+"     "+tienda.getProductos()[i].getGanancia());
                    }
                    break;
                case 6:
                    break;
            }
    }
            break;
        case 3:
            int opcion3=0;
            
            System.out.println("-----Proveedores-----");
            while(opcion3 !=8){
            System.out.println("1. Deudas");
            System.out.println("2. Facturas vencidas");
            System.out.println("3. Facturas proximas a vencer");
            System.out.println("4. Facturas Canceladas");
            System.out.println("5. Pagar Facturas");
            System.out.println("6. Eliminar facturas pagadas");
            System.out.println("7. Agregar nuevo proveedor");
            System.out.println("8. Regresar al menu principal");
            opcion3=in.nextInt();
            switch(opcion3){
                case 1:
                    float deuda=0;
                    System.out.println("Proveedor   "+"Facturas sin cancelar    "+"Deuda");
                    for(int i = 0; i < tienda.getCantidad_proveedores(); i++){
                        if(tienda.getDeudas(i)> 0){
                            for(int j = 0; j < tienda.getProveedores()[i].getCont(); j++){
                            if(tienda.getProveedores()[i].getFacturas()[j].getEstado() == false){
                            deuda += tienda.getProveedores()[i].getFacturas()[j].getValor();
                            }
                            }
                    System.out.println(tienda.getProveedores()[i].getNombre()+"     "+tienda.getDeudas(i)+"    "+ deuda);
                        }
                    }
                    break;
                case 2:
                    for(int i = 0; i < tienda.getCantidad_proveedores();i++){
                    for(int j = 0; j < tienda.getProveedores()[i].getCont(); j++){
                    if(tienda.getProveedores()[i].getFacturas()[j].getPlazo()==0){
                    System.out.println(tienda.getProveedores()[i].getFacturas()[j].getNombre_proveedor()+"   "+tienda.getProveedores()[i].getFacturas()[j].getCodigo());
                    }
                    }
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el plazo minimo restante");
                    int plazo_min=in.nextInt();
                         for(int i = 0; i < tienda.getCantidad_proveedores();i++){
                    for(int j = 0; j < tienda.getProveedores()[i].getCont(); j++){
                    if(tienda.getProveedores()[i].getFacturas()[j].getPlazo()<=plazo_min){
                    System.out.println(tienda.getProveedores()[i].getFacturas()[j].getNombre_proveedor()+"   "+tienda.getProveedores()[i].getFacturas()[j].getCodigo());
                    }
                    }
                    }
                    break;
                case 4:
                    int cancelados=0;
                    System.out.println("Proveedor   "+"Facturas pagadas    ");
                    for(int i = 0; i < tienda.getCantidad_proveedores(); i++){
                            for(int j = 0; j < tienda.getProveedores()[i].getCont(); j++){
                            if(tienda.getProveedores()[i].getFacturas()[j].getEstado() == true){
                             cancelados++;  
                            }
                            }
                            if(cancelados > 0){
                    System.out.println(tienda.getProveedores()[i].getNombre()+"     "+cancelados+"     "); }
                        }
                    
                    break;
                case 5:
                    System.out.println("Ingrese el codigo de la factura");
                    int codigo = in.nextInt();
                    System.out.println("Ingrese el nombre del proveedor");
                    String Name = in.next();
                    if(tienda.pagar_Factura(codigo, Name)== true){
                    System.out.println("Registro de pago exitoso");
                    }else{System.out.println("Error de registro. \n Es posible que el proveedor no este registrado o no exista una factura con el codigo ingresado ");}   
                    break;
                case 6:
                    tienda.Eliminar_facturas();
                    System.out.println("Eliminación exitosa");
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del proveedor");
                    String newname= in.next();
                    System.out.println("Ingrese la cantidad de productos que vende");
                    int d = in.nextInt();
                    System.out.println("Ingrese la lista de los nombres de los productos");
                    String[] newproductos = new String[d];
                    for(int i = 0; i < d ; i++){
                        newproductos[i] = in.next();
                    }
                    tienda.Anadir_Proveedor(newname, newproductos);
                    System.out.println("Resgistro exitoso");
                    break; 
                case 8:
                    break;
                }
            }
        break;
        case 4:
            int opcion4 = 0;
            System.out.println("-----Empleados-----");
            while(opcion4 != 4){
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Mostrar informacion de los empleados");
            System.out.println("3. Registrar horas trabajadas en el dia");
            System.out.println("4. Regresar al menu principal");
            opcion4 = in.nextInt();
            switch(opcion4){
                case 1:
                    System.out.println("Ingrese el nombre del empleado");
                    String nombre_empleado = in.next();
                    System.out.println("Seleccione el horario de trabajo \n "
                            + "1. 9:00 am - 6:00 pm \n"
                            + "2. 10:00 am - 7:00 pm");
                    int horario = in.nextInt();
                    System.out.println("Ingrese el valor del Salario minimo vigente");
                    float Salario_minimo = in.nextFloat();
                    tienda.Anadir_Empleado(nombre_empleado, horario, Salario_minimo);
                    System.out.println("Se agregro correctamente el nuevo empleado");
                    break;
                case 2:
                    System.out.println("Nombre   "+"Horario   "+"Horas trabajadas   ");
                    for(int i = 0; i < tienda.getCantidad_empleados();i++){
                        String an ;
                        if(tienda.getEmpleados()[i].getHorario()==1){
                        an = "9:00 am - 6:00 pm";
                        }else{
                        an = " 10:00 am - 7:00 pm";
                        }
                    System.out.println(tienda.getEmpleados()[i].getNombre()+"   "+an+"   "+ tienda.getEmpleados()[i].getHoras_trabajadas());
                    }
                    break;
                case 3:
                    for(int i = 0; i < tienda.getCantidad_empleados();i++){
                    System.out.println("Empleado"+ i + tienda.getEmpleados()[i].getNombre());
                    System.out.println("Ingrese las horas que trabajo en el dia");
                    int horas_dia = in.nextInt();
                    tienda.getEmpleados()[i].Contabilizar_horas(horas_dia);
                    }
                    for(int j = 0; j < tienda.getCantidad_proveedores(); j++){
                        for(int u = 0; u < tienda.getProveedores()[j].getCont();u++){
                    if((tienda.getProveedores()[j].getFacturas()[u].getEstado() == false) && (tienda.getProveedores()[j].getFacturas()[u].getPlazo()>0)){
                    tienda.getProveedores()[j].getFacturas()[u].Descontar_plazo();
                    }
                        }
                    }
                    break;
                case 4:
                    break;
            }   
            }
            break;
        case 5:
            System.out.println("Saliendo...");
            break;
            }
            
}
            
            
            
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    


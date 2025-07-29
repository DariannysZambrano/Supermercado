package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> ListaProductos = new ArrayList<>();

        // Crear el menú
        String opcionMenu;
        do {
            System.out.println("BIENVENIDOS A SUPERMERCADO LA MAYORIA");
            System.out.print("\nElije una opcion: " +
                    "\n  1. Agregar producto" +
                    "\n  2. Eliminar producto" +
                    "\n  3. Mostrar producto" +
                    "\n  4. Modificar precio" +
                    "\n  5. Salir" +
                    "\nDigite la opcion: ");
            opcionMenu = scanner.nextLine();

            switch (opcionMenu) {
                case "1":
                    System.out.println("\nAGREGAR PRODUCTO");

                    System.out.print("Ingresa el ID del producto: ");
                    String ID = scanner.nextLine();
                    System.out.println("Ingresa el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la descripcion del producto: ");
                    String descripcion = scanner.nextLine();
                    System.out.println("Que categoria pertenece: ");
                    String categoria = scanner.nextLine();
                    System.out.println("Nombre del proveedor: ");
                    String nombreProveedor = scanner.nextLine();
                    System.out.println("Ingrese una fotogrsfia del producto ");
                    String fotografia1 = scanner.nextLine();
                    System.out.println("Ingresa la segunda fotografia: ");
                    String fotografia2 = scanner.nextLine();
                    System.out.print("Ingresa el precio unitario: ");
                    int PrecioUnitario = scanner.nextInt();
                    System.out.print("Ingresa la cantidad en bodega: ");
                    int CantidadBodega = scanner.nextInt();
                    scanner.nextLine(); //este para el salto de linea

                    Producto productoNuevo = new Producto(ID,nombre,descripcion,
                            categoria,nombreProveedor,fotografia1,fotografia2,PrecioUnitario,
                            CantidadBodega);

                    ListaProductos.add(productoNuevo); //Guarda el producto en memoria. Permite que después se pueda mostrar, modificar o eliminar ese producto.Si no agregas el producto a la lista, es como si nunca lo hubieras registrado: los datos se pierden después de ingresarlos.
                    break;

                case "2":
                    System.out.println(" cuidado !! Estas apunto de eliminar un producto del sistema !! ");
                    System.out.println("Para eliminar un producto por favor escriba bien el ID ");

                    String idEliminar = scanner.nextLine(); // Leer el ID que quiere eliminar
                    boolean encontrado = false; // Variable para saber si lo encontró

                    for (int i = 0; i < ListaProductos.size(); i++) {
                        if (ListaProductos.get(i).ID.equals(idEliminar)) { //esta linea me esta comparado con el get el producto actual con el id que deseo eliminar, equals me esta compara dos Strings y vuelve true si son exactamente iguales
                            ListaProductos.remove(i); //remove es una variable queelimina, la i me busca el producto
                            encontrado = true; //aqui el ciclo hace el proceso de uqe lo elimino o no, el tue me esta guardando si se elimino el producto
                            System.out.println("Producto eliminado exitosamente ");
                            break;
                    }
                    }
                    if (! encontrado){
                        System.out.println(" Producto no encontrado con ese ID ");
                    }
                    break;

                case "3":
                    System.out.println("En esta pagina puedes ver la informacion del producto ");
                    System.out.println("Para ver un producto por favor ingrese el ID ");

                    String idMostrar = scanner.nextLine();
                    boolean encontrado3 = false;

                    for (Producto p : ListaProductos) { // la p es una variable temporal que representa cada producto, uno por uno
                        if (p.ID.equals(idMostrar)){
                           encontrado3 = true;

                            System.out.println( "📦 Producto: " + p.nombre);
                            System.out.println("\n🔖 ID: " + p.ID);
                            System.out.println("\n📝 Descripción: " + p.descripcion);
                            System.out.println( "\n🏷️ Categoría: " + p.categoria);
                            System.out.println("\n🏢 Proveedor: " + p.nombreProveedor);
                            System.out.println("\n🖼️ Foto 1: " + p.fotografia1);
                            System.out.println("\n🖼️ Foto 2: " + p.fotografia2);
                            System.out.println("\n💲 Precio Unitario: $" + p.PrecioUnitario);
                            System.out.println("\n📦 Cantidad en Bodega: " + p.CantidadBodega);
                        }
                    }
                    if (! encontrado3){
                        System.out.println("Producto no encontrado con ese ID ");
                    }
                    break;

                case "4":
                    System.out.print("Ingresa el ID del producto a modificar: ");
                    String idModificar = scanner.nextLine();

                    boolean encontrado4 = false;

                    for (Producto p : ListaProductos) {
                        if (p.ID.equals(idModificar)) {
                            encontrado4 = true;

                            System.out.println("Precio actual del producto " + p.nombre + "$" + p.PrecioUnitario);
                            System.out.print("Ingresa el nuevo precio: ");
                            int nuevoPrecio = scanner.nextInt(); //tengo que guardar el precio nuevo.
                            scanner.nextLine();
                            p.PrecioUnitario = nuevoPrecio;
                            System.out.println("✅ Precio actualizado con éxito.");
                        }
                    }
                    if (! encontrado4){
                        System.out.println("roducto no encontrado con ese ID");
                    }
                    break;

                case "5":
                    System.out.println("Gracias por usar el sistema.");
                    return; // salir del programa
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (true);
    }
}

class Producto {
    String ID, nombre, descripcion, categoria, nombreProveedor, fotografia1, fotografia2;
    int PrecioUnitario, CantidadBodega;
    boolean caducidad;

    public Producto(String ID, String nombre, String descripcion, String categoria,
                    String nombreProveedor, String fotografia1, String fotografia2, int PrecioUnitario, int CantidadBodega) {

        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nombreProveedor = nombreProveedor;
        this.fotografia1 = fotografia1;
        this.fotografia2 = fotografia2;
        this.PrecioUnitario = PrecioUnitario;
        this.CantidadBodega = CantidadBodega;
    }
}
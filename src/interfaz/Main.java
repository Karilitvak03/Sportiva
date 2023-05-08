package interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import logica.Caja;
import logica.Deposito;
import logica.Encargado;
import logica.Gerente;
import logica.Producto;
import logica.Usuario;
import logica.Vendedor;
import logica.Venta;

public class Main {

	public static void main(String[] args) {
				//id, abirta, recaudo
		//Sucursal sucursal = new sucursal();
		
		Caja caja1 = new Caja(1, true, 0.0);
		Caja caja2 = new Caja(2, true, 0.0);
		Caja caja3 = new Caja(3, true, 0.0);
		Caja caja4 = new Caja(4, true, 0.0);
		Caja caja5 = new Caja(5, true, 0.0);
								//nombre, apellido, dni, email, contraseña, login, id_gerente
		Gerente g1 = new Gerente ("Francisco", "Ferro", "13456789", "Fran@dv.com", "Fran123", false, "gerente", 1);
		Gerente g2 = new Gerente ("Ramiro", "Paez", "79456123", "Rami@dv.com", "Rami123", false, "gerente", 2);
		Gerente g3 = new Gerente ("Ciro", "Perez", "46789123", "Rami@dv.com", "Ciro@dv.com", false, "gerente", 3);
		
								//nombre, apellido, dni, email, contraseña, login, id_vendedor, caja
		Vendedor v1 = new Vendedor ("Harry", "Martinez", "13789456", "Harry@dv.com", "Harry123", false, "vendedor", 4);
		Vendedor v2 = new Vendedor ("Jose", "Fernandez", "78456123", "Jose@dv.com", "Jose123", false, "vendedor", 5);
		Vendedor v3 = new Vendedor ("Ramiro", "Paez", "13789456", "Rami@dv.com", "Rami123", false, "vendedor", 6);

										//nombre, apellido, dni, email, contraseña, login, id_encargado
		Encargado e1 = new Encargado("Karina", "Litvak", "12456789", "kari@dv.com", "kari123", false, "encargado", 7);
		Encargado e2 = new Encargado("Bruno", "Cuevas", "46987654", "Bruno@dv.com", "Bru123", false, "encargado", 8);
		Encargado e3 = new Encargado("Luciano", "Arias", "12654987", "Lucho@dv.com", "Lucho123", false, "encargado", 9);

		LinkedList <Usuario> usuarios = new LinkedList();
		usuarios.add(g1);usuarios.add(g2);usuarios.add(g3);usuarios.add(v1);usuarios.add(v2);
		usuarios.add(v3);usuarios.add(e1);usuarios.add(e2);usuarios.add(e3);
		
		Producto p1 = new Producto(1,"calzado","Zapatillas",50000.0, 150);
		Producto p2 = new Producto(2,"calzado","Medias",2000.0, 100);
		Producto p3 = new Producto(3,"remera","remera blanca",50000.0, 350);
		Producto p4 = new Producto(4,"camiseta","camiseta manga corta",6000.0, 200);
		Producto p5 = new Producto(5,"pantalon","short futbol",6000.0, 80);
		Producto p6 = new Producto(6,"gorro","bisera",3500.0, 190);
		LinkedList <Producto> productos = new LinkedList(); 
		
		productos.add(p1);productos.add(p2);productos.add(p3);
		productos.add(p4);productos.add(p5);productos.add(p6);
		
		LinkedList <Venta> ventas = new LinkedList(); 
		
		menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
	}
	
	public static void menuPrincipal(LinkedList<Usuario> usuarios, 
			LinkedList<Producto> productos, LinkedList<Venta> ventas,
			Gerente g1, Vendedor v1, Encargado e1, Caja caja1 ) {
		
		String dni;
		String contraseña;
		
		dni =  JOptionPane.showInputDialog("Ingrese su DNI");
		contraseña = JOptionPane.showInputDialog("Ingrese su contraseña");
		
		for (Usuario usuario: usuarios) {
			if (usuario.login(dni, contraseña)) {
				JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente!"
						+ "\n Bienvenido "+usuario.getNombre()+" "+usuario.getApellido() );
			
				if (usuario.getRol().equalsIgnoreCase("gerente")) {
					String opcion =JOptionPane.showInputDialog("MENU GERENTE:\n\nIngrese opcion a operar.\n"
							+ "1 - Visualizar Usuarios\n"
							+ "2 - Cargar nuevo Usuario\n"
							+ "3 - Editar Usuario\n"
							+ "4 - Eliminar Usuario\n"
							+ "5 - "
							+ "6 - Salir\n");
					switch (opcion) {
					case "1":
						g1.VerUsuarios(usuarios); 
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "2":
						g1.crearUsuario(usuarios); 
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "3":
						g1.editarUsuario(usuarios); 
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "4":
						g1.eliminarUsuario(usuarios);
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "5":
						g1.logOut(); 
						//menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;

					default:
						break;
					}
				}
				
				if (usuario.getRol().equalsIgnoreCase("vendedor")) {
					String opcion = JOptionPane.showInputDialog("MENU VENDEDOR:\n\nIngrese opcion a operar.\n"
							+ "1 - Realizar una Venta\n"
							+ "2 - Revisar stock de un producto\n"
							+ "3 - Realizar pedido\n"
							+ "4 - Ver ventas realizadas\n"
							+ "5 - Salir");
					
					switch (opcion) {
					case "1":
						v1.realizarVenta(productos, ventas, caja1);
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "2":
						v1.revisarStock(productos);
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "3":
						v1.hacerPedido();
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "4":
						v1.verVentas(ventas);
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "5":
						v1.logOut();
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					default:
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					}
				}
				
				if (usuario.getRol().equalsIgnoreCase("encargado")) {
					String opcion = JOptionPane.showInputDialog("MENU ENCARGADO:\nIngrese opcion a operar."
							+ "1 - Ver Stock de productos\n"
							+ "2 - Agregar nuevo producto\n"
							+ "3 - Salir\n");
					
					switch (opcion) {
					case "1":
						e1.verStockProductos(productos);
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "2":
						e1.agregarProducto(productos);
						menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					case "3":
						e1.logOut();
						//menuPrincipal(usuarios, productos, ventas, g1, v1, e1, caja1);
						break;
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Datos incorrectos, vuelve a ingresar tus datos.");
					//menuPrincipal(usuarios);
				}
			}
		}
	}
	
	
	
}

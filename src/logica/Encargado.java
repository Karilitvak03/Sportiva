package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Encargado extends Usuario {
	int id_encargado;

	public Encargado(String nombre, String apellido, String dni, String email, String contraseña, boolean login,
			String rol, int id_encargado) {
		super(nombre, apellido, dni, email, contraseña, login, rol);
		this.id_encargado = id_encargado;
	}

	public int getId_encargado() {
		return id_encargado;
	}

	public void setId_encargado(int id_encargado) {
		this.id_encargado = id_encargado;
	}

	@Override
	public String toString() {
		return "Encargado [id_encargado=" + id_encargado + "]";
	} 
	
	public void verStockProductos(LinkedList<Producto> productos) {
		String mensaje;
		String acumulativo = "";
		for (Producto producto : productos) {
			mensaje = "Identificador: "+producto.getId_producto()+"\n"
					+ "Producto: "+producto.getNombre()+"\n"
					+ "Stock disponible: "+producto.getCantidad()+"\n"
					+ "-----------------------------------------------\n";
					
			acumulativo = acumulativo + mensaje;
		}
		JOptionPane.showMessageDialog(null, acumulativo);
	}
	

	public void agregarProducto(LinkedList<Producto> productos) {
		
		int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del producto"));
		String tipo_producto = JOptionPane.showInputDialog("Ingrese el tipo del producto");
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto");
		double precio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto"));
		int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto"));
		
		Producto producto = new Producto(id_producto,tipo_producto,nombre,precio,cantidad);
		productos.add(producto);
		JOptionPane.showMessageDialog(null, "Usted esta creando un producto con la siguiente informacion:\nnombre: " + nombre + "\nTipo: " + tipo_producto + "\nPrecio: " + precio  + 
				"\nID: " + id_producto + "\nCantidad: " + cantidad);
		
		
	}
	
}

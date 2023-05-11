package logica;

import javax.swing.JOptionPane;

public class Encargado extends Usuario {
	private String id_encargado; 
	
	
	
	public Encargado(String n, String dni, String e,  String c, String id) {
		super(n,dni,e,c);
		id_encargado=id;
	}



	public void agregarProducto() {
		
		String id_producto=JOptionPane.showInputDialog("Ingrese el id del producto");
		String tipo_producto=JOptionPane.showInputDialog("Ingrese el tipo del producto");
		String nombre=JOptionPane.showInputDialog("Ingrese el nombre del producto");
		double precio=Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio del producto"));
		int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto"));
		Producto p = new Producto(id_producto,tipo_producto,nombre,precio,cantidad);
		
		JOptionPane.showMessageDialog(null, "Usted esta creando un producto con la siguiente informacion:\nnombre: " + nombre + "\nTipo: " + tipo_producto + "\nPrecio: " + precio  + 
				"\nID: " + id_producto + "\nCantidad: " + cantidad);
		
		
	}
	
	public void editarProducto() {
		int opcion;
		String modificacion;
		
		opcion= Integer.parseInt(JOptionPane.showInputDialog("Que desea modificar? \n1-Id del Producto \n2-Tipo del Producto \n3-Nombre del Producto \n4-Precio del prodcuto \n5-Cantidad del producto"));
		switch (opcion) {
		case 1:
			modificacion = JOptionPane.showInputDialog("Ingrese nuevo ID del producto");
			break;

		case 2:
			modificacion = JOptionPane.showInputDialog("Ingrese nuevo Tipo del producto");
			break;
			
		case 3:
			modificacion = JOptionPane.showInputDialog("Ingrese nuevo Nombre del Porducto");
			break;
		
		case 4:
			modificacion = JOptionPane.showInputDialog("Ingrese nuevo Precio del Producto");
			break;
		case 5:
			modificacion = JOptionPane.showInputDialog("Ingrese nueva Cantidad del Producto");
		}
		
	}
	
	
	


	public String getId_encargado() {
		return id_encargado;
	}



	public void setId_encargado(String id_encargado) {
		this.id_encargado = id_encargado;
	}



	@Override
	public String toString() {
		return super.toString() + "\nid_encargado: " + id_encargado;
	}
	
	
	
	
	
	
	
}

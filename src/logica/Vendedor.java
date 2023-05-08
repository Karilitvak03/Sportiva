package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Vendedor extends Usuario {
	
	private int id_vendedor;
	private Caja caja;
	
	public Vendedor(String nombre, String apellido, String dni, String email, String contraseña, boolean login,
			String rol, int id_vendedor) {
		super(nombre, apellido, dni, email, contraseña, login, rol);
		this.id_vendedor = id_vendedor;
	}

	public int getId_vendedor() {
		return id_vendedor;
	}
	
	public void setId_vendedor(int id_vendedor) {
		this.id_vendedor = id_vendedor;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	
	public String abrirCaja(Caja caja) {
		String mensaje; 
		if (!caja.isAbierta()) {
			caja.setAbierta(true);
			mensaje = "Caja abierta.";
		} else {
			mensaje = "Ya estaba abierta."; 
		}
		return mensaje;
	}
	
	public void realizarVenta(LinkedList<Producto>productos, LinkedList<Venta>ventas, Caja caja1) {
		
		//if (caja1.isAbierta()) {
			int elegir_prod;
			int cantidad;
			String mensaje, acumulativo = "";
			
			Venta venta = null;
			int id_venta = 0;
			double total;
			
			String [] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
			String dia = (String) JOptionPane.showInputDialog(
					null, "Seleccione el dia de hoy","SPORTIVA"
					,JOptionPane.QUESTION_MESSAGE ,null ,dias, dias[0]);

			for (Producto prod : productos) {
				mensaje = "Id: "+prod.getId_producto()
						+ " - "+prod.getNombre()
						+ " ("+prod.getTipo()+")\n";
						//+ "-----------------------------------------------\n";
				acumulativo = acumulativo + mensaje;
			}
			
			elegir_prod = Integer.parseInt(JOptionPane.showInputDialog("VENTAS SPORTIVA\n\n"
					+ "ESCRIBA LA ID DEL PRODUCTO A VENDER:\n"
					+ acumulativo));
			
			for (Producto producto : productos) {

				if (producto.getId_producto() == elegir_prod) {

					cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de unidades"));
					total = producto.getPrecio()*cantidad;
					venta.setTotal(total);
					//forma de pago
					String [] opciones = {"EFECTIVO", "TARJETA"};
					int opcion = JOptionPane.showOptionDialog(null, "Elija su forma de pago", "SPORTIVA"
							,0, JOptionPane.QUESTION_MESSAGE,null, opciones, opciones [0]);
					
					if (opcion == 0) {
						//venta.descuentoEfectivo();
						
						venta = new Venta(id_venta++, dia, producto, cantidad, "Efectivo", total);
						ventas.add(venta);
					}else {
						venta = new Venta(id_venta++, dia, producto, cantidad, "Tarjeta", total);
						ventas.add(venta);
					}
					
					JOptionPane.showMessageDialog(null, "Venta realizada\n"
							+ "Producto :"+producto.getNombre()+" ("+venta.getProducto().getTipo()+")"+"\n"
							+ "Precio Unitario: $"+venta.getProducto().getPrecio()+" x"+cantidad+"\n"
							+ "TOTAL: $"+venta.getTotal());
					realizarVenta(productos, ventas, caja1);
				}
			}
//		} else {
//			JOptionPane.showMessageDialog(null, "Primero abre la caja para operar");
//		}
	}
	
	public void revisarStock(LinkedList<Producto>productos) {
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
	
	public void hacerPedido() {
		String producto = JOptionPane.showInputDialog("Ingrese procuto a pedir:");
		String cantidad = JOptionPane.showInputDialog("Ingrese cantidad del producto a pedir");
		
		JOptionPane.showMessageDialog(null, this.getNombre()+" "+this.getApellido()+"\n"
				+ "Ha solicitado un pedido de \n"+producto+ " x"+cantidad+" unidades");
	}
	
	public void verVentas(LinkedList<Venta>ventas) {
		String mensaje;
		String acumulativo = "";
		
		for (Venta venta : ventas) {
					mensaje = "Venta Numero: " + venta.getId_venta() + "\n "
							+ "Productos: " + venta.getProducto().getNombre() + "\n"
							+ "[Precio: $"+ venta.getProducto().getPrecio()
							+" cantidad x"+venta.getCantidad()+"\n "
							+ "Total: $" + venta.getTotal() + "\n"
							+ "-----------------------------------------------\n";
		}
		JOptionPane.showMessageDialog(null, acumulativo);
	}	

}

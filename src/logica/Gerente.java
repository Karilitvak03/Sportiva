package logica;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Gerente extends Usuario{

	int id_gerente;

	public Gerente(String nombre, String apellido, String dni, String email, String contraseña, boolean login,
			String rol, int id_gerente) {
		super(nombre, apellido, dni, email, contraseña, login, rol);
		this.id_gerente = id_gerente;
	}

	public int getId_gerente() {
		return id_gerente;
	}

	public void setId_gerente(int id_gerente) {
		this.id_gerente = id_gerente;
	}

	@Override
	public String toString() {
		return "Gerente [id_gerente=" + id_gerente + "]";
	}
	
	public void VerUsuarios(LinkedList<Usuario> usuarios) {
		String mensaje, acumulativo = "";
		if (usuarios.isEmpty()) {
			System.out.println("No hay usuarios en tu empresa xD!");
		} else {
			for (Usuario usuario : usuarios) {
				mensaje = "Nombre y Apellido: "+usuario.getNombre()+" "+usuario.getApellido()+"\n"
						+ "DNI: "+usuario.getDni()+ " - email: "+usuario.getEmail()
						+ " Cargo: "+usuario.getRol()+"\n"
						+ "-----------------------------------------------\n";
				
				acumulativo = acumulativo + mensaje;
			}
			JOptionPane.showMessageDialog(null, "Lista de usuarios en SPORTIVA\n"+acumulativo);
		}
		
	}
	
	public void crearUsuario(LinkedList<Usuario> usuarios) {
		String selec;
		do {
			selec = JOptionPane.showInputDialog("Que tipo de usuario quiere crear? \n"
													+ "1 - vendedor\n"
													+ "2 - gerente\n"
													+ "3 - salir");
		} while (!selec.equalsIgnoreCase("1") && !selec.equalsIgnoreCase("2") && !selec.equalsIgnoreCase("3"));
		
		int seleccion = Integer.parseInt(selec);
		
		switch (seleccion) {
		case 1:
			
			String nombre = JOptionPane.showInputDialog("Ingrese nombre:");
			String apellido = JOptionPane.showInputDialog("Ingrese apellido:");
			String dni =JOptionPane.showInputDialog("Ingrese DNI:");
			String email =JOptionPane.showInputDialog("Ingrese Email");
			String contraseña = JOptionPane.showInputDialog("Ingrese contraseña");
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del vendedor"));
			Vendedor vendedor =  new Vendedor(nombre, apellido, dni, email, contraseña, false, "Vendedor", id);
			usuarios.add(vendedor);
			
			JOptionPane.showMessageDialog(null, "Usted esta creando un vendedor con la siguiente informacion:\n"
					+ "nombre: " + nombre + "\n"
					+ "DNI: " + dni + "\n"
					+ "Email: " + email +"\n"
					+ "Contraseña: " + contraseña + "\n"
					+ "id: " + id );
			
			break;
		case 2:
			nombre = JOptionPane.showInputDialog("Ingrese nombre:");
			apellido = JOptionPane.showInputDialog("Ingrese apellido:");
			dni =JOptionPane.showInputDialog("Ingrese DNI:");
			email =JOptionPane.showInputDialog("Ingrese Email");
			contraseña = JOptionPane.showInputDialog("Ingrese contraseña");
			id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del gerente"));
			
			Gerente gerente =  new Gerente (nombre, apellido, dni, email, contraseña, false, "Gerente", id);
			usuarios.add(gerente);
			
			JOptionPane.showMessageDialog(null, "Usted esta creando un gerente con la siguiente informacion:\n"
					+ "nombre: " + nombre + "\n"
					+ "DNI: " + dni + "\n"
					+ "Email: " + email +"\n"
					+ "Contraseña: " + contraseña + "\n"
					+ "id: " + id );
			
			break;
		case 3: 
			JOptionPane.showMessageDialog(null, "Saliendo de crear usuario...");
		}
	}
	
	public void editarUsuario(LinkedList<Usuario> usuarios) {
		int opcion;
		String elegir_usuario, mensaje, acumulativo = "", modificacion;
		
		for (Usuario usuario : usuarios) {
			mensaje = "Nombre y Apellido: "+usuario.getNombre()+" "+usuario.getApellido()+"\n"
					+ "DNI: "+usuario.getDni()+ " - email: "+usuario.getEmail()
					+ " Cargo: "+usuario.getRol()+"\n"
					+ "-----------------------------------------------\n";
			
				acumulativo = acumulativo + mensaje;
		}

		elegir_usuario = JOptionPane.showInputDialog("SPORTIVA\n\n"
				+ "ESCRIBA el DNI DEL USUARIO A EDITAR:\n");
		
		for (Usuario usuario : usuarios) {
			if (usuario.getDni().equals(elegir_usuario)) {
				opcion= Integer.parseInt(JOptionPane.showInputDialog("Que desea modificar? \n"
						+ "1 - email\n"
						+ "2 - Contraseña"));
				switch (opcion) {
				case 1:
					modificacion = JOptionPane.showInputDialog("Ingrese nuevo email de usuario");
					usuario.setEmail(modificacion);
					break;

				case 2:
					modificacion = JOptionPane.showInputDialog("Ingrese nueva contraseña");
					usuario.setContraseña(modificacion);;
				
				}		
			}
	
		}
	
	}
	
	public void eliminarUsuario(LinkedList<Usuario> usuarios) {
		int opcion;
		String elegir_usuario, mensaje, acumulativo = "";
		
		for (Usuario usuario : usuarios) {
			mensaje = "Nombre y Apellido: "+usuario.getNombre()+" "+usuario.getApellido()+"\n"
					+ "DNI: "+usuario.getDni()+ " - email: "+usuario.getEmail()
					+ " Cargo: "+usuario.getRol()+"\n"
					+ "-----------------------------------------------\n";
			
			acumulativo = acumulativo + mensaje;
	}

		elegir_usuario = JOptionPane.showInputDialog("SPORTIVA\n\n"
				+ "ESCRIBA el DNI DEL USUARIO A ELIMINAR:\n");
		
		for (Usuario usuario : usuarios) {
			if (usuario.getDni().equals(elegir_usuario)) {
				usuarios.remove(usuarios.indexOf(usuario));
			}
		}
		
	}
}

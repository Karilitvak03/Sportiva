package logica;

public abstract class Usuario  {
	
		private String nombre;
		private String apellido;
		private String dni;
		private String email;
		private String contraseña;
		private boolean login;
		private String rol;
	
	public Usuario(String nombre, String apellido, String dni, String email, String contraseña, boolean login,
				String rol) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.email = email;
			this.contraseña = contraseña;
			this.login = login;
			this.rol = rol;
		}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return contraseña;
	}

	public void setClave(String clave) {
		this.contraseña = clave;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	
	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}


	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email
				+ ", contraseña=" + contraseña + ", login=" + login + ", rol=" + rol + "]";
	}

	public boolean login(String dni, String contraseña) {
		if (dni.equals(this.dni)) {
			if (contraseña.equals(this.contraseña)) {
				System.out.println("Usuario "+this.nombre+" "+this.apellido+" Ingreso correctamente.");
				this.setLogin(true);
				return true;
			} else {
				System.out.println("Contraseña incorrecta.");
				return false;
			}
		}else {
			System.out.println("DNI incorrecto.");
			return false;
		}
	}
	
	public void logOut() {
		setLogin(false);
	}
	
}

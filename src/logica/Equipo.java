package logica;

public class Equipo {

	    private String id_equipo;
	    private String nombre;
	    private String clasificacion;

	    public Equipo(String id_equipo, String nombre, String clasificacion) {
	        this.id_equipo = id_equipo;
	        this.nombre = nombre;
	        this.clasificacion = clasificacion;
	    }

	    public String getId_equipo() {
	        return id_equipo;
	    }

	    public void setId_equipo(String id_equipo) {
	        this.id_equipo = id_equipo;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getClasificacion() {
	        return clasificacion;
	    }

	    public void setClasificacion(String clasificacion) {
	        this.clasificacion = clasificacion;
	    }

	    @Override
		public String toString() {
			return "\nInformacion del Equipo: \nid_equipo: " + id_equipo + "\nnombre: " + nombre + "\nclasificacion: " + clasificacion;
		}

		public void removeSponsor(Sponsor sponsor) {
			// TODO Auto-generated method stub
			
		}

		public void addSponsor(Sponsor sponsor) {
			// TODO Auto-generated method stub
			
		}


}

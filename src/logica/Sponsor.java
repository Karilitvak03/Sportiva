package logica;

public class Sponsor {

	    private String id_sponsor;
	    private Equipo equipo;
	    private boolean aptosponsor;

	    public Sponsor(String id_sponsor, Equipo equipo, boolean aptosponsor) {
	        this.id_sponsor = id_sponsor;
	        this.equipo = equipo;
	        this.aptosponsor = aptosponsor;
	    }

	    public String getId_sponsor() {
	        return id_sponsor;
	    }

	    public void setId_sponsor(String id_sponsor) {
	        this.id_sponsor = id_sponsor;
	    }

	    public Equipo getEquipo() {
	        return equipo;
	    }

	    public void setEquipo(Equipo equipo) {
	        this.equipo = equipo;
	    }

	    public boolean isAptosponsor() {
	        return aptosponsor;
	    }

	    public void setAptosponsor(boolean aptosponsor) {
	        this.aptosponsor = aptosponsor;
	    }
	    
	    @Override
		public String toString() {
			return "\n\nid_sponsor: " + id_sponsor + "\nequipo: " + equipo + "\napto sponsor: " + aptosponsor;
		}

}

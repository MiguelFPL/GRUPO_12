package ejercicio1;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona implements Comparable<Empleado>{
	
	private final int legajo;
	private String puesto;
	private static int cont = 999;
	
	//
	
	public static int devuelveProximoLegajo()
	{
		return cont+1;
	}
	
	//
	
	public Empleado ()
	{
		super();
		cont++;
		this.legajo = cont;
	}
	
	public Empleado (String dni, String nombre, String apellido, LocalDate fechaNacimiento, String genero, String direccion, String telefono, String email, String puesto)
	{
		super(dni, nombre, apellido, fechaNacimiento, genero, direccion, telefono, email);
		cont++;
		this.legajo = cont;
		this.puesto = puesto;
	}
	
	//
	
	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getLegajo() {
		return legajo;
	}
	
	//

	@Override
	public String toString() {
		return "Empleado: [Legajo = " + legajo + ", Puesto = " + puesto +"]    " + super.toString();
	}

	@Override
	public int compareTo(Empleado emp) {
		if (this.legajo > emp.getLegajo()) {
			return 1;
		}
		if (this.legajo < emp.getLegajo()) {
			return -1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(legajo, puesto);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return legajo == other.legajo && Objects.equals(puesto, other.puesto);
	}	
}


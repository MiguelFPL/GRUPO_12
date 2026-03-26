package ejercicio1;
import java.time.LocalDate;

public class Empleado extends Persona {
	
	private int legajo;
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

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	//

	@Override
	public String toString() {
		return "Empleado: [Legajo = " + legajo + ", Puesto = " + puesto +"]    " + super.toString();
	}	
}

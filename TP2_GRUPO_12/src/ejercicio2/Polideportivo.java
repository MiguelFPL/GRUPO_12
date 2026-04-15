package ejercicio2;

public class Polideportivo implements InstalacionDeportiva, Edificio {
	
	//
	
	private String nombre;
	private double superficie;
	private int tipo;
	
	//
	
	public Polideportivo (String nombre, double superficie, int tipo)
	{
		this.nombre = nombre;
		this.superficie = superficie;
		this.tipo = tipo;
	}
	
	//
	
	@Override
	public double getSuperficieEdificio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTipoDeInstalacion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	//

	@Override
	public String toString() {
		return "Polideportivo [nombre=" + nombre + ", superficie=" + superficie + ", tipo=" + tipo + "]";
	}
	
	//
	
}

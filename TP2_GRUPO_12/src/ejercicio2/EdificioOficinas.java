package ejercicio2;

public class EdificioOficinas implements Edificio{
	
	//
	
	private int cantOficinas;
	private int superficie;
	
	//
	
	public EdificioOficinas(int cantOficinas, int superficie)
	{
        this.cantOficinas = cantOficinas;
        this.superficie = superficie;
    }
	
	//
	
	@Override
	public double getSuperficieEdificio() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//
	
	public int getCantOficinas() {
		return cantOficinas;
	}

	public void setCantOficinas(int cantOficinas) {
		this.cantOficinas = cantOficinas;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	//	

	@Override
	public String toString() {
		return "EdificioOficinas [cantOficinas=" + cantOficinas + ", superficie=" + superficie + "]";
	}

	//
}

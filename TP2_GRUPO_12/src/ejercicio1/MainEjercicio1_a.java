package ejercicio1;

public class MainEjercicio1_a {
	public static void main(String[] args) {
		try {
			Persona p1 = new Persona();
			p1.setDni("AA202020");
			
			Persona.exVerificarDNI(p1.getDni());
			System.out.println("Persona agregada correctamente");
			
		} catch (ExVerificarDNI e) {
			System.out.println("Persona no agregada por no verificar el DNI");
			e.printStackTrace();
		}
		try {
			Persona p2 = new Persona();
			p2.setDni("20202020");
			
			Persona.exVerificarDNI(p2.getDni());
			System.out.println("Persona agregada correctamente");
			
		} catch (ExVerificarDNI e) {
			System.out.println("Persona no agregada por no verificar el DNI");
			e.printStackTrace();
		}
	}
}

package ejercicio1;
import java.time.LocalDate;

public class Principal {
	public static void main(String[] args) {
		
		Empleado[] vEmp = new Empleado [3];
		vEmp[0] = new Empleado("47102910", "Kiara", "Laureano", LocalDate.of(2006, 1, 10), "Femenino", "Calle 1254", "+54 11 40725861", "laureanokiara@gmail.com", "Programador");
		vEmp[1] = new Empleado("26532312", "Carlos", "Rodriguez", LocalDate.of(2000, 4, 27), "Masculino", "Calle 6573", "+54 11 8563848", "rodriguezcarlos@gmail.com", "Diseñador");
		vEmp[2] = new Empleado("58248274", "Maria", "Benitez", LocalDate.of(2002, 2, 15), "Femenino", "calle 9263", "+54 11 85294235", "mariabenitez@gmail.com", "Analista");
		
		for (Empleado empleado : vEmp) {
			System.out.println(empleado.toString());
		}
		
		Empleado emp4 = new Empleado();
		emp4.setDni("39562384");
		emp4.setNombre("Matias");
		emp4.setApellido("Nuñez");
		emp4.setFechaNacimiento(LocalDate.of(1999, 8, 21));
		emp4.setGenero("Masculino");
		emp4.setDireccion("Calle 8957");
		emp4.setTelefono("+54 11 8993 2732");
		emp4.setEmail("matiasnuñez@gmail.com");
		emp4.setPuesto("Programador");
		System.out.println(emp4.toString());
		
		Empleado emp5 = new Empleado();
		emp5.setDni("27492835");
		emp5.setNombre("Lucia");
		emp5.setApellido("Gomez");
		emp5.setFechaNacimiento(LocalDate.of(1999, 11, 3));
		emp5.setGenero("Femenino");
		emp5.setDireccion("Calle 2177");
		emp5.setTelefono("+54 11 9432 5923");
		emp5.setEmail("luciagomez@gmail.com");
		emp5.setPuesto("Programador");
		System.out.println(emp5.toString());
		
		System.out.println("El próximo legajo será el "+Empleado.devuelveProximoLegajo());
	}
}
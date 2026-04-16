package ejercicio1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;

public class MainEjercicio1_d {

	public static void main(String[] args) {
		
		
		Persona p1 = new Persona("47102910", "Kiara", "Laureano", LocalDate.of(2006, 1, 10), "Femenino", "Calle 1254", "+54 11 40725861", "laureanokiara@gmail.com");
		Persona p2 = new Persona("26532312", "Carlos", "Rodriguez", LocalDate.of(2000, 4, 27), "Masculino", "Calle 6573", "+54 11 8563848", "rodriguezcarlos@gmail.com");
		Persona p3 = new Persona("58248274", "Maria", "Benitez", LocalDate.of(2002, 2, 15), "Femenino", "Calle 9263", "+54 11 85294235", "mariabenitez@gmail.com");
		Persona p4 = new Persona("28441920", "Lucía", "Fernández", LocalDate.of(1995, 11, 12), "Femenino", "Calle 1234", "+54 11 45678910", "fernandezlucia@gmail.com");
		Persona p5 = new Persona("35998211", "Andrés", "García", LocalDate.of(1992, 06, 05), "Masculino", "Calle 882", "+54 11 33221144", "garciaandres@hotmail.com");		
		
		HashSet<Persona> listaPersonas = new HashSet<Persona>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		listaPersonas.add(p4);
		listaPersonas.add(p5);
		
		Iterator<Persona> iteratorPer = listaPersonas.iterator();
		while (iteratorPer.hasNext())
		{
			Persona p = (Persona) iteratorPer.next();
			System.out.println(p.toString());
		}
	}

}

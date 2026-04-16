package ejercicio2;

import java.util.ArrayList;
import java.util.Iterator;

public class MainEjercicio2 {

	public static void main(String[] args) {

		ArrayList <Edificio> listaInstalaciones = new ArrayList <Edificio>(5);
		
		listaInstalaciones.add(new Polideportivo ("Polideportivo Atlas Norte", 2500.5, 2));
		listaInstalaciones.add(new Polideportivo ("Centro Deportivo Horizonte",3200.6,3));
		listaInstalaciones.add(new Polideportivo ("Complejo Deportivo El Mirador",1800.8,4));
		listaInstalaciones.add(new EdificioDeOficinas (18,1200.4));
		listaInstalaciones.add(new EdificioDeOficinas (25,2100.6));
		
		Iterator<Edificio> iteratorInstalaciones = listaInstalaciones.iterator();	
		
		while (iteratorInstalaciones.hasNext()) {
			Edificio edificio = (Edificio) iteratorInstalaciones.next();
			System.out.println(edificio.toString());
		}
				
	}

}

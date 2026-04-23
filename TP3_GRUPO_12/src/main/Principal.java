package main;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {
	public static void main(String[] args) {
		DaoCategoria daoCat = new DaoCategoria();
		DaoProducto daoPro = new DaoProducto();
		
//ALTA CATEGORIAS
	
//		Categoria cat1 = new Categoria();
//		cat1.setNombre("Electrónica");
//		
//		int filas = daoCat.agregarCategoria(cat1);
//		if (filas == 1) {
//			System.out.println("categoria agregada");
//		}
//		else {
//			System.out.println("Categoria no agregada");
//		}
//	}
	
//ALTA PRODUCTOS
		
//		Producto pro1 = new Producto();
//		pro1.setCodigo("A1");
//		pro1.setNombre("Celular");
//		pro1.setPrecio(999999.99);
//		pro1.setStock(100);
		//me falta setear la categoria me dejo de funcionar la cabeza 
		
//		int filas = daoPro.agregarProducto(pro1);
//		if (filas == 1) {
//			System.out.println("categoria agregada");
//		}
//		else {
//			System.out.println("Categoria no agregada");
//		}
		
//ALTA PRODUCTOS CON PROCEDIMIENTO ALMACENADO
		
		Producto pro2 = new Producto();
		pro2.setCodigo("A1");
		pro2.setNombre("Celular");
		pro2.setPrecio(999999.99);
		pro2.setStock(100);
		//me falta setear la categoria me dejo de funcionar la cabeza x2
		
		daoPro.procedimientoAlmacenadoAltaProducto(pro2);
	}
	
}

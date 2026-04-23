package main;

import java.util.ArrayList;

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
//		pro1.setCodigo("A3");
//		pro1.setNombre("Tablet");
//		pro1.setPrecio(799999.99);
//		pro1.setStock(50);	
//		Categoria cat = new Categoria();
//		cat.setId(1);
//		pro1.setCategoria(cat);
//		
//		int filas = daoPro.agregarProducto(pro1);
//		if (filas == 1) {
//			System.out.println("Producto agregado");
//		}
//		else {
//			System.out.println("Producto no agregado");
//		}
		
//ALTA PRODUCTOS CON PROCEDIMIENTO ALMACENADO
		
//		Producto pro2 = new Producto();
//		pro2.setCodigo("A2");
//		pro2.setNombre("Tv");
//		pro2.setPrecio(1999999.99);
//		pro2.setStock(150);
//		
//		Categoria cat = new Categoria();
//		cat.setId(1);
//		
//		pro2.setCategoria(cat);
//		daoPro.procedimientoAlmacenadoAltaProducto(pro2);
		
//LISTADO PRODUCTOS
		
//		ArrayList<Producto> lProductos = daoPro.obtenerTodosLosProductos();
//		for (Producto pro : lProductos)
//		{
//			System.out.println(pro.toString());
//		}
		
//LISTADO CATEGORIAS

//		ArrayList<Categoria> lCategoria = daoCat.obtenerTodasLasCategorias();
//		for (Categoria cat : lCategoria)
//		{
//			System.out.println(cat.toString());
//		}
		
// hay algo mal a la hora de listar las categorias, pone el id en 0 cuando deberia ser 1 en la primer categoria, debe ser por que usa el id que pusimos en la clase categoria
	}
}

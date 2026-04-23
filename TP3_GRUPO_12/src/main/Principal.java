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

// ==================== ALTA CATEGORIAS ====================

//		String[] nombresCategorias = {"Electronica", "Ropa", "Alimentos", "Hogar", "Deportes"};
//
//		for (String nombre : nombresCategorias) {
//			if (nombre == null || nombre.trim().isEmpty()) {
//				System.out.println("Error: el nombre de la categoria no puede estar vacio");
//			} else {
//				Categoria cat = new Categoria();
//				cat.setNombre(nombre);
//				int filas = daoCat.agregarCategoria(cat);
//				if (filas == 1) {
//					System.out.println("Categoria agregada: " + nombre);
//				} else {
//					System.out.println("Categoria no agregada: " + nombre);
//				}
//			}
//		}

// ==================== LISTADO CATEGORIAS ====================

		ArrayList<Categoria> lCategorias = daoCat.obtenerTodasLasCategorias();
		System.out.println("=== LISTADO DE CATEGORIAS ===");
		for (Categoria cat : lCategorias) {
			System.out.println(cat.toString());
		}

// ==================== ALTA PRODUCTOS ====================

//		ArrayList<Categoria> categorias = daoCat.obtenerTodasLasCategorias();
//
//		String[][] datosProductos = {
//			{"P001", "Notebook", "1500000.0", "20"},
//			{"P002", "Remera Deportiva", "25000.0", "100"},
//			{"P003", "Arroz 1kg", "3500.0", "500"},
//			{"P004", "Silla de Escritorio", "180000.0", "30"},
//			{"P005", "Pelota de Futbol", "45000.0", "60"}
//		};
//
//		for (int i = 0; i < datosProductos.length; i++) {
//			String codigo = datosProductos[i][0];
//			String nombre = datosProductos[i][1];
//			double precio = Double.parseDouble(datosProductos[i][2]);
//			int stock = Integer.parseInt(datosProductos[i][3]);
//
//			if (codigo == null || codigo.trim().isEmpty()) {
//				System.out.println("Error: el codigo no puede estar vacio");
//			} else if (nombre == null || nombre.trim().isEmpty()) {
//				System.out.println("Error: el nombre no puede estar vacio");
//			} else if (precio <= 0) {
//				System.out.println("Error: el precio debe ser mayor a cero");
//			} else if (stock < 0) {
//				System.out.println("Error: el stock no puede ser negativo");
//			} else {
//				Producto pro = new Producto();
//				pro.setCodigo(codigo);
//				pro.setNombre(nombre);
//				pro.setPrecio(precio);
//				pro.setStock(stock);
//				pro.setCategoria(categorias.get(i));
//				int filas = daoPro.agregarProducto(pro);
//				if (filas == 1) {
//					System.out.println("Producto agregado: " + nombre);
//				} else {
//					System.out.println("Producto no agregado: " + nombre);
//				}
//			}
//		}

// ==================== LISTADO PRODUCTOS ====================

		ArrayList<Producto> lProductos = daoPro.obtenerTodosLosProductos();
		System.out.println("=== LISTADO DE PRODUCTOS ===");
		for (Producto pro : lProductos) {
			System.out.println(pro.toString());
		}

// ==================== BAJA CATEGORIA ====================

//		int idCatBaja = 1;
//		if (idCatBaja <= 0) {
//			System.out.println("Error: el ID debe ser mayor a cero");
//		} else {
//			Categoria catBaja = new Categoria();
//			catBaja.setId(idCatBaja);
//			int filas = daoCat.bajaCategoria(catBaja);
//			if (filas == 1) {
//				System.out.println("Categoria eliminada");
//			} else {
//				System.out.println("Categoria no encontrada");
//			}
//		}

// ==================== BAJA PRODUCTO ====================

//		String codigoBaja = "P001";
//		if (codigoBaja == null || codigoBaja.trim().isEmpty()) {
//			System.out.println("Error: el codigo no puede estar vacio");
//		} else {
//			Producto proBaja = new Producto();
//			proBaja.setCodigo(codigoBaja);
//			int filas = daoPro.bajaProducto(proBaja);
//			if (filas == 1) {
//				System.out.println("Producto eliminado");
//			} else {
//				System.out.println("Producto no encontrado");
//			}
//		}

// ==================== MODIFICAR CATEGORIA ====================

//		int idCatMod = 2;
//		String nuevoNombreCat = "Tecnologia";
//		if (idCatMod <= 0) {
//			System.out.println("Error: el ID debe ser mayor a cero");
//		} else if (nuevoNombreCat == null || nuevoNombreCat.trim().isEmpty()) {
//			System.out.println("Error: el nombre no puede estar vacio");
//		} else {
//			Categoria catMod = new Categoria();
//			catMod.setId(idCatMod);
//			catMod.setNombre(nuevoNombreCat);
//			int filas = daoCat.modificarCategoria(catMod);
//			if (filas == 1) {
//				System.out.println("Categoria modificada");
//			} else {
//				System.out.println("Categoria no encontrada");
//			}
//		}

// ==================== MODIFICAR PRODUCTO ====================

//		String codigoMod = "P002";
//		String nuevoNombrePro = "Campera Deportiva";
//		double nuevoPrecio = 35000.0;
//		int nuevoStock = 80;
//		int nuevaCatId = 2;
//		if (codigoMod == null || codigoMod.trim().isEmpty()) {
//			System.out.println("Error: el codigo no puede estar vacio");
//		} else if (nuevoNombrePro == null || nuevoNombrePro.trim().isEmpty()) {
//			System.out.println("Error: el nombre no puede estar vacio");
//		} else if (nuevoPrecio <= 0) {
//			System.out.println("Error: el precio debe ser mayor a cero");
//		} else if (nuevoStock < 0) {
//			System.out.println("Error: el stock no puede ser negativo");
//		} else {
//			Producto proMod = new Producto();
//			proMod.setCodigo(codigoMod);
//			proMod.setNombre(nuevoNombrePro);
//			proMod.setPrecio(nuevoPrecio);
//			proMod.setStock(nuevoStock);
//			Categoria catMod = new Categoria();
//			catMod.setId(nuevaCatId);
//			proMod.setCategoria(catMod);
//			int filas = daoPro.modificarProducto(proMod);
//			if (filas == 1) {
//				System.out.println("Producto modificado");
//			} else {
//				System.out.println("Producto no encontrado");
//			}
//		}
	}
}

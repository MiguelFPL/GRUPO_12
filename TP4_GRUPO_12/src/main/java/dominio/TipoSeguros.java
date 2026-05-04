package dominio;

public class TipoSeguros {
	private int idTipo;
	private String descripcion;

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "TipoSeguros [idTipo=" + idTipo + ", descripcion=" + descripcion + "]";
	}

}

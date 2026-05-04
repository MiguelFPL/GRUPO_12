package dominio;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private double costoContratacion;
	private double costoAsegurado;
	TipoSeguros tipoSeguros;

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public double getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	public TipoSeguros getTipoSeguros() {
		return tipoSeguros;
	}

	public void setTipoSeguros(TipoSeguros tipoSeguros) {
		this.tipoSeguros = tipoSeguros;
	}

	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", costoContratacion="
				+ costoContratacion + ", costoAsegurado=" + costoAsegurado + ", tipoSeguros=" + tipoSeguros + "]";
	}

}

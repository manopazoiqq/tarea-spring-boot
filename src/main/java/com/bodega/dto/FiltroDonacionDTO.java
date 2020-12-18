package com.bodega.dto;

import java.time.LocalDateTime;

public class FiltroDonacionDTO {
	
	private LocalDateTime fechaDonacion;

	public LocalDateTime getFechaDonacion() {
		return fechaDonacion;
	}

	public void setFechaDonacion(LocalDateTime fechaConsulta) {
		this.fechaDonacion = fechaConsulta;
	}
}

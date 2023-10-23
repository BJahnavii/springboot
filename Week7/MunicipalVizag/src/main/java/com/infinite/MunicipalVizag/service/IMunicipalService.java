package com.infinite.MunicipalVizag.service;

import java.util.List;

import com.infnite.MunicipalVizag.model.Municipal;

public interface IMunicipalService {
	public List<Municipal> getAllComplains();

	public Municipal getMunicipal(int id);

	public Municipal addMunicipal(Municipal municipal);

	public void updateMunicipal(Municipal municipal);

	public void deleteMunicipal(int id);

}

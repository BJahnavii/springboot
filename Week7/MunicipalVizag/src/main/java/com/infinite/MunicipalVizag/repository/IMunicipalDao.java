package com.infinite.MunicipalVizag.repository;

import java.util.List;

import com.infnite.MunicipalVizag.model.Municipal;

public interface IMunicipalDao {
	public List<Municipal> getAllComplains();//to display list of all Complains

	public Municipal getMunicipal(int id);//to get the details by id

	public Municipal addMunicipal(Municipal municipal);// inserting details 

	public void updateMunicipal(Municipal municipal);//updating the details 

	public void deleteMunicipal(int id);//deleting 

}

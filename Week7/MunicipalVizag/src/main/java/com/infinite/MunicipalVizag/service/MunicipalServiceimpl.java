package com.infinite.MunicipalVizag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infinite.MunicipalVizag.repository.MunicipalDaoimpl;
import com.infnite.MunicipalVizag.model.Municipal;
@Service
public class MunicipalServiceimpl  implements IMunicipalService{
	@Autowired
	MunicipalDaoimpl MunicipalDaoimpl;

	@Override
	@Transactional
	public List<Municipal> getAllComplains() {
		// TODO Auto-generated method stub

		return MunicipalDaoimpl.getAllComplains();
	}

	@Override
	@Transactional
	public Municipal getMunicipal(int id) {
		// TODO Auto-generated method stub
		return MunicipalDaoimpl.getMunicipal(id);
	}

 

	@Override
	@Transactional
	public Municipal addMunicipal(Municipal municipal) {
		// TODO Auto-generated method stub
		return MunicipalDaoimpl.addMunicipal(municipal);
	}

 

	@Override
	@Transactional
	public void updateMunicipal(Municipal municipal) {
		// TODO Auto-generated method stub
		MunicipalDaoimpl.updateMunicipal(municipal);
	}

 

	@Override
	@Transactional
	public void deleteMunicipal(int id) {
		// TODO Auto-generated method stub
		MunicipalDaoimpl.deleteMunicipal(id);
	}
}

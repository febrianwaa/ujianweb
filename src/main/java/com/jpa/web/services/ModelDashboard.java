package com.jpa.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.web.entity.Dashboard;
import com.jpa.web.repository.DashboardRepository;
@Service
public class ModelDashboard implements ModelDashboardInterface{

	@Autowired
	DashboardRepository dashboardRepo;
	
	@Override
	public List <Dashboard> getAllDashboard(){
		return (List<Dashboard>) this.dashboardRepo.findAll();
	}
	
//	@Override
//	public Pertanyaan getPertanyaanByName(String nama) {
//		return this.pertanyaanRepo.findByNamaPertanyaan(nama);
//	}
	
	
	@Override
	public Dashboard addDashboard(Dashboard dashboard) {
		// TODO Auto-generated method stub
		
		return  this.dashboardRepo.save(dashboard);
	
	}
	
	
//	@Override
//	public Pertanyaan getPertanyaanById(String id) {
//		// TODO Auto-generated method stub
//		
//		return 	((Pertanyaan)this.pertanyaanRepo.findById(Long.parseLong(id)));
//		
//		
//	}

	@Override
	public void deleteDashboard(String id) {
		// TODO Auto-generated method stub
		this.dashboardRepo.deleteById(Long.parseLong(id));
		
	}
	
	@Override
	public Dashboard cariDashboard(String id) {
		// TODO Auto-generated method stub
		return this.dashboardRepo.findById(Long.parseLong(id)).get();
	}
	
	
	
}

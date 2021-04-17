package com.jpa.web.services;

import java.util.List;

import com.jpa.web.entity.Dashboard;

public interface ModelDashboardInterface {

	public List<Dashboard> getAllDashboard();
//	public Pertanyaan getPertanyaanByName(String name);
	
	public Dashboard addDashboard(Dashboard dashboard);
//	public Pertanyaan getPertanyaanById(String id);
	public void deleteDashboard(String id);
	
	public Dashboard cariDashboard(String id);
	
	
	
}

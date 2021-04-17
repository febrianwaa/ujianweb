package com.jpa.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.jpa.web.entity.Dashboard;
import com.jpa.web.services.ModelDashboard;
import com.jpa.web.utility.FileUtility;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
@Controller
public class DashboardPage {

	
	@Autowired
	ModelDashboard modelDashboard;
	
	 private final String UPLOAD_DIR = "./src/main/resources/static/uploads/";
	
	@GetMapping("/dashboard/view")
	public String viewIndexDashboard(Model model) {
		
		model.addAttribute("listDashboard",modelDashboard.getAllDashboard());
		model.addAttribute("active",4);
		return "view_dashboard";
	}
	
	@GetMapping("/proseslaporan/view")
	public String viewIndexProsesLaporan(Model model) {
		
		model.addAttribute("listDashboard",modelDashboard.getAllDashboard());
		model.addAttribute("active",6);
		return "view_proseslaporan";
	}
	
	
	@GetMapping("/dashboard/add")
	public String viewAddDashboard (Model model) {
		
		model.addAttribute("dashboard",new Dashboard ());
		model.addAttribute("active",5);
		return "add_dashboard";
	}
	
	
	@PostMapping("/dashboard/add")
	public String addDashboard(@RequestParam(value = "file")MultipartFile file,@ModelAttribute Dashboard dashboard, Model model) throws IOException {
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		   dashboard.setGambar(fileName);
	         
	        String uploadDir = "user-photos/" ;
	
	        FileUtility.saveFile(uploadDir, fileName, file);
	 
        dashboard.setGambar("/"+uploadDir + fileName);
		// buat penampung data mahasiswa di halaman htmlnya
		this.modelDashboard.addDashboard(dashboard);
		model.addAttribute("listDashboard", modelDashboard.getAllDashboard());
		
		
		return "add_dashboard";
	}
	
	
	
//	@GetMapping("/Dashboard/update/{id}")
//	public String viewUpdateDashboard(@PathVariable String id, Model model) {
//		
//		Dashboard Dashboard = modelDashboard.getDashboardById(id);
//		// buat penampung data mahasiswa di halaman htmlnya
//		model.addAttribute("Dashboard",Dashboard);
//		
//		return "add_Dashboard";
//	}

	@GetMapping("/dashboard/delete/{id}")
	public String deleteDashboard(@PathVariable String id, Model model) {
		
		this.modelDashboard.deleteDashboard(id);
		model.addAttribute("listDashboard",modelDashboard.getAllDashboard());
		
		
		return "view_dashboard";
	}
	
	
	
	@GetMapping("/dashboard/update/{id}")
	public String viewUpdateDashboard(@PathVariable String id, Model model) {
		
		Dashboard dashboard = modelDashboard.cariDashboard(id);
		// buat penampung data MataKuliah di halaman htmlnya
		model.addAttribute("dashboard",dashboard);
		
		return "add_dashboard";
	}
	
	
	
	@GetMapping("/dashboard/print")
	public String viewReportLaporan(Model model) {
		exportPDF();
		
		return "view_proseslaporan";
	}
	
	
	public void exportPDF() {
		try {
		File file = ResourceUtils.getFile("classpath:laporan.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		List<Dashboard> lstDashboard = modelDashboard.getAllDashboard();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstDashboard);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy","Juaracoding");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String path = "E:\\Laporan.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        
       
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
					
	}
	
	
	
	
	
	
}

package com.dailydairy.delivery.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailydairy.delivery.entity.Customer;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping("dailydairyRest")
public class ReportController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("/getcustomerReport")
	public List<Customer> customerReport(HttpServletResponse reponse) throws JRException, IOException, SQLException {
	
		reponse.setContentType("application/x-download");
		reponse.setHeader("Content-Disposition", String.format("attachment;filename=\"customer.pdf\""));
		OutputStream out = reponse.getOutputStream();
		exportReport(out);
		return null;

	}
	
	public void exportReport(OutputStream out) throws SQLException, JRException, IOException {
		
		Connection conn= jdbcTemplate.getDataSource().getConnection();
		//Resource resource = resourceLoader.getResource("classpath:customersReport.jrxml");
	//	File file = resource.getFile();
		File file = new File("/home/ec2-user/customersReport.jrxml");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<PATH:>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+file.getPath()+file.getName());
		JasperReport jasperReport
		  = JasperCompileManager.compileReport(file.getPath());
		Map<String,Object> paramaters= new HashMap<>();
		
		JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, paramaters,conn);
	JasperExportManager.exportReportToPdfStream(jasperPrint,out);
		
	}
	
}

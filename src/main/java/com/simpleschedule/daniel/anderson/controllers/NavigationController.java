package com.simpleschedule.daniel.anderson.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import com.simpleschedule.daniel.anderson.entities.Location;
import com.simpleschedule.daniel.anderson.entities.Staff;
import com.simpleschedule.daniel.anderson.services.LocationService;
import com.simpleschedule.daniel.anderson.services.StaffService;

@Controller
public class NavigationController {
	private LocationService locationService;
	private StaffService staffService;

	@Autowired
	public NavigationController(LocationService locationService, StaffService staffService) {
		this.locationService = locationService;
		this.staffService = staffService;
	}

	@GetMapping("/")
	public String showMainPage(HttpSession session) {
		// if session attribute 'doctorList' is not yet initialized, call staffService method and set it
		if (session.getAttribute("doctorList") == null) {
			List<Staff> doctorList = staffService.findAllDoctors();
			session.setAttribute("doctorList", doctorList);
		}
		// if session attribute 'locationMap' is not yet initialized, call locationService method and set it
		if (session.getAttribute("locationMap") == null) {
			HashMap<Integer, Location> locationMap = locationService.getAll();
			session.setAttribute("locationMap", locationMap);
		}
		return "index";
	}
}
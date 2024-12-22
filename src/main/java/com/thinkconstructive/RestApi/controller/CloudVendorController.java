package com.thinkconstructive.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkconstructive.RestApi.model.CloudVendor;
import com.thinkconstructive.RestApi.response.ResponseHandler;
import com.thinkconstructive.RestApi.service.CloudVendorService;

@RestController
@RequestMapping(path = "/api/cloud")
public class CloudVendorController {
	
	@Autowired
	CloudVendorService cloudVendorService;

//	public CloudVendorController(CloudVendorService cloudVendorService) {
//		this.cloudVendorService = cloudVendorService;
//	}

	// Read Specific Cloud Vendor Details from DB
	@GetMapping("/{vendorId}")
	public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		return ResponseHandler.responseBuilder("Your requested Data", 
				HttpStatus.OK, cloudVendorService.getCloudVendor(Integer.parseInt(vendorId)));
	}

	// Read All Cloud Vendor Details from DB
	@GetMapping("/")
	public List<CloudVendor> getAllCloudVendorDetails() {
		return cloudVendorService.getAllCloudVendor();
	}

	@PostMapping
	public String createAllCloudVendorDetails(@RequestBody List<CloudVendor> cloudVendor) {
		
		cloudVendor.forEach(cv->cloudVendorService.createCloudVendor(cv));
		return "Cloud Vendor Created Successfully";
	}

	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud Vendor Updated Successfully";
	}

	@DeleteMapping("{vendorId}")
	public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
		cloudVendorService.deleteCloudVendor(Integer.parseInt(vendorId));
		return "Cloud Vendor Deleted Successfully";
	}

}

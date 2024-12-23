package com.thinkconstructive.RestApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkconstructive.RestApi.Repository.CloudVendorRepository;
import com.thinkconstructive.RestApi.expection.CloudVendorNotFoundExpection;
import com.thinkconstructive.RestApi.model.CloudVendor;
import com.thinkconstructive.RestApi.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
	
	@Autowired
	CloudVendorRepository cvRepo;

//	public CloudVendorServiceImpl(CloudVendorRepository cvRepo) {
//		this.cvRepo = cvRepo;
//	}

	@Override
	public String createCloudVendor(CloudVendor cv) {
		cvRepo.save(cv);
		return "successfully Saved";
	}

	@Override
	public String updateCloudVendor(CloudVendor cv) {
		cvRepo.save(cv);
		return "successfully Updated";
	}

	@Override
	public String deleteCloudVendor(int id) {
		cvRepo.deleteById(id);;
		return "successfully Deleted";
	}

	@Override
	public CloudVendor getCloudVendor(int id) {
		if(cvRepo.findById(id).isEmpty()) throw new CloudVendorNotFoundExpection("Requested Cloud Vendor Does not exist. Please check the Id.");
		return cvRepo.findById(id).get();
	}

	@Override
	public List<CloudVendor> getAllCloudVendor() {
		return cvRepo.findAll();
	}


}

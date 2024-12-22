package com.thinkconstructive.RestApi.service;

import java.util.List;

import com.thinkconstructive.RestApi.model.CloudVendor;

public interface CloudVendorService {
	
	public String createCloudVendor(CloudVendor cv);
	public String updateCloudVendor(CloudVendor cv);
	public String deleteCloudVendor(int id);
	public CloudVendor getCloudVendor(int id);
	public List<CloudVendor> getAllCloudVendor();
}

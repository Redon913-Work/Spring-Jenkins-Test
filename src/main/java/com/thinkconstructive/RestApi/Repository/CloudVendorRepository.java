package com.thinkconstructive.RestApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thinkconstructive.RestApi.model.CloudVendor;

@Service
public interface CloudVendorRepository extends JpaRepository<CloudVendor, Integer>{

}

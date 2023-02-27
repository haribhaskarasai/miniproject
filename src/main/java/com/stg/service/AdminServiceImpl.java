package com.stg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Admin;

import com.stg.exception.ExceptionClass;
import com.stg.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {
	
    @Autowired
    private AdminRepository adminRepository;

	
	@Override
	public Admin addAdmin(Admin admin) throws ExceptionClass{
        return adminRepository.save(admin);
	}

	@Override
	public Admin getAdmin(String email, String password) throws ExceptionClass {
		Admin adminTemp = adminRepository.findByAdminEmail(email);
        if (adminTemp != null && adminTemp.getPassword().equals(password)) {
              return adminTemp;
        } else {
        	throw new ExceptionClass("Admin do not exist");
        }
	}

}

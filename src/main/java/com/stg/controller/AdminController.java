package com.stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.entity.Admin;
import com.stg.service.AdminServiceImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(value = "Admin")
public class AdminController {
	@Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping(value = "addAdmin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Admin addAdmin(@RequestBody Admin admin) { 
          return adminServiceImpl.addAdmin(admin);
    }

    @GetMapping(value = "getAdmin")
    public Admin getAdmin(@RequestParam String email, @RequestParam String password) {
          return adminServiceImpl.getAdmin(email, password);
    }



}

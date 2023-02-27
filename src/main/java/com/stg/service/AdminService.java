package com.stg.service;

import com.stg.entity.Admin;
import com.stg.exception.ExceptionClass;

public interface AdminService {
      public abstract Admin addAdmin(Admin admin) throws ExceptionClass;
    public abstract Admin getAdmin(String email,String password) throws ExceptionClass;

}



package com.lzj.providerservice.service;

import com.lzj.providerservice.bean.Student;
import com.lzj.providerservice.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> findAll() {
        return studentDao.findAll();
    }
}

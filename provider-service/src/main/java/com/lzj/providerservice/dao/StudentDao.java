package com.lzj.providerservice.dao;

import com.lzj.providerservice.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class StudentDao {

    private static ConcurrentHashMap<Long, Student> stuMap = new ConcurrentHashMap<>();

    static {
        stuMap.put(1L, new Student(1L, "张三", 14, "男"));
        stuMap.put(2L, new Student(2L, "lisi", 14, "女"));
        stuMap.put(3L, new Student(3L, "wangwu", 14, "男"));
    }

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> findAll() {
        List<Student> lists = new ArrayList<>();
        for(Map.Entry<Long, Student> entry : stuMap.entrySet()) {
            lists.add(entry.getValue());
        }

        return lists;
    }
}

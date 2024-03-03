package com.yourdaddynka.springStudentsDB.service;

import com.yourdaddynka.springStudentsDB.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    public List<Student> findAll();
    public boolean save(Student student);
    public Optional<Student> findById(int idStudent);
    public Optional<Student> update(Student student);
    public boolean remove(int idStudent);
}

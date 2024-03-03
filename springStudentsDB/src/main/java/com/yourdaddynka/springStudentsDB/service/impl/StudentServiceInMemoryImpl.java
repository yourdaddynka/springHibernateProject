package com.yourdaddynka.springStudentsDB.service.impl;

import com.yourdaddynka.springStudentsDB.model.Student;
import com.yourdaddynka.springStudentsDB.repository.InMemoryStudentDAO;
import com.yourdaddynka.springStudentsDB.service.StudentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//сообщаем spring что этот класс является сервисом
// текущий класс является реализацией хранния в "Железе"
public class StudentServiceInMemoryImpl implements StudentService {
    @NonNull
    private final InMemoryStudentDAO repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> findById(int idStudent) {
        return repository.findById(idStudent);
    }

    @Override
    public Optional<Student> update(Student student) {
        return repository.update(student);
    }

    @Override
    public boolean remove(int idStudent) {
        return repository.remove(idStudent);
    }
}

package com.yourdaddynka.springStudentsDB.service.impl;

import com.yourdaddynka.springStudentsDB.model.Student;
import com.yourdaddynka.springStudentsDB.repository.StudentRepository;
import com.yourdaddynka.springStudentsDB.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//    @Primary - выбор приоритета хранения(аппаратный(файл DAO) или БД(текущий))
//    @Transactional - для корректного удаления из БД(иначче ошибка в postman)
//    Все реализованные методы исходят из StudentRepository,который наследуется от JpaRepository(в параметры передаем класс, по которому реализуется бд и тип данных уникального ключа). Внутри даного класса есть все необходимые методы для работы с бд.

@Service
@AllArgsConstructor
@Primary
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return Optional.of(repository.save(student)).isPresent();
    }

    @Override
    public Optional<Student> findById(int idStudent) {
        return repository.findById(idStudent);
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.of(repository.save(student));
    }

    @Override
    @Transactional
    public boolean remove(int idStudent) {
        repository.deleteById(idStudent);
        return true;
    }
}

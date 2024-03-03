package com.yourdaddynka.springStudentsDB.repository;


import com.yourdaddynka.springStudentsDB.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// определение Data Access Object описывает как прослойку между БД и системой.
// DAO определяет общие методы использования соединения, его получение, закрытие и (или) возвращение в Connection Pool.
//@Repository делаем этот класс Bean-ом для работы с данными (хранение на машине, позже следует переделать хранение на БД)
//текущий класс - хранение данных не в БД а в памяти(в текущем проекте приоритет отдан БД, но в случае ошибки с бд програма переключит хранение в железо)
@Repository
public class InMemoryStudentDAO {
    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> findAll() {
        return STUDENTS;
    }

    public boolean save(Student student) {
        return STUDENTS.add(student);
    }

    public Optional<Student> findById(int idStudent) {
        return Optional.ofNullable(STUDENTS.stream()
                .filter(element -> element.getId().equals(idStudent))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Пользователь с таким ID: " + idStudent + " не найден")));
    }

    public Optional<Student> update(Student student) {
        for (int i = 0; i < STUDENTS.size(); i++) {
            if (STUDENTS.get(i).getId().equals(student.getId())) {
                STUDENTS.set(i, student);
                return Optional.ofNullable(STUDENTS.get(i));
            }
        }
        return Optional.empty();
    }

    public boolean remove(int idStudent) {
        Optional<Student> student = findById(idStudent);
        return student.map(STUDENTS::remove).orElse(false);
    }
}

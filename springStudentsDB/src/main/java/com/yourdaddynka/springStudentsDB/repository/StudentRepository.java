package com.yourdaddynka.springStudentsDB.repository;

import com.yourdaddynka.springStudentsDB.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


//  StudentRepository наследует JpaRepository, кеоторый хранит в себе операции по добавлени, удалению и т,д.
//  В JpaRepository передаются такие параметры как: класс, по которому будет реализована таблица, тип данных с уникальным ключом для данной таблицы
//  метод deleteById автореализуется, его я прописал сам
public interface StudentRepository extends JpaRepository<Student, Integer> {
    void deleteById(int idStudent);
}

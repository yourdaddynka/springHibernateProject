package com.yourdaddynka.springStudentsDB.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Builder
@Data
@Entity
public class Student {
//    @NonNull
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Column(unique = true) private String email;
    @Transient private int age;

}

    // lombock - библа сокращающая повторяющийся код с помощью аннотаций,вот некоторые из них:
    // @Getter- создание getter-ов
    // @Setter- создание setter-ов
    // @NoArgsConstructor - пустой контруктор
    // @AllArgsConstructor - контруктор со всеми полями
    // @RequiredArgsConstructor - конструктор с какими-то обязательными полями( указываем над полями аннотацию @NonNull)
    // @Data - содержит все вышеперечисленные аннотации + hashCode + Equals
    // @Builder - для простого создания экземпляров класса (см findAll в StudController)
    // @Builder - так как происхходит конфликт с @NonNull ID(аннотация Builder)
    // @Entity - чтобы работала анотация, требуется определение первичного ключа(@id), а @GeneratedValue просто создает уникальные айдишки
    // @transient подобно public, final и т.д. для обозначения что поле не должно быть сериализовано(запоминаться).
// Когда указывать:вычисляется программно,конфидециальная инфа,состояние

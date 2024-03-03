package com.yourdaddynka.springStudentsDB.controller;

import com.yourdaddynka.springStudentsDB.model.Student;
import com.yourdaddynka.springStudentsDB.service.StudentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//    RestController наследуется от Controller и содержит @ResponseBody(автосериализация JSON)
//    RequestMapping принимает строку  api и версия приложения(по сути, вкладка полокалхосту для выполнения операций)
//    @Autowired - анотация из @Bean заменяющая "= new StudentService()".
//    Но лучше использовать @RequiredArgsConstructor и nonNull,чтобы всегда иницилизировать помеченное поле,
//    ну или просто AllArgsConstructor
//    @PathVariable - явно связываем API текущего метода с передающимся параметром(в дефолтном состоянии маппинг принимает название переменой(например, не /id а /idStudent)
//    по всем  Маппингам лучше подробно изучить в инете)

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    @NonNull
    private final StudentService studentService;
    @GetMapping
    public List<Student> findAll() {return studentService.findAll();}
    @PostMapping("save_student")
    public boolean saveStudent(@RequestBody Student student) {return studentService.save(student);}
    @GetMapping("/{id}")
    //  @PathVariable - явно указыаем, что в URL /{id} вставляем поле idStudent, но так как они написаны не одинаково, то явно указываем в круглых скобках по какому полю сопоставлять
    public Student findByIdStudent(@PathVariable("id") Integer idStudent) {return studentService.findById(idStudent).get();}
    @PutMapping("update_mapping")
    public Student updateStudent(@RequestBody Student student){return studentService.update(student).get();}
    @DeleteMapping("delete_student/{id}")
    public boolean remove(@PathVariable("id") int idStudent){return studentService.remove(idStudent);}
}


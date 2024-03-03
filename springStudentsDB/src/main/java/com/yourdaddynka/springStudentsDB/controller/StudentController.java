package com.yourdaddynka.springStudentsDB.controller;

import com.yourdaddynka.springStudentsDB.model.Student;
import com.yourdaddynka.springStudentsDB.service.StudentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController наследуется от Controller и содержит @ResponseBody(автосериализация JSON)
@RestController
//RequestMapping принимает строку  api и версия приложения
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    //    @Autowired - анотация из @Bean заменяющая "= new StudentService()".
    //    Но лучше использовать @RequiredArgsConstructor и nonNull,чтобы всегда иницилизировать,
    //    ну или просто AllArgsConstructor
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

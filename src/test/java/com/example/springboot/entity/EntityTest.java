package com.example.springboot.entity;

import com.example.springbootdesign.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.TabExpander;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class EntityTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ElectiveRepository electiveRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private DirectionElectiveRepository directionElectiveRepository;
    @Test
    public void init(){
        Student stu=new Student();
        stu.setId(1111111111);
        stu.setName("doctor");

        studentRepository.save(stu);
        Student stu1=new Student();
        stu1.setId(2222222222);
        stu1.setName("faker");
        studentRepository.save(stu1);

        Student stu2=new Student();
        stu2.setId(3333333333);
        stu2.setName("hover");
        studentRepository.save(stu2);

        Teacher tea = new Teacher();
        tea.setName("teacher");
        teacherRepository.save(tea);

        Course cou = new Course();
        cou.setName("Web");
        courseRepository.save(cou);

        Course cou2 = new Course();
        cou2.setName("docker");
        courseRepository.save(cou2);

        Direction dir = new Direction();
        dir.setName("small");
        directionRepository.save(dir);

        Direction dir1 = new Direction();
        dir1.setName("ds-conter");
        directionRepository.save(dir1);

    }
    @Test
    public void test_teacherToStudent(){
        Teacher tea = teacherRepository.findById(1).orElse(null);
        Student stu = studentRepository.findById(1111111111).orElse(null);
        stu.setTeacher(tea);
        studentRepository.save(stu);

    }
    @Test
    public void test_CourseToStu(){
        Course cou = courseRepository.findById(1).orElse(null);
        Student stu = studentRepository.findById(1111111111).orElse(null);
        Elective elective = new Elective();
        elective.setCourse(cou);
        elective.setStudent(stu);
        elective.setGrade(92);
        electiveRepository.save(elective);

    }
    @Test
    public void test_DirectionToStudent(){
        Direction direction = directionRepository.findById(1).orElse(null);
        Student stu = studentRepository.findById(1111111111).orElse(null);
        DirectionElective elective = new DirectionElective();
        elective.setDirection(direction);
        elective.setStudent(stu);
        directionElectiveRepository.save(elective);

    }
}
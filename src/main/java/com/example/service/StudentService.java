package com.example.service;

import com.example.pojo.*;

import java.util.List;

public interface StudentService {

    PageBean page(Integer page, Integer pageSize);

    void selectCourse(SC sc);

    List<SC> selectGrade(Integer student_id);

    List<Course> selectTable(Integer student_id);

    void deleteCourse(SC sc);

    void updateBook(SC sc);

    void setFeedback(SC sc);

    Student LoginStudent(Student student);

    void UpdateStudentPassword(Student student);

    List<Student> findStudents(String studentNo, String studentName, String studentDept, String studentDOB, String studentSex, int page, int pageSize);

    int getTotalCount(String studentNo, String studentName, String studentDept, String studentDOB, String studentSex);
}

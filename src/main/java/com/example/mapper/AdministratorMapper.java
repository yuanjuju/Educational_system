package com.example.mapper;

import com.example.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministratorMapper {

    @Insert("        INSERT INTO student(StudentID, Name,Gender,DOB,DeptID,Username,Password,student_no)\n" +
            "        VALUES (#{student_id}, #{student_name},#{student_sex},#{student_DOB},#{student_dept_id},#{Username},#{password},#{student_no})")
    void AddStudent(Student student);


    @Insert("        INSERT INTO teacher( Name,Gender,DeptID,Title,teacher_no,password)\n" +
            "        VALUES (#{teacher_name},#{teacher_sex},#{teacher_dept_id},#{teacher_position},#{teacher_no},#{password})")
    void AddTeacher(Teacher teacher);


    @Insert("INSERT INTO course(CourseName, Credits, TeacherID, DayOfWeek, TimePeriod)\n" +
            "VALUES (#{course_name}, #{credit}, #{teacher_id}, #{day_of_week}, #{time_slot})")
    void AddCourse(Course course);

    @Insert("INSERT INTO sc(StudentID, CourseID, BuyBook) " +
            "VALUES (#{student_id}, #{course_id}, #{buy_textbook})")
    void AddSC(SC sc);


    @Delete("delete from student where StudentID = #{student_id}")
    void DeleteStudent(Integer student_id);

    @Delete("delete from teacher where TeacherID = #{teacher_id}")
    void DeleteTeacher(Integer teacher_id);

    @Delete("delete from course where CourseID = #{course_id}")
    void DeleteCourse(Integer courseId);

    @Delete("delete from sc where StudentID=#{student_id} and CourseID = #{course_id}")
    void DeleteSC(Integer studentId,Integer courseId);


    @Update("UPDATE student\n" +
            "SET \n" +
            "    Name = COALESCE(#{student_name}, Name),\n" +
            "    Gender = COALESCE(#{student_sex}, Gender),\n" +
            "    DeptID = COALESCE(#{student_dept_id}, DeptID),\n" +
            "    Password = COALESCE(#{password}, Password),\n" +
            "    DOB = COALESCE(#{student_DOB}, DOB),\n" +
            "    student_no = COALESCE(#{student_no}, student_no)\n" +
            "WHERE StudentID = #{student_id};")
    void UpdateStudent(Student student);

    @Update("UPDATE teacher\n" +
            "SET \n" +
            "    Name = COALESCE(#{teacher_name}, Name),\n" +
            "    Gender = COALESCE(#{teacher_sex}, Gender),\n" +
            "    DeptID = COALESCE(#{teacher_dept_id}, DeptID),\n" +
            "    password = COALESCE(#{teacher_password}, password),\n" +
            "    teacher_no = COALESCE(#{teacher_no}, teacher_no),\n" +
            "    Title = COALESCE(#{teacher_position}, Title)\n" +
            "WHERE TeacherID = #{teacher_id};")
    void UpdateTeacher(Teacher teacher);


    @Update("UPDATE course " +
            "SET " +
            "    course_no = COALESCE(#{course_no}, course_no), " +
            "    CourseName = COALESCE(#{course_name}, CourseName), " +
            "    Credits = COALESCE(#{credit}, Credits), " +
            "    TeacherID = COALESCE(#{teacher_id}, TeacherID), " +
            "    DayOfWeek = COALESCE(#{day_of_week}, DayOfWeek), " +
            "    TimePeriod = COALESCE(#{time_slot}, TimePeriod) " +
            "WHERE CourseID = #{course_id};")
    void UpdateCourse(Course course);


    @Update("UPDATE sc " +
            "SET " +
            "    BuyBook = COALESCE(#{buy_textbook}, BuyBook), " +
            "    Grade = COALESCE(#{grade}, Grade) " +
            "WHERE StudentID = #{student_id} AND CourseID = #{course_id};")
    void UpdateSC(SC sc);


    @Select("select * from admin where admin_no=#{admin_no}")
    List<Admin> CheckadminInfo(String admin_no);
}

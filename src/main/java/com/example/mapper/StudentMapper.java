package com.example.mapper;


import com.example.pojo.Course;
import com.example.pojo.SC;
import com.example.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {






    @Select("SELECT COUNT(*) FROM course")
    Long countCourses();

//    @Select("select * from course")
    List<Course> findCourses();

    @Insert("        INSERT INTO SC(StudentID, CourseID)\n" +
            "        VALUES (#{student_id}, #{course_id})")
    void selectCourse(SC sc);



    @Select("select CourseName,Grade " +
            "from sc,course " +
            "where sc.CourseID=course.CourseID and StudentID=#{student_id}")
    List<SC> selectGrade(Integer student_id);


    @Select(("select DayOfWeek,course.CourseID,CourseName,Credits,Name,TimePeriod " +
            "from course,teacher,sc " +
            "where course.TeacherID=teacher.TeacherID and course.CourseID=sc.CourseID and StudentID=#{student_id};"))
    List<Course> selectTable(Integer student_id);

    @Delete("delete from sc " +
            "where StudentID=#{student_id} and CourseID=#{course_id}")
    void deleteCourse(SC sc);


    @Update("update sc " +
            "set BuyBook=#{buy_textbook} " +
            "where StudentID=#{student_id} and CourseID=#{course_id}")
    void updateBook(SC sc);



    @Update("update sc " +
            "set feedback=#{feedback} " +
            "where StudentID=#{student_id} and CourseID=#{course_id}")
    void setFeedback(SC sc);

    @Select("select * from student where Password=#{password} and student_no=#{student_no}")
    Student LoginStudent(Student student);

    @Update("update student " +
            "set Password=#{new_password} " +
            "where student_no=#{student_no} and Password=#{password}")
    void UpdateStudentPassword(Student student);


    List<Student> findStudents(
            @Param("studentNo") String studentNo,
            @Param("studentName") String studentName,
            @Param("studentDept") String studentDept,
            @Param("studentDOB") String studentDOB,
            @Param("studentSex") String studentSex,
            @Param("offset") int offset,
            @Param("limit") int limit
    );


    int getTotalCount(
            @Param("studentNo") String studentNo,
            @Param("studentName") String studentName,
            @Param("studentDept") String studentDept,
            @Param("studentDOB") String studentDOB,
            @Param("studentSex") String studentSex
    );
}

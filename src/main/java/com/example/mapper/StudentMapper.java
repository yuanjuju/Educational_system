package com.example.mapper;


import com.example.pojo.Course;
import com.example.pojo.SC;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT COUNT(*) FROM course")
    Long countCourses();

//    @Select("select * from course")
    List<Course> findCourses();

    @Insert("        INSERT INTO SC(StudentID, CourseID)\n" +
            "        VALUES (#{studentID}, #{courseID})")
    void selectCourse(SC sc);



    @Select("select CourseName,Grade " +
            "from sc,course " +
            "where sc.CourseID=course.CourseID and StudentID=#{studentID}")
    List<SC> selectGrade(Integer StudentID);


    @Select(("select DayOfWeek,course.CourseID,CourseName,Credits,Name,TimePeriod " +
            "from course,teacher,sc " +
            "where course.TeacherID=teacher.TeacherID and course.CourseID=sc.CourseID and StudentID=#{StudentID};"))
    List<Course> selectTable(Integer studentID);

    @Delete("delete from sc " +
            "where StudentID=#{StudentID} and CourseID=#{courseID}")
    void deleteCourse(SC sc);


    @Update("update sc " +
            "set BuyBook=#{BuyBook} " +
            "where StudentID=#{StudentID} and CourseID=#{courseID}")
    void updateBook(SC sc);



    @Update("update sc " +
            "set feedback=#{feedback} " +
            "where StudentID=#{StudentID} and CourseID=#{courseID}")
    void setFeedback(SC sc);
}

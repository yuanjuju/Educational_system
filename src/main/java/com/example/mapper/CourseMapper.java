package com.example.mapper;

import com.example.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface CourseMapper {



    List<Course> selectCourses(@Param("courseNo") String courseNo,
                               @Param("courseName") String courseName,
                               @Param("credit") Integer credit,
                               @Param("dayOfWeek") String dayOfWeek,
                               @Param("timeSlot") String timeSlot,
                               @Param("teacherName") String teacherName,
                               @Param("offset") int offset,
                               @Param("limit") int limit);




    int getTotalCount(
            @Param("courseNo") String courseNo,
            @Param("courseName") String courseName,
            @Param("credit") Float credit,
            @Param("dayOfWeek") String dayOfWeek,
            @Param("timeSlot") String timeSlot
    );
    @Select("SELECT c.CourseID, c.CourseName " +
            "FROM course c " +
            "WHERE c.TeacherID = #{teacherId}")
    List<Course> findCoursesByTeacherId(@Param("teacherId") int teacherId);
    @Select("SELECT c.CourseID, c.course_no, c.CourseName, c.Credits, c.DayOfWeek, c.TimePeriod, t.TeacherID, t.Name " +
            "FROM course c " +
            "JOIN teacher t ON c.TeacherID = t.TeacherID " +
            "LIMIT #{offset}, #{limit}")
    List<Course> getCourses(@Param("offset") int offset, @Param("limit") int limit);


    @Select("SELECT COUNT(*) FROM course")
    int getTotalCourseCount();



    int getTotalCoursesCount(@Param("course_no") String course_no,
                             @Param("course_name") String course_name,
                             @Param("credit") Float credit,
                             @Param("day_of_week") String day_of_week,
                             @Param("time_slot") String time_slot);

    List<Course> findCourses(@Param("course_no") String courseNo,
                             @Param("course_name")String courseName,
                             @Param("credit") Float credit,
                             @Param("day_of_week") String dayOfWeek,
                             @Param("time_slot") String timeSlot,
                             @Param("page") int page,
                             @Param("pageSize") int pageSize);
}
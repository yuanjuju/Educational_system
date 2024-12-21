package com.example.mapper;

import com.example.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface CourseMapper {

    /**
     * 查找符合条件的课程（分页）
     * @param courseNo 课程号
     * @param courseName 课程名称
     * @param credit 学分
     * @param dayOfWeek 上课星期
     * @param timeSlot 上课时间段
     * @param teacherName 授课教师姓名
     * @param offset 分页偏移量
     * @param limit 每页记录数
     * @return 符合条件的课程列表
     */
    @Select("<script>"
            + "SELECT c.course_id, c.course_no, c.course_name, c.credit, c.day_of_week, c.time_slot, t.teacher_name "
            + "FROM courses c "
            + "LEFT JOIN teachers t ON c.teacher_id = t.teacher_id "
            + "WHERE 1=1 "
            + "<if test='courseNo != null'> AND c.course_no LIKE CONCAT('%', #{courseNo}, '%') </if>"
            + "<if test='courseName != null'> AND c.course_name LIKE CONCAT('%', #{courseName}, '%') </if>"
            + "<if test='credit != null'> AND c.credit = #{credit} </if>"
            + "<if test='dayOfWeek != null'> AND c.day_of_week LIKE CONCAT('%', #{dayOfWeek}, '%') </if>"
            + "<if test='timeSlot != null'> AND c.time_slot LIKE CONCAT('%', #{timeSlot}, '%') </if>"
            + "<if test='teacherName != null'> AND t.teacher_name LIKE CONCAT('%', #{teacherName}, '%') </if>"
            + "LIMIT #{offset}, #{limit}"
            + "</script>")
    List<Course> findCourses(
            @Param("courseNo") String courseNo,
            @Param("courseName") String courseName,
            @Param("credit") Float credit,
            @Param("dayOfWeek") String dayOfWeek,
            @Param("timeSlot") String timeSlot,
            @Param("teacherName") String teacherName,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    /**
     * 获取符合条件的课程总数
     * @param courseNo 课程号
     * @param courseName 课程名称
     * @param credit 学分
     * @param dayOfWeek 上课星期
     * @param timeSlot 上课时间段
     * @param teacherName 授课教师姓名
     * @return 总记录数
     */
    @Select("<script>"
            + "SELECT COUNT(*) FROM courses c "
            + "LEFT JOIN teachers t ON c.teacher_id = t.teacher_id "
            + "WHERE 1=1 "
            + "<if test='courseNo != null'> AND c.course_no LIKE CONCAT('%', #{courseNo}, '%') </if>"
            + "<if test='courseName != null'> AND c.course_name LIKE CONCAT('%', #{courseName}, '%') </if>"
            + "<if test='credit != null'> AND c.credit = #{credit} </if>"
            + "<if test='dayOfWeek != null'> AND c.day_of_week LIKE CONCAT('%', #{dayOfWeek}, '%') </if>"
            + "<if test='timeSlot != null'> AND c.time_slot LIKE CONCAT('%', #{timeSlot}, '%') </if>"
            + "<if test='teacherName != null'> AND t.teacher_name LIKE CONCAT('%', #{teacherName}, '%') </if>"
            + "</script>")
    int getTotalCount(
            @Param("courseNo") String courseNo,
            @Param("courseName") String courseName,
            @Param("credit") Float credit,
            @Param("dayOfWeek") String dayOfWeek,
            @Param("timeSlot") String timeSlot,
            @Param("teacherName") String teacherName
    );
    @Select("SELECT c.course_id, c.course_name " +
            "FROM course c " +
            "WHERE c.teacher_id = #{teacherId}")
    List<Course> findCoursesByTeacherId(@Param("teacherId") int teacherId);
    @Select("SELECT c.course_id, c.course_no, c.course_name, c.credit, t.teacher_name, c.day_of_week, c.time_slot " +
            "FROM course c " +
            "JOIN teacher t ON c.teacher_id = t.teacher_id " +
            "LIMIT #{offset}, #{limit}")
    List<Course> getCourses(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 查询课程总数
     * @return 总课程数
     */
    @Select("SELECT COUNT(*) FROM course")
    int getTotalCourseCount();

    /**
     * 查询满足条件的课程总数
     * @param course_no 课程号
     * @param course_name 课程名称
     * @param credit 学分
     * @param day_of_week 上课时间（星期x）
     * @param time_slot 上课时间（xx:xx-xx:xx）
     * @param teacher_name 授课教师
     * @return 符合条件的课程总数
     */
    @Select("<script>" +
            "SELECT COUNT(*) " +
            "FROM course c " +
            "JOIN teacher t ON c.teacher_id = t.teacher_id " +
            "WHERE 1=1 " +
            "<if test='course_no != null and course_no != \"\"'> AND c.course_no = #{course_no} </if>" +
            "<if test='course_name != null and course_name != \"\"'> AND c.course_name LIKE CONCAT('%', #{course_name}, '%') </if>" +
            "<if test='credit != null'> AND c.credit = #{credit} </if>" +
            "<if test='day_of_week != null and day_of_week != \"\"'> AND c.day_of_week = #{day_of_week} </if>" +
            "<if test='time_slot != null and time_slot != \"\"'> AND c.time_slot = #{time_slot} </if>" +
            "<if test='teacher_name != null and teacher_name != \"\"'> AND t.teacher_name LIKE CONCAT('%', #{teacher_name}, '%') </if>" +
            "</script>")
    int getTotalCoursesCount(@Param("course_no") String course_no,
                             @Param("course_name") String course_name,
                             @Param("credit") Float credit,
                             @Param("day_of_week") String day_of_week,
                             @Param("time_slot") String time_slot,
                             @Param("teacher_name") String teacher_name);
}
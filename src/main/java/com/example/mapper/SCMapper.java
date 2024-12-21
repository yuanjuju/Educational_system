package com.example.mapper;

import com.example.pojo.SC;
import com.example.pojo.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SCMapper {


    @Select("<script>"
            + "SELECT sc.student_no, sc.course_no, sc.buy_textbook, sc.grade "
            + "FROM student_course sc "
            + "WHERE 1=1 "
            + "<if test='studentNo != null'> AND sc.student_no LIKE CONCAT('%', #{studentNo}, '%') </if>"
            + "<if test='courseNo != null'> AND sc.course_no LIKE CONCAT('%', #{courseNo}, '%') </if>"
            + "<if test='buyTextbook != null'> AND sc.buy_textbook = #{buyTextbook} </if>"
            + "<if test='minGrade != null'> AND sc.grade &gt;= #{minGrade} </if>"
            + "<if test='maxGrade != null'> AND sc.grade &lt;= #{maxGrade} </if>"
            + "LIMIT #{offset}, #{limit}"
            + "</script>")
    List<SC> findStudentCourses(
            @Param("studentNo") String studentNo,
            @Param("courseNo") String courseNo,
            @Param("buyTextbook") String buyTextbook,
            @Param("minGrade") Float minGrade,
            @Param("maxGrade") Float maxGrade,
            @Param("offset") int offset,
            @Param("limit") int limit
    );


    @Select("<script>"
            + "SELECT COUNT(*) "
            + "FROM student_course sc "
            + "WHERE 1=1 "
            + "<if test='studentNo != null'> AND sc.student_no LIKE CONCAT('%', #{studentNo}, '%') </if>"
            + "<if test='courseNo != null'> AND sc.course_no LIKE CONCAT('%', #{courseNo}, '%') </if>"
            + "<if test='buyTextbook != null'> AND sc.buy_textbook = #{buyTextbook} </if>"
            + "<if test='minGrade != null'> AND sc.grade &gt;= #{minGrade} </if>"
            + "<if test='maxGrade != null'> AND sc.grade &lt;= #{maxGrade} </if>"
            + "</script>")
    int getTotalCount(
            @Param("studentNo") String studentNo,
            @Param("courseNo") String courseNo,
            @Param("buyTextbook") String buyTextbook,
            @Param("minGrade") Float minGrade,
            @Param("maxGrade") Float maxGrade
    );
    @Select("SELECT s.student_id, s.student_name, sc.grade " +
            "FROM SC sc " +  // 使用 SC 表来查询选课信息
            "JOIN student s ON sc.student_no = s.student_no " +  // 关联学生表
            "WHERE sc.course_no = #{courseId}")  // 根据课程号筛选
    List<StudentGrade> findStudentsByCourseId(@Param("courseId") int courseId);
}

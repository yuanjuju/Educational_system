package com.example.mapper;

import com.example.pojo.SC;
import com.example.pojo.StudentGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SCMapper {



    List<SC> findStudentCourses(
            @Param("studentNo") String studentNo,
            @Param("courseNo") String courseNo,
            @Param("buyTextbook") String buyTextbook,
            @Param("minGrade") Float minGrade,
            @Param("maxGrade") Float maxGrade,
            @Param("offset") int offset,
            @Param("limit") int limit
    );



    int getTotalCount(
            @Param("studentNo") String studentNo,
            @Param("courseNo") String courseNo,
            @Param("buyTextbook") String buyTextbook,
            @Param("minGrade") Float minGrade,
            @Param("maxGrade") Float maxGrade
    );

    @Select("SELECT s.StudentID, s.Name, sc.grade " +
            "FROM sc " +  // 使用 SC 表来查询选课信息
            "JOIN student s ON sc.StudentID = s.Name " +  // 关联学生表
            "WHERE sc.CourseID = #{courseId}")  // 根据课程号筛选
    List<StudentGrade> findStudentsByCourseId(@Param("courseId") int courseId);
}

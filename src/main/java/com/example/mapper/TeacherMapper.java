package com.example.mapper;

import com.example.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where password=#{teacher_password} and teacher_no=#{teacher_no}")
    Teacher LoginTeacher(Teacher teacher);


    @Update("update teacher " +
            "set password=#{new_password} " +
            "where teacher_no=#{teacher_no} and password=#{teacher_password}")
    void UpdateTeacherPassword(Teacher teacher);

    @Select("<script>"
            + "SELECT * FROM teachers WHERE 1=1"
            + "<if test='teacherNo != null'> AND teacher_no LIKE CONCAT('%', #{teacherNo}, '%') </if>"
            + "<if test='teacherName != null'> AND teacher_name LIKE CONCAT('%', #{teacherName}, '%') </if>"
            + "<if test='teacherDept != null'> AND teacher_dept LIKE CONCAT('%', #{teacherDept}, '%') </if>"
            + "<if test='teacherPosition != null'> AND teacher_position = #{teacherPosition} </if>"
            + "LIMIT #{offset}, #{limit}"
            + "</script>")
    List<Teacher> findTeachers(
            @Param("teacherNo") String teacherNo,
            @Param("teacherName") String teacherName,
            @Param("teacherDept") String teacherDept,
            @Param("teacherPosition") String teacherPosition,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    @Select("<script>"
            + "SELECT COUNT(*) FROM teachers WHERE 1=1"
            + "<if test='teacherNo != null'> AND teacher_no LIKE CONCAT('%', #{teacherNo}, '%') </if>"
            + "<if test='teacherName != null'> AND teacher_name LIKE CONCAT('%', #{teacherName}, '%') </if>"
            + "<if test='teacherDept != null'> AND teacher_dept LIKE CONCAT('%', #{teacherDept}, '%') </if>"
            + "<if test='teacherPosition != null'> AND teacher_position = #{teacherPosition} </if>"
            + "</script>")
    int getTotalCount(
            @Param("teacherNo") String teacherNo,
            @Param("teacherName") String teacherName,
            @Param("teacherDept") String teacherDept,
            @Param("teacherPosition") String teacherPosition
    );
}

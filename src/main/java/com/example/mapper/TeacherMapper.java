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


    List<Teacher> findTeachers(
            @Param("teacherNo") String teacherNo,
            @Param("teacherName") String teacherName,
            @Param("teacherDept") String teacherDept,
            @Param("teacherPosition") String teacherPosition,
            @Param("offset") int offset,
            @Param("limit") int limit
    );


    int getTotalCount(
            @Param("teacherNo") String teacherNo,
            @Param("teacherName") String teacherName,
            @Param("teacherDept") String teacherDept,
            @Param("teacherPosition") String teacherPosition
    );


    @Select("select * from teacher where teacher_no=#{teacher_no}")
    List<Teacher> CheckteacherInfo(String teacher_no);


    List<Teacher> findTeachersByIds(@Param("teacherIDs")List<String> teacherIDs);
}

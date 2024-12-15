package com.example.mapper;

import com.example.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherMapper {

    @Select("select * from teacher where password=#{teacher_password} and teacher_no=#{teacher_no}")
    Teacher LoginTeacher(Teacher teacher);


    @Update("update teacher " +
            "set password=#{new_password} " +
            "where teacher_no=#{teacher_no} and password=#{teacher_password}")
    void UpdateTeacherPassword(Teacher teacher);
}

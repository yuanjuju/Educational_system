


# 查询外键约束
SELECT
    CONSTRAINT_NAME,
    TABLE_NAME,
    COLUMN_NAME
FROM
    INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE
    TABLE_SCHEMA = 'educational_system'  -- 替换为你的数据库名称
  AND REFERENCED_TABLE_NAME IS NOT NULL;


# 删除外键约束
ALTER TABLE courseschedule DROP FOREIGN KEY courseschedule_ibfk_1;


# 新增外键约束，级联删除
ALTER TABLE course
    ADD CONSTRAINT courseschedule_ibfk_1
        FOREIGN KEY (CourseID)
            REFERENCES course(CourseID)
            ON DELETE CASCADE;


CREATE INDEX idx_course_courseid ON course(CourseID);


ALTER TABLE course ADD COLUMN course_no VARCHAR(50) UNIQUE;


select * from teacher where password='123456' and teacher_no='20241218';


CREATE TABLE admin (
                       username VARCHAR(255),
                       password VARCHAR(255)
);

ALTER TABLE admin
    ADD CONSTRAINT pk_admin PRIMARY KEY (username);


ALTER TABLE admin
    ADD CONSTRAINT uq_admin_username UNIQUE (username);


ALTER TABLE admin
    ADD admin_no VARCHAR(255) UNIQUE;



select CourseName,Grade
        from sc,course
        where sc.CourseID=course.CourseID and StudentID=1
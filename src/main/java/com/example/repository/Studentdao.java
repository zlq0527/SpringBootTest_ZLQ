package com.example.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 09:25 2022/2/14
 * @ Description：
 */
@Mapper
public interface Studentdao extends BaseMapper<Student> {

}

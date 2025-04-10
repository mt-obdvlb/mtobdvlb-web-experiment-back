package com.mtobdvlb.mapper;

import com.github.pagehelper.Page;
import com.mtobdvlb.dto.UserPageQueryDTO;
import com.mtobdvlb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User getByUsername(String username);

    @Select("insert into user (username, password, birth_time, email, avatar) values (#{username}, #{password}, #{birthTime}, #{email}, #{avatar})")
    void insert(User user);

    void update(User user);

    @Select("select * from user where id = #{id}")
    User getById(Long id);

    Page<User> pageQuery(UserPageQueryDTO userPageQueryDTO);

    @Select("delete from user where id = #{id}")
    void delete(Long id);
}

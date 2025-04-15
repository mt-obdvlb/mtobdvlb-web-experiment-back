package com.mtobdvlb.mapper;

import com.github.pagehelper.Page;
import com.mtobdvlb.dto.ContactPageQueryDTO;
import com.mtobdvlb.entity.Contact;
import com.mtobdvlb.vo.ContactPageQueryVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ContactMapper {

    @Insert("insert into contact(name, province, city, address, postcode, date, user_id) values(#{name}, #{province}, #{city}, #{address}, #{postcode}, #{date}, #{userId})")
    void insert(Contact contact);

    @Select("select * from contact where id = #{id}")
    Contact getById(Long id);

    void update(Contact contact);

    @Delete("delete from contact where id = #{id}")
    void delete(Long id);

    Page<ContactPageQueryVO> pageQuery(ContactPageQueryDTO contactPageQueryDTO);
}

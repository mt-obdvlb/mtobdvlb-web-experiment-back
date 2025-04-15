package com.mtobdvlb.service;

import com.mtobdvlb.dto.ContactPageQueryDTO;
import com.mtobdvlb.entity.Contact;
import com.mtobdvlb.result.PageResult;

public interface ContactService {

    void save(Contact contact);

    Contact getById(Long id);

    void update(Contact contact);

    void delete(Long id);

    PageResult pageQuery(ContactPageQueryDTO contactPageQueryDTO);
}

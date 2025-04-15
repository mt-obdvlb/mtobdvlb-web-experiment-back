package com.mtobdvlb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mtobdvlb.constant.MessageConstant;
import com.mtobdvlb.dto.ContactPageQueryDTO;
import com.mtobdvlb.entity.Contact;
import com.mtobdvlb.entity.User;
import com.mtobdvlb.exception.ContactException;
import com.mtobdvlb.mapper.ContactMapper;
import com.mtobdvlb.mapper.UserMapper;
import com.mtobdvlb.result.PageResult;
import com.mtobdvlb.service.ContactService;
import com.mtobdvlb.vo.ContactPageQueryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(Contact contact) {
        User user = userMapper.getById(contact.getUserId());
        if(user == null) {
            throw new ContactException(MessageConstant.USER_NOT_EXIST);
        }
        contactMapper.insert(contact);
    }

    @Override
    public Contact getById(Long id) {
        Contact contact = contactMapper.getById(id);
        if(contact == null) {
            throw new ContactException(MessageConstant.CONTACT_NOT_EXIST);
        }
        return contact;
    }

    @Override
    public void update(Contact contact) {
        if(contactMapper.getById(contact.getId()) == null) {
            throw new ContactException(MessageConstant.CONTACT_NOT_EXIST);
        }
        contactMapper.update(contact);
    }

    @Override
    public void delete(Long id) {
        Contact contact = contactMapper.getById(id);
        if(contact == null) {
            throw new ContactException(MessageConstant.CONTACT_NOT_EXIST);
        }
        contactMapper.delete(id);
    }

    @Override
    public PageResult pageQuery(ContactPageQueryDTO contactPageQueryDTO) {
        PageHelper.startPage(contactPageQueryDTO.getPage(), contactPageQueryDTO.getPageSize());
        Page<ContactPageQueryVO> page = contactMapper.pageQuery(contactPageQueryDTO);
        long total = page.getTotal();
        List<ContactPageQueryVO> records = page.getResult();
        return new PageResult(total, records);
    }


}

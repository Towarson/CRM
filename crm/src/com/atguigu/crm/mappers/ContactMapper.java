package com.atguigu.crm.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Contact;
public interface ContactMapper {

	void saveContact(Contact contact);

	int getTotalRecordNo(@Param("id") Long id);

	List<Contact> getPageList(@Param("id") Long id,@Param("firstIndex")int firstIndex, @Param("endIndex")int endIndex);

	void delete(@Param("id") Long id);

	Contact get(@Param("id") Long id);

	void update(Contact contact);

	void save(Contact contact);
	
}

package space.nicxia.dao;

import space.nicxia.dto.ContactVo;
import space.nicxia.entity.Contact;
import space.nicxia.entity.ContactInfo;

import java.util.List;


public interface ContactDao {

    public ContactVo getContactVoByContactId(int contactId);

    public List<Integer> getContactIdsByUserId(int userId);

    public void insertContactByContact(Contact contact);

    public void updateContactByContact(Contact contact);

    public void deleteContactByContact(Contact contact);

    public void insertContactInfoByContactInfo(ContactInfo contactInfo);

    public void updateContactInfoByContactInfo(ContactInfo contactInfo);

    public void deleteContactInfoByContactInfo(ContactInfo contactInfo);//根据ContactId和电话号码

}

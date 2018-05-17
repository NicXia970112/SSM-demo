package space.nicxia.dto;

import space.nicxia.entity.Contact;
import space.nicxia.entity.ContactInfo;

import java.util.List;

public class ContactVo {

    private Contact contact;

    private List<ContactInfo> contactInfos;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public void setContactInfos(List<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
    }

}

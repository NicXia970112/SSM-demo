package space.nicxia.entity;

public class ContactInfo {

    private int contactId;

    private int contactInfoId;

    private String contactUserName;

    private String contactUserTel;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(int contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public String getContactUserName() {
        return contactUserName;
    }

    public void setContactUserName(String contactUserName) {
        this.contactUserName = contactUserName;
    }

    public String getContactUserTel() {
        return contactUserTel;
    }

    public void setContactUserTel(String contactUserTel) {
        this.contactUserTel = contactUserTel;
    }

}

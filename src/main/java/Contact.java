public class Contact {

    public String name;
    public String surName;
    public final String phone;
    public Group group;

    public Contact(String name, String surName, String phone, Group group) {
        this.name = name;
        this.surName = surName;
        this.phone = phone;
        this.group = group;
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !object.getClass().equals(Contact.class)) return false;
        Contact contact = (Contact) object;
        return name.equals(contact.name) && surName.equals(contact.surName) && phone.equals(contact.phone) && group.equals(contact.group);
    }
}
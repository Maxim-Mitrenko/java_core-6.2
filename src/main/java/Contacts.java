import java.util.HashMap;

public class Contacts {

    protected HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact (String surname, String name, String phone, Group group) {
        contacts.put(phone, new Contact(name, surname, phone, group));
    }

    public void addContact(Contact contact) {
        contacts.put(contact.phone, contact);
    }

    public void removeContact(String surName, String name) {
        for (HashMap.Entry<String, Contact> entry : contacts.entrySet()) {
            Contact contact = entry.getValue();
            if (contact.name.equals(name) && contact.surName.equals(surName)) {
                contacts.remove(entry.getKey());
                break;
            }
        }
    }

    public Contact searchContact (String phone) {
        return contacts.get(phone);
    }

    public void changeContact(String surname, String name, String phone, Group group) {
        Contact contact = contacts.get(phone);
        contact.name = surname;
        contact.surName = surname;
        contact.group = group;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (HashMap.Entry<String, Contact> entry : contacts.entrySet()) {
            string.append( entry.getKey() + " " + entry.getValue());
        }
        return string.toString();
    }
}
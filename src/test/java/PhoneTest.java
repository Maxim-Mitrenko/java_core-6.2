import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

public class PhoneTest {

    Contacts contacts;
    MissedCalls missedCalls;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Tests Started");
    }

    @BeforeEach
    public void beforeEach() {
        contacts = new Contacts();
        missedCalls = new MissedCalls();
        System.out.println("Test started");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Tests completed");
    }

    @Test
    public void addMissCals() {
        //arrange
        LocalDateTime time = LocalDateTime.now();
        String number1 = "+7(999)-999-99-99";

        //act
        missedCalls.addMissCals(time, number1);

        //assert
        MatcherAssert.assertThat(missedCalls.missCalls, Matchers.hasEntry(time, number1));
    }

    @Test
    public void addMissCallsWithContact() {
        //arrange
        Contact contact = new Contact("Иван", "Иванов", "+79999999999", Group.WORK);
        LocalDateTime time = LocalDateTime.now();
        String excepted = "Иван Иванов";

        //act
        missedCalls.addMissCals(time, contact);

        //assert
        MatcherAssert.assertThat(missedCalls.missCalls, Matchers.hasEntry(time, excepted));
    }

    @Test
    public void addContacts() {
        //arrange
        Contact contact1 = new Contact("Иван", "Иванов", "+79999999999", Group.FRIENDS);
        Contact contact2 = new Contact("Петр", "Петров", "+79889889898", Group.FRIENDS);
        Contact contact3 = new Contact("Сергей", "Семенов", "+79879879887", Group.FRIENDS);

        //aсt
        contacts.addContact("Иванов", "Иван", "+79999999999", Group.FRIENDS);
        contacts.addContact("Петров", "Петр", "+79889889898", Group.FRIENDS);
        contacts.addContact(contact3);

        //arrange
        MatcherAssert.assertThat(contacts.contacts, Matchers.hasEntry(contact1.phone, contact1));
        MatcherAssert.assertThat(contacts.contacts, Matchers.hasEntry(contact2.phone, contact2));
        MatcherAssert.assertThat(contacts.contacts, Matchers.hasKey(contact3.phone));
        MatcherAssert.assertThat(contacts.contacts, Matchers.hasValue(contact3));
    }
}
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationTest {

    UserRegistration form;

    @BeforeEach
    void setUp() {
        form = new UserRegistration();
    }

    @AfterEach
    void tearDown() {
        form = null;
    }


    @Test
    void test01_ValidRegistration() {

        String result = form.register("Ali", "Yılmaz", "ali@test.com", "01/01/1990", "123456", "123456");
        assertEquals("SUCCESS", result);
    }


    @Test
    void test02_EmptyFirstName() {
        String result = form.register("", "Yılmaz", "ali@test.com", "01/01/1990", "123456", "123456");
        assertEquals("ERROR_NAME_EMPTY", result);
    }

    @Test
    void test03_NullFirstName() {
        String result = form.register(null, "Yılmaz", "ali@test.com", "01/01/1990", "123456", "123456");
        assertEquals("ERROR_NAME_EMPTY", result);
    }

    @Test
    void test04_EmptyLastName() {
        String result = form.register("Ali", "", "ali@test.com", "01/01/1990", "123456", "123456");
        assertEquals("ERROR_LASTNAME_EMPTY", result);
    }

    @Test
    void test05_NullLastName() {
        String result = form.register("Ali", null, "ali@test.com", "01/01/1990", "123456", "123456");
        assertEquals("ERROR_LASTNAME_EMPTY", result);
    }


    @Test
    void test06_EmailWithoutAtSign() {
        String result = form.register("Ali", "Yılmaz", "alitest.com", "01/01/1990", "123456", "123456");
        assertEquals("ERROR_INVALID_EMAIL", result);
    }

    @Test
    void test07_EmailWithoutDot() {
        String result = form.register("Ali", "Yılmaz", "ali@testcom", "01/01/1990", "123456", "123456");
        assertEquals("ERROR_INVALID_EMAIL", result);
    }

    @Test
    void test08_NullEmail() {
        String result = form.register("Ali", "Yılmaz", null, "01/01/1990", "123456", "123456");
        assertEquals("ERROR_INVALID_EMAIL", result);
    }


    @Test
    void test09_PasswordTooShort_BVA() {
        // BVA (Sınır Değer): Şifre en az 6 karakter olmalı. Biz 5 girdik (Sınırın bir altı)
        String result = form.register("Ali", "Yılmaz", "ali@test.com", "01/01/1990", "12345", "12345");
        assertEquals("ERROR_PASSWORD_TOO_SHORT", result);
    }
}


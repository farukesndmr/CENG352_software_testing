public class UserRegistration {

    // Kayıt formundaki verileri alıp kontrol eden ana metodumuz
    public String register(String firstName, String lastName, String email, String dob, String password, String confirmPassword) {

        // 1. İsim ve Soyisim Kontrolü (Boş olamaz)
        if (firstName == null || firstName.trim().isEmpty()) {
            return "ERROR_NAME_EMPTY";
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            return "ERROR_LASTNAME_EMPTY";
        }

        // 2. E-posta Kontrolü (@ ve . içermeli)
        if (email == null || !email.contains("@") || !email.contains(".")) {
            return "ERROR_INVALID_EMAIL";
        }

        // 3. Şifre Uzunluk Kontrolü (Sınır Değer Analizi - BVA için 6 karakter sınırı koyduk)
        if (password == null || password.length() < 6) {
            return "ERROR_PASSWORD_TOO_SHORT";
        }

        // 4. Şifre Eşleşme Kontrolü
        if (!password.equals(confirmPassword)) {
            return "ERROR_PASSWORD_MISMATCH";
        }

        // 5. Doğum Tarihi Format Kontrolü (Basit bir uzunluk kontrolü - dd/mm/yyyy = 10 karakter)
        if (dob == null || dob.length() != 10) {
            return "ERROR_INVALID_DATE_FORMAT";
        }

        // Her şey doğruysa başarılı mesajı dön
        return "SUCCESS";
    }
}
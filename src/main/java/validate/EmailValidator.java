package validate;

import javax.xml.validation.Validator;

public class EmailValidator {

    public boolean validate(String email) {
        if ((email.length() < 4) || !email.contains("@") || !email.contains(".")) {
            return false; // "Please enter a valid email"
        }
        return true;
    }

}

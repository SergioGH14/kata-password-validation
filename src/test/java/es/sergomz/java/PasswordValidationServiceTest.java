package es.sergomz.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidationServiceTest {
    private final PasswordValidationService passwordValidation = new PasswordValidationService();

    @Test
    @DisplayName("it returns false if the password has less than 8 characters")
    public void lessThanEightCharacters(){
        String password = generatePassword();
        boolean validation = passwordValidation.validate(password);
        assertFalse(validation);
    }

    private String generatePassword(){
        return "-------";
    }

}
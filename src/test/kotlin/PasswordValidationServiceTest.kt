import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.lang.StringBuilder
import kotlin.test.assertFalse

class PasswordValidationServiceTest {

    @Test
    fun `it returns true if the password is well formed`() {
        val password = password()
        val validation = passwordValidation.validate(password)
        assertTrue(validation)
    }

    @Test
    fun `it returns false if the password has less than 8 characters`() {
        val password = password(7)
        val validation = passwordValidation.validate(password)
        assertFalse(validation)
    }


    @Test
    fun `it returns false if the password doesn't contains a capital letter`() {
        val password = password(upperCase = 0)
        val validation = passwordValidation.validate(password)
        assertFalse(validation)
    }

    @Test
    fun `it returns false if the password doesn't contains a lower case letter`() {
        val password = password(lowerCase = 0)
        val validation = passwordValidation.validate(password)
        assertFalse(validation)
    }

    @Test
    fun `it returns false if the password doesn't contains a digit`() {
        val password = password(digits = 0)
        val validation = passwordValidation.validate(password)
        assertFalse(validation)
    }

    @Test
    fun `it returns false if the password doesn't contains an underscore`() {
        val password = password(digits = 0)
        val validation = passwordValidation.validate(password)
        assertFalse(validation)
    }


    private fun password(
        characters: Int = 8,
        upperCase: Int = 1,
        lowerCase: Int = 1,
        digits: Int = 1,
        underscores: Int = 1,
    ): String {
        val password = StringBuilder()
        repeat(upperCase) { addUpperCaseLetter(password) }
        repeat(lowerCase) { addLowerCaseLetter(password) }
        repeat(digits) { addDigit(password) }
        repeat(underscores) { addUnderscores(password) }
        repeat(characters - (upperCase + lowerCase + digits + underscores)) { addSymbol(password) }
        return password.toString()
    }

    private fun addUnderscores(password: StringBuilder) {
        password.append("_")
    }

    private fun addSymbol(password: StringBuilder) {
        password.append("-")
    }

    private fun addUpperCaseLetter(password: StringBuilder) {
        password.append("A")
    }

    private fun addLowerCaseLetter(password: StringBuilder) {
        password.append("a")
    }

    private fun addDigit(password: StringBuilder) {
        password.append("1")
    }

    private val passwordValidation = PasswordValidationService()
}
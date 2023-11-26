class PasswordValidationService(private val validations: List<Validator>) {
    fun validate(password: String): Boolean {
        return validations.map { it.validate(password) }.none { !it.isValid }
    }

}

class LengthValidator(private val length: Int) : Validator {
    override fun validate(input: String) =
        ValidationResult(input.length >= length, "Minimum length is $length")

}

class HasUpperCaseValidator : Validator {
    override fun validate(input: String) =
        ValidationResult(input.any { it.isUpperCase() }, "At least one upper case is required")

}

class HasLowerCaseValidator : Validator {
    override fun validate(input: String) =
        ValidationResult(input.any { it.isLowerCase() }, "At least one lower case is required")

}

class HasDigitValidator : Validator {
    override fun validate(input: String) =
        ValidationResult(input.any { it.isDigit() }, "At least one digit case is required")

}

class HasUnderScoresValidator : Validator {
    override fun validate(input: String) =
        ValidationResult(input.any { it == '_' }, "At least one digit case is required")

}
package es.sergomz.kotlin

class PasswordValidationService(private val validations: List<Validator>) {

    companion object {
        val VALIDATION_1 = listOf(
            LengthValidator(8),
            HasUpperCaseValidator(),
            HasLowerCaseValidator(),
            HasDigitValidator(),
            HasUnderScoresValidator(),
        )

        val VALIDATION_2 = listOf(
            LengthValidator(6),
            HasUpperCaseValidator(),
            HasLowerCaseValidator(),
            HasDigitValidator(),
        )

        val VALIDATION_3 = listOf(
            LengthValidator(16),
            HasUpperCaseValidator(),
            HasLowerCaseValidator(),
            HasUnderScoresValidator(),
        )
    }

    fun validate(password: String): Boolean {
        return validations.map { it.validate(password) }.none { !it.isValid }
    }

}

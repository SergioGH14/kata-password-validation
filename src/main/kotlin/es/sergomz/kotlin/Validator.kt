package es.sergomz.kotlin

interface Validator {

    fun validate(input: String): ValidationResult

}
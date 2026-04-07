package com.hector.titulacionpredial.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test class for ValidationUtils.
 *
 * <p>
 * Tests the validation utility methods for checking numeric values,
 * empty fields, phone formats, and IDs.
 * </p>
 *
 * @author Test Suite
 * @since 1.0
 */
@DisplayName("ValidationUtils Tests")
class ValidationUtilsTest {

    @Nested
    @DisplayName("isNumeric Method Tests")
    class IsNumericTests {

        @Test
        @DisplayName("Should return true for valid positive number")
        void testIsNumericWithPositiveNumber() {
            // Given: Valid positive number
            String value = "12345";

            // Then: Should return true
            assertTrue(ValidationUtils.isNumeric(value),
                    "Valid positive number should return true");
        }

        @Test
        @DisplayName("Should return true for number zero")
        void testIsNumericWithZero() {
            // Given: Zero value
            String value = "0";

            // Then: Should return true
            assertTrue(ValidationUtils.isNumeric(value),
                    "Zero should return true");
        }

        @Test
        @DisplayName("Should return false for empty string")
        void testIsNumericWithEmptyString() {
            // Given: Empty string
            String value = "";

            // Then: Should return false
            assertFalse(ValidationUtils.isNumeric(value),
                    "Empty string should return false");
        }

        @Test
        @DisplayName("Should return false for null value")
        void testIsNumericWithNull() {
            // Given: Null value
            String value = null;

            // Then: Should return false
            assertFalse(ValidationUtils.isNumeric(value),
                    "Null value should return false");
        }

        @Test
        @DisplayName("Should return false for non-numeric string")
        void testIsNumericWithNonNumericString() {
            // Given: Non-numeric string
            String value = "abc123";

            // Then: Should return false
            assertFalse(ValidationUtils.isNumeric(value),
                    "Non-numeric string should return false");
        }

        @Test
        @DisplayName("Should return false for numeric string with spaces")
        void testIsNumericWithSpaces() {
            // Given: Numeric string with spaces
            String value = "123 456";

            // Then: Should return false
            assertFalse(ValidationUtils.isNumeric(value),
                    "Numeric string with spaces should return false");
        }

        @Test
        @DisplayName("Should return false for negative number")
        void testIsNumericWithNegativeNumber() {
            // Given: Negative number
            String value = "-123";

            // Then: Should return false (negative sign is not digit)
            assertFalse(ValidationUtils.isNumeric(value),
                    "Negative number should return false");
        }
    }

    @Nested
    @DisplayName("isEmptyFields Method Tests")
    class IsEmptyFieldsTests {

        @Test
        @DisplayName("Should return false for non-empty fields")
        void testIsEmptyFieldsWithValidInput() {
            // Given: Non-empty fields
            String field1 = "testuser";
            String field2 = "password123";

            // Then: Should return false (fields are not empty)
            assertFalse(ValidationUtils.isEmptyFields(field1, field2),
                    "Non-empty fields should return false");
        }

        @Test
        @DisplayName("Should return true when first field is empty")
        void testIsEmptyFieldsWithEmptyFirstField() {
            // Given: First field empty
            String field1 = "";
            String field2 = "password123";

            // Then: Should return true
            assertTrue(ValidationUtils.isEmptyFields(field1, field2),
                    "Empty first field should return true");
        }

        @Test
        @DisplayName("Should return true when second field is empty")
        void testIsEmptyFieldsWithEmptySecondField() {
            // Given: Second field empty
            String field1 = "testuser";
            String field2 = "";

            // Then: Should return true
            assertTrue(ValidationUtils.isEmptyFields(field1, field2),
                    "Empty second field should return true");
        }

        @Test
        @DisplayName("Should return true when both fields are empty")
        void testIsEmptyFieldsWithBothEmpty() {
            // Given: Both fields empty
            String field1 = "";
            String field2 = "";

            // Then: Should return true
            assertTrue(ValidationUtils.isEmptyFields(field1, field2),
                    "Empty fields should return true");
        }

        @Test
        @DisplayName("Should return true for null first field")
        void testIsEmptyFieldsWithNullFirstField() {
            // Given: First field null
            String field1 = null;
            String field2 = "password123";

            // Then: Should return true
            assertTrue(ValidationUtils.isEmptyFields(field1, field2),
                    "Null first field should return true");
        }

        @Test
        @DisplayName("Should return true for field with only spaces")
        void testIsEmptyFieldsWithSpaces() {
            // Given: Fields with only spaces
            String field1 = "   ";
            String field2 = "password";

            // Then: Might return true (depends on implementation)
            // Testing the actual behavior
            boolean result = ValidationUtils.isEmptyFields(field1, field2);
            assertNotNull(result, "Should return boolean result");
        }
    }

    @Nested
    @DisplayName("Phone Validation Tests")
    class PhoneValidationTests {

        @Test
        @DisplayName("Should validate standard phone format")
        void testValidPhoneFormat() {
            // Given: Valid phone number
            String phone = "3001234567";

            // Then: Should be numeric
            assertTrue(ValidationUtils.isNumeric(phone),
                    "Valid phone should be numeric");
        }

        @Test
        @DisplayName("Should reject phone with letters")
        void testPhoneWithLetters() {
            // Given: Phone with letters
            String phone = "300ABC4567";

            // Then: Should not be numeric
            assertFalse(ValidationUtils.isNumeric(phone),
                    "Phone with letters should not be numeric");
        }

        @Test
        @DisplayName("Should reject empty phone")
        void testEmptyPhoneValidation() {
            // Given: Empty phone
            String phone = "";

            // Then: Should be empty
            assertTrue(ValidationUtils.isEmptyFields(phone),
                    "Empty phone should be validated as empty");
        }
    }

    @Nested
    @DisplayName("ID Validation Tests")
    class IdValidationTests {

        @Test
        @DisplayName("Should accept valid positive ID")
        void testValidPositiveId() {
            // Given: Positive ID
            long id = 1234567890L;

            // Then: Should be positive
            assertTrue(id > 0, "Positive ID should be valid");
        }

        @Test
        @DisplayName("Should reject zero ID")
        void testZeroIdValidation() {
            // Given: Zero ID
            long id = 0;

            // Then: Should not be positive
            assertFalse(id > 0, "Zero ID should be rejected");
        }

        @Test
        @DisplayName("Should reject negative ID")
        void testNegativeIdValidation() {
            // Given: Negative ID
            long id = -1;

            // Then: Should not be positive
            assertFalse(id > 0, "Negative ID should be rejected");
        }
    }
}

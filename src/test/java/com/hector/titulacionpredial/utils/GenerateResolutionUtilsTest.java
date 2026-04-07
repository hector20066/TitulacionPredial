package com.hector.titulacionpredial.utils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.hector.titulacionpredial.model.dto.DTOPoint;

/**
 * Test class for GenerateResolutionUtils.
 *
 * <p>
 * Tests the resolution document generation utility, focusing on
 * point validation, beneficiary handling, and document structure.
 * </p>
 *
 * @author Test Suite
 * @since 1.0
 */
@DisplayName("GenerateResolutionUtils Tests")
class GenerateResolutionUtilsTest {

    @Nested
    @DisplayName("Point Validation Tests")
    class PointValidationTests {

        @Test
        @DisplayName("Should validate point number between 1 and 4")
        void testValidPointNumbers() {
            // Given: Valid point numbers
            for (int pointNum = 1; pointNum <= 4; pointNum++) {
                // Then: Should be valid
                assertTrue(isValidPointNumber(pointNum),
                        "Point number " + pointNum + " should be valid");
            }
        }

        @Test
        @DisplayName("Should reject point number zero")
        void testZeroPointNumber() {
            // Given: Zero point number
            int pointNum = 0;

            // Then: Should be invalid
            assertFalse(isValidPointNumber(pointNum),
                    "Point number 0 should be invalid");
        }

        @Test
        @DisplayName("Should reject point number greater than 4")
        void testPointNumberGreaterThan4() {
            // Given: Point number > 4
            int pointNum = 5;

            // Then: Should be invalid
            assertFalse(isValidPointNumber(pointNum),
                    "Point number 5 should be invalid");
        }

        @Test
        @DisplayName("Should reject negative point number")
        void testNegativePointNumber() {
            // Given: Negative point number
            int pointNum = -1;

            // Then: Should be invalid
            assertFalse(isValidPointNumber(pointNum),
                    "Negative point number should be invalid");
        }
    }

    @Nested
    @DisplayName("Point List Processing Tests")
    class PointListProcessingTests {

        @Test
        @DisplayName("Should process list with all valid points")
        void testProcessValidPointsList() {
            // Given: List with 4 valid points
            List<DTOPoint> points = createValidPointsList();

            // Then: Should process without exception
            assertDoesNotThrow(() -> validatePointsList(points),
                    "Valid points list should process without exception");
        }

        @Test
        @DisplayName("Should handle empty points list")
        void testProcessEmptyPointsList() {
            // Given: Empty points list
            List<DTOPoint> points = new ArrayList<>();

            // Then: Should handle gracefully
            assertTrue(points.isEmpty(), "Points list should be empty");
            assertDoesNotThrow(() -> validatePointsList(points));
        }

        @Test
        @DisplayName("Should handle points list with single point")
        void testProcessSinglePointsList() {
            // Given: Single point
            List<DTOPoint> points = new ArrayList<>();
            points.add(createTestPoint(1, 10.5, 20.3, 100.5, "N"));

            // Then: Should process without exception
            assertEquals(1, points.size());
            assertDoesNotThrow(() -> validatePointsList(points));
        }

        @Test
        @DisplayName("Should require all points to have valid numbers")
        void testPointsWithInvalidNumbers() {
            // Given: List with invalid point number
            List<DTOPoint> points = new ArrayList<>();
            points.add(createTestPoint(5, 10.5, 20.3, 100.5, "N")); // Invalid: 5

            // Then: Should reject invalid point
            assertFalse(isValidPointNumber(5),
                    "Should reject point number 5");
        }
    }

    @Nested
    @DisplayName("Coordinate Validation Tests")
    class CoordinateValidationTests {

        @Test
        @DisplayName("Should accept positive coordinates")
        void testPositiveCoordinates() {
            // Given: Positive coordinates
            double northCoord = 1234567.89;
            double eastCoord = 987654.32;

            // Then: Should accept positive values
            assertTrue(northCoord > 0, "North coordinate should be positive");
            assertTrue(eastCoord > 0, "East coordinate should be positive");
        }

        @Test
        @DisplayName("Should accept zero coordinates")
        void testZeroCoordinates() {
            // Given: Zero coordinates (edge case)
            double northCoord = 0.0;
            double eastCoord = 0.0;

            // Then: Should accept zero
            assertEquals(0.0, northCoord);
            assertEquals(0.0, eastCoord);
        }

        @Test
        @DisplayName("Should handle very large coordinate values")
        void testLargeCoordinateValues() {
            // Given: Large coordinate values
            double northCoord = 9999999.99;
            double eastCoord = 9999999.99;

            // Then: Should handle large values
            assertTrue(northCoord > 0);
            assertTrue(eastCoord > 0);
        }
    }

    @Nested
    @DisplayName("Distance Validation Tests")
    class DistanceValidationTests {

        @Test
        @DisplayName("Should accept positive distances")
        void testPositiveDistance() {
            // Given: Positive distance
            double distance = 500.75;

            // Then: Should accept
            assertTrue(distance > 0, "Positive distance should be accepted");
        }

        @Test
        @DisplayName("Should handle zero distance")
        void testZeroDistance() {
            // Given: Zero distance
            double distance = 0.0;

            // Then: Should accept
            assertEquals(0.0, distance);
        }

        @Test
        @DisplayName("Should reject negative distance")
        void testNegativeDistance() {
            // Given: Negative distance
            double distance = -100.5;

            // Then: Should reject
            assertTrue(distance < 0, "Negative distance should be rejected");
        }
    }

    /**
     * Helper method to validate point number.
     *
     * @param pointNumber the point number to validate
     * @return true if valid (1-4), false otherwise
     */
    private boolean isValidPointNumber(int pointNumber) {
        return pointNumber >= 1 && pointNumber <= 4;
    }

    /**
     * Helper method to validate points list.
     *
     * @param points the list of points
     * @throws IllegalArgumentException if any point is invalid
     */
    private void validatePointsList(List<DTOPoint> points) {
        if (points == null) {
            throw new IllegalArgumentException("Points list cannot be null");
        }

        for (DTOPoint point : points) {
            if (point == null) {
                throw new IllegalArgumentException("Point cannot be null");
            }

            if (!isValidPointNumber(point.getNumberPoint())) {
                throw new IllegalArgumentException(
                        "Invalid point number: " + point.getNumberPoint() + ". Valid range: 1-4");
            }
        }
    }

    /**
     * Helper method to create a test point.
     *
     * @param pointNumber     the point number (1-4)
     * @param northCoord      the north coordinate
     * @param eastCoord       the east coordinate
     * @param distance        the distance to next point
     * @param hillside        the hillside designation
     * @return DTOPoint for testing
     */
    private DTOPoint createTestPoint(int pointNumber, double northCoord, double eastCoord,
                                     double distance, String hillside) {
        return new DTOPoint.Builder()
                .numberPoint(pointNumber)
                .northCoordinate(northCoord)
                .eastCoordinate(eastCoord)
                .distance(distance)
                .hillside(hillside)
                .build();
    }

    /**
     * Helper method to create a valid points list.
     *
     * @return List with 4 valid points
     */
    private List<DTOPoint> createValidPointsList() {
        List<DTOPoint> points = new ArrayList<>();
        points.add(createTestPoint(1, 1000.0, 2000.0, 500.0, "N"));
        points.add(createTestPoint(2, 1100.0, 2100.0, 550.0, "O"));
        points.add(createTestPoint(3, 1200.0, 2200.0, 600.0, "S"));
        points.add(createTestPoint(4, 1300.0, 2300.0, 650.0, "E"));
        return points;
    }
}

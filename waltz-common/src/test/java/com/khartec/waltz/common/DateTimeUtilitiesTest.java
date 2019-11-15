/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017 Waltz open source project
 * See README.md for more information
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.khartec.waltz.common;

import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;

public class DateTimeUtilitiesTest {

    @Test
    public void dateTimeConversionsReturnNullIfGivenNull() {
        assertNull(DateTimeUtilities.toSqlDate((Date) null));
        assertNull(DateTimeUtilities.toSqlDate((LocalDate) null));
        assertNull(DateTimeUtilities.toLocalDateTime(null));
        assertNull(DateTimeUtilities.toLocalDate(null));
    }

    @Test
    public void nowUtcTest() throws Exception {
        // Arrange and Act
        LocalDateTime actual = DateTimeUtilities.nowUtc();

        // Assert
        assertEquals(2019, actual.getYear());
    }

    @Test
    public void nowUtcTimestampTest() throws Exception {
        // Arrange and Act
        Timestamp actual = DateTimeUtilities.nowUtcTimestamp();

        // Assert
        assertEquals(119, actual.getYear());
    }

    @Test
    public void toLocalDateTest() throws Exception {
        // Arrange
        java.util.Date date = new java.util.Date(1L);

        // Act
        LocalDate actual = DateTimeUtilities.toLocalDate(date);

        // Assert
        assertEquals(1970, actual.getYear());
    }

    @Test
    public void toLocalDateTest2() throws Exception {
        // Arrange
        Timestamp timestamp = new Timestamp(1L);

        // Act
        LocalDate actual = DateTimeUtilities.toLocalDate(timestamp);

        // Assert
        assertEquals(1970, actual.getYear());
    }

    @Test
    public void toLocalDateTimeTest() throws Exception {
        // Arrange
        java.util.Date date = new java.util.Date(1L);

        // Act
        LocalDateTime actual = DateTimeUtilities.toLocalDateTime(date);

        // Assert
        assertEquals(1970, actual.getYear());
    }

    @Test
    public void toSqlDateTest() throws Exception {
        // Arrange
        java.util.Date date = new java.util.Date(1L);

        // Act
        java.sql.Date actual = DateTimeUtilities.toSqlDate(date);

        // Assert
        assertEquals(70, actual.getYear());
    }

    @Test
    public void toSqlDateTest2() throws Exception {
        // Arrange
        LocalDate localDate = null;

        // Act
        Date actual = DateTimeUtilities.toSqlDate(localDate);

        // Assert
        assertEquals(null, actual);
    }

    @Test
    public void todayTest() throws Exception {
        // Arrange and Act
        LocalDate actual = DateTimeUtilities.today();

        // Assert
        assertEquals(2019, actual.getYear());
    }

}

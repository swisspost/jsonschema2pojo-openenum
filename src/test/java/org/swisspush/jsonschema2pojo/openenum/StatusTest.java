package org.swisspush.jsonschema2pojo.openenum;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatusTest {
    @Test
    public void testOpenEnumPattern() {
        assertSame(Status.CLOSED, Status.fromString("CLOSED"));
        assertNotSame(Status.CLOSED, Status.OPEN);
        assertNotSame(Status.CLOSED, Status.fromString("OTHER"));
        assertEquals(Status.OPEN.toString(), "OPEN");
    }

    @Test
    public void isDeclaredValue() {
        assertTrue(Status.isDeclaredValue(Status.OPEN));
        assertTrue(Status.isDeclaredValue(Status.CLOSED));
        assertTrue(Status.isDeclaredValue(Status.fromString("OPEN")));
        assertTrue(Status.isDeclaredValue(Status.fromString("CLOSED")));
        assertFalse(Status.isDeclaredValue(Status.fromString("NOT_DECLARED_VALUE")));
        assertFalse(Status.isDeclaredValue(Status.fromString("OTHER")));
    }

    @Test
    public void isNotDeclaredValue() {
        assertFalse(Status.isNotDeclaredValue(Status.OPEN));
        assertFalse(Status.isNotDeclaredValue(Status.CLOSED));
        assertFalse(Status.isNotDeclaredValue(Status.fromString("OPEN")));
        assertFalse(Status.isNotDeclaredValue(Status.fromString("CLOSED")));
        assertTrue(Status.isNotDeclaredValue(Status.fromString("NOT_DECLARED_VALUE")));
        assertTrue(Status.isNotDeclaredValue(Status.fromString("OTHER")));
    }
}

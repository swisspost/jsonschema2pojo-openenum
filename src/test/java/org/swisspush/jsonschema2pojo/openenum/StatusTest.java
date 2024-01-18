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
    public void declaredValuesIsNotAffectedByFromStringCalls() {
        assertEquals(2, Status.declaredValues.size());
        Status.fromString("OTHER");
        assertEquals(2, Status.declaredValues.size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void declaredValuesIsNotModifiable() {
        Status.declaredValues.add(Status.fromString("UNKNOWN"));
    }

    @Test
    public void iterateDeclaredValues() {
        Status.declaredValues.forEach(System.out::println);
    }

    @Test
    public void isDeclaredValue() {
        assertTrue(Status.OPEN.isDeclaredValue());
        assertTrue(Status.CLOSED.isDeclaredValue());
        assertTrue(Status.fromString("OPEN").isDeclaredValue());
        assertTrue(Status.fromString("CLOSED").isDeclaredValue());
        assertFalse(Status.fromString("NOT_DECLARED_VALUE").isDeclaredValue());
        assertFalse(Status.fromString("OTHER").isDeclaredValue());
    }
}

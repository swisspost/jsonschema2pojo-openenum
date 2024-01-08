package org.swisspush.jsonschema2pojo.openenum;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class Status {

    private final static Map<String, Status> values = new HashMap<String, Status>();
    public final static Status OPEN = Status.fromString("OPEN");
    public final static Status CLOSED = Status.fromString("CLOSED");
    /**
     * Set containing all enum values declared at compile time.use it in your application to iterate over declared values.
     *
     */
    public final static Set<Status> declaredValues = new HashSet<Status>(Arrays.asList(Status.OPEN, Status.CLOSED));
    private String value;

    private Status(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Status fromString(String s) {
        values.putIfAbsent(s, new Status(s));
        return values.get(s);
    }

    @Override
    @JsonValue
    public String toString() {
        return this.value;
    }

    /**
     * returns true if given enum is part of the declared values.use it in your application to detect when values coming from outside of the app are not yet part of the declared values (i.e.: there is a new version of the enum that your application is not yet aware of.
     *
     */
    public static Boolean isDeclaredValue(Status val) {
        return Status.declaredValues.contains(val);
    }

    /**
     * returns true if given enum is NOT part of the declared values.use it in your application to detect when values coming from outside of the app are not yet part of the declared values (i.e.: there is a new version of the enum that your application is not yet aware of.
     *
     */
    public static Boolean isNotDeclaredValue(Status val) {
        return !isDeclaredValue(val);
    }
}
package org.launchcode.techjobs_oo;

import java.util.Objects;

public class JobDataLine {
    private int id;
    private static int nextId = 1;
    private String value;

    public JobDataLine() {
        id = nextId;
        nextId++;
    }

    public JobDataLine(String value) {
        this();
        if (value.equals("")) {
            this.value = "Data not available";
        } else {
            this.value = value;
        }
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package org.launchcode.techjobs_oo.Tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static Job jobOne;
    private static Job jobTwo;
    private static Job testJob;
    private static Job testJobCopy;
    private static Job emptyFieldTestJob;

    @BeforeClass
    public static void createJobObjects() {
        jobOne = new Job();
        jobTwo = new Job();
        testJob = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        testJobCopy = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        emptyFieldTestJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1, (jobTwo.getId() - jobOne.getId()), 0.001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJob.getName() instanceof String);
        assertEquals("Product Tester", testJob.getName());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality Control", testJob.getPositionType().getValue());
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob.equals(testJobCopy));
    }

    @Test
    public void testToStringFormat() {
        assertEquals("/nID: 3/nName: Product Tester/nEmployer: ACME/nLocation: Desert/nPosition Type: Quality Control/nCore Competency: Persistence/n", testJob.toString());
    }

    @Test
    public void testToStringEmptyField() {
        assertEquals("/nID: 5/nName: Data not available/nEmployer: Data not available/nLocation: Data not available/nPosition Type: Data not available/nCore Competency: Data not available/n", emptyFieldTestJob.toString());
    }
}

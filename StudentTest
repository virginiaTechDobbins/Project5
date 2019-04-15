// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Marcus Taylor <marcus99>
package prj5;

import student.TestCase;

/**
 * The StudentTest class tests the methods of the Student class to ensure
 * they run and function as intended.
 * 
 * @author <Marcus Taylor> <marcus99>
 * @version <04.15.2019>
 */
public class StudentTest extends TestCase {
    private String[] responses;
    private String date;
    private Student student;

    /**
     * Creates a student to be tested on.
     */
    public void setUp() {
        responses = new String[] { "No", "No", "Yes", "Yes", "Yes", "Yes" };
        date = new String("10/19/15 14:45");

        student = new Student(190, date, Major.MATH, Hobby.MUSIC,
            Region.SOUTHEAST, responses);
    }
    
    /**
     * Tests the getNum() method from the Student class.
     */
    public void testGetID() {
        assertEquals(190, student.getNum());
    }
    
    /**
     * Tests the getDate() method from the Student class.
     */
    public void testGetDate() {
        assertEquals(date, student.getDate());
    }
    
    /**
     * Tests the getMajor() method from the Student class.
     */
    public void testGetMajor() {
        assertEquals(Major.MATH, student.getMajor());
    }

    /**
     * Tests the getHobby() method from the Student class.
     */
    public void testGetHobby() {
        assertEquals(Hobby.MUSIC, student.getHobby());
    }
    
    /**
     * Tests the getRegion() method from the Student class.
     */
    public void testGetRegion() {
        assertEquals(Region.SOUTHEAST, student.getRegion());
    }
    
    /**
     * Tests the getResponses() method from the Student class.
     * 
     * Ensures it is of the correct length and storing data in the correct
     * indexes.
     */
    public void testGetResponses() {
        assertEquals(6, student.getResponses().length);
        assertEquals("No", student.getResponses()[0]);
        assertEquals(responses, student.getResponses());
    }

    /**
     * Tests the toString() method from the Student class.
     */
    public void testToString() {
        assertEquals("190,10/19/15 14:45,Math or CMDA,Southeast,music,No,No,Yes,Yes,Yes,Yes" + "\n", student.toString());
    }
}

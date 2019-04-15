import student.TestCase;

/**
 * BryanDobbinsTest will use JUnit testing functionality to ensure all of the
 * java code written by Bryan Dobbins for Project 5 for CS2114 works as 
 * intended
 * @author Bryan Dobbins (bryand5)
 * @version 2019.04.15
 */
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Bryan Dobbins (bryand5)
public class BryanDobbinsTest extends TestCase {

    private Song testSong;
    /**
     * BryanDobbinsTest() does nothing and should never being invoked 
     */
    public BryanDobbinsTest() {
        //This method was intentionally left blank
    }
    
    /**
     * setUp() will be automatically invoked before each test method to 
     * provide a clean and controlled testing environment 
     */
    @Override
    public void setUp() {
        testSong = new Song("Last Dance", "Danny Barronowski", "techno", 2015);
    }
    
    /**
     * testSong() will test the Song class
     */
    public void testSong() {
        assertEquals("Last Dance", testSong.getTitle());
        assertEquals("Danny Barronowski", testSong.getArtist());
        assertEquals("techno", testSong.getGenre());
        assertEquals(2015, testSong.getYear());
        assertEquals(-1.0, testSong.getHeard(), 0.0001);
        assertEquals(-1.0, testSong.getLiked(), 0.0001);
        assertEquals("\"Last Dance\", by Danny Barronowski, techno, released "
            + "2015, no survey data.", testSong.toString());
        assertFalse(testSong.setHeard(-2.0));
        assertFalse(testSong.setLiked(-2.0));
        assertEquals(-1.0, testSong.getHeard(), 0.0001);
        assertEquals(-1.0, testSong.getLiked(), 0.0001);
        assertFalse(testSong.setHeard(0.50));
        assertFalse(testSong.setLiked(0.50));
        assertEquals(-1.0, testSong.getHeard(), 0.0001);
        assertEquals(-1.0, testSong.getLiked(), 0.0001);
        assertTrue(testSong.setHeard(1.0));
        assertTrue(testSong.setLiked(1.0));
        assertEquals(1.0, testSong.getHeard(), 0.0001);
        assertEquals(1.0, testSong.getLiked(), 0.0001);
        assertFalse(testSong.setHeard(5.75));
        assertFalse(testSong.setLiked(6.75));
        assertEquals(1.0, testSong.getHeard(), 0.0001);
        assertEquals(1.0, testSong.getLiked(), 0.0001);
        assertTrue(testSong.setHeard((int) 5.75));
        assertTrue(testSong.setLiked((int) 6.75));
        assertEquals(5.0, testSong.getHeard(), 0.0001);
        assertEquals(6.0, testSong.getLiked(), 0.0001);
        
        assertEquals("\"Last Dance\", by Danny Barronowski, techno, released "
            + "2015, 5 heards, 6 likes.", testSong.toString());
        
        testSong = new Song("She Loves You", "the Beatles", "rock and roll", 
            1964, -1.0, 99.0);
        
        assertEquals("\"She Loves You\", by the Beatles, rock and roll," +
            " released 1964, no survey data.", testSong.toString());
        assertTrue(testSong.setHeard(100.0));
        assertEquals("\"She Loves You\", by the Beatles, rock and roll," +
            " released 1964, 100 heards, 99 likes.", testSong.toString());
    }
    
}

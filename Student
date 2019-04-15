package prj5;

/**
 * The Student class creates a new Student object with its own unique ID,
 * date, and a major, hobby, and region selected from a preselected list. Also
 * logs all responses.
 * 
 * @author <Marcus Taylor> <marcus99>
 * @version <04.15.2019>
 */
public class Student {
    private int num;
    private String date;
    private Major major;
    private Hobby hobby;
    private Region region;
    private String[] responses;
    
    /**
     * Creates a new Student object.
     * 
     * @param num ID of student
     * @param date Date of submission
     * @param major Major
     * @param hobby Hobby
     * @param region Region
     * @param responses Responses
     */
    public Student(int num, String date, Major major, Hobby hobby, Region region, 
            String[] responses) {
        
        this.num = num;
        this.date = date;
        this.major = major;
        this.hobby = hobby;
        this.region = region;
        this.responses = responses;
    }
    
    /**
     * Gets the ID of the student.
     * 
     * @return ID of student
     */
    public int getID() {
        return num;
    }
    
    /**
     * Gets the date student accessed survey.
     * 
     * @return date accessed
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Gets the Major of the student.
     * 
     * @return Student major
     */
    public Major getMajor() {
        return major;
    }
    
    /**
     * Gets the Hobby of the student.
     * 
     * @return Student hobby.
     */
    public Hobby getHobby() {
        return hobby;
    }
    
    /**
     * Gets the region of the student.
     * 
     * @return Student region.
     */
    public Region getRegion() {
        return region;
    }
    
    /**
     * Gets the responses of the student to the survey.
     * 
     * @return Array of student responses
     */
    public String[] getResponses() {
        return responses;
    }
    
    /**
     * Reads the Student's major, region, and hobby, and formats them
     * to assist the toString() method.
     * 
     * @return formatted Enums.
     */
    private String enumFormat() {
        StringBuilder s = new StringBuilder();
            
        switch (major) {
            case CS: 
                s.append("Computer Science,");
                break;
            case MATH:
                s.append("Math or CMDA,");
                break;
            case ENGINEERING:
                s.append("Other Engineering,");
                break;
            default:
                s.append("Other,");
        }
        
        switch (region) {
            case NORTHEAST: 
                s.append("Northeast,");
                break;
            case SOUTHEAST:
                s.append("Southeast,");
                break;
            case OTHER_US:
                s.append("United States (other than Southeast or Northwest),");
                break;
            case OUTSIDE_US:
                s.append("Outside of United States");
                break;
            default:
                s.append("Other,");
        }
        
        switch (hobby) {
            case READING: 
                s.append("reading,");
                break;
            case ART:
                s.append("art,");
                break;
            case MUSIC:
                s.append("music,");
                break;
            case SPORTS:
                s.append("sports");
                break;
            default:
                s.append("Other,");
        }
        
        return s.toString();
    }
    
    /**
     * Returns a string representation of the student who accessed the survey.
     * 
     * @return String representation of student.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(num + ",");
        s.append(date + ",");
        s.append(enumFormat());
        
        int i = 0;
        boolean firstItem = true;
        while (i < responses.length) {
            if (!firstItem) {
                s.append(",");
            }
            else {
                firstItem = false;
            }
            s.append(responses[i]);
            i++;
        }
        
        s.append("\n");
        
        return s.toString();
    }
}

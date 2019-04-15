/**
 * Song will represent musical songs that were asked about in the survey
 * @author Bryan Dobbins (bryand5)
 * @version 2019.04.15
 */
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I accept the actions of those 
//who do.
//-- Bryan Dobbins (bryand5)
public class Song {

    private String songTitle;
    private String artistName;
    private String genre;
    private int releaseYear;
    private double totalHeard;
    private double totalLiked;
    
    /**
     * Song(String, String, String, int) will create a new Song object that 
     * is blank with respect to the data concerning the the number of 
     * responses that were recorded in the survey
     * @param inTitle the title of the song itself
     * @param inName the name of the artist(s) that created the song
     * @param inGenre the type of music that this song is
     * @param inYear the year that the song was intially released
     */
    public Song(String inTitle, String inName, String inGenre, int inYear) {
        this.songTitle = inTitle;
        this.artistName = inName;
        this.genre = inGenre;
        this.releaseYear = inYear;
        this.totalHeard = -1.0;
        this.totalLiked = -1.0;
    }
    
    /**
     * Song(String, String, String, int, double, double) will create a new 
     * Song object with 
     * @param inTitle the title of the song itself
     * @param inName the name of the artist(s) that created the song
     * @param inGenre the type of music that this song is
     * @param inYear the year that the song was intially released
     * @param inHeard the number of the total number of students that 
     *                responded positively to liking the song in the survey
     * @param inLiked the number of the total number of students that 
     *                repsonded postitively to having hear of the song in 
     *                the survey
     */
    public Song(String inTitle, String inName, String inGenre, int inYear, 
        double inHeard, double inLiked) {
        this(inTitle, inName, inGenre, inYear);
        this.setHeard(inHeard);
        this.setLiked(inLiked);
    }
    
    /**
     * getTitle() is an accessor method that accesses the private instance
     * field that represents the song title in String format
     * @return songTitle the String encoding the song title
     */
    public String getTitle() {
        return this.songTitle;
    }
    
    /**
     * getArtist() is an accessor method that accesses the private instance
     * field that represents the creator artists name in String format
     * @return artistName the String that encodes the name of the artist who 
     *                    created the song
     */
    public String getArtist() {
        return this.artistName;
    }
    
    /**
     * getGenre() is an accessor method that accesses the private instance
     * field that represents the genre of the song in String format
     * @return genre the String that encodes the genre of the song
     */
    public String getGenre() {
        return this.genre;
    }
    
    /**
     * getYear() is an accessor method that accesses the private instance
     * field that represents the year the song was released in an int
     * @return releaseYear the year CE that the song was relased to the public
     */
    public int getYear() {
        return this.releaseYear;
    }
    
    /**
     * getHeard() is an accessor method that accesses the private instance
     * field that represents the number of survey responses from people who
     * have heard of this song
     * @precondition the heard double of the Song instance has been properly 
     *               instanciated, with the constructor or the mutator method  
     * @return totalHeard the number of surveyees who have heard of this song
     *                    -1.0 if the field has not properly been set up 
     */
    public double getHeard() {
        return this.totalHeard;
        
    }
    
    /**
     * getHeard() is an accessor method that accesses the private instance
     * field that representst the number of survey repsonses from people who
     * like this song
     * @precondition the liked double of the Song instance has been properly 
     *               instanciated, with the constructor or the mutator method  
     * @return totalLiked the number of surveyees who have heard of this song
     *                    -1.0 if the field has not properly been set up 
     */
    public double getLiked() {
        return this.totalLiked;
    }
    
    /**
     * setHeard(double) will reassign the private instance field heard
     * to the argument value double if the target value is an acceptable 
     * value. It the value is unacceptable, the value of heard is unchanged
     * @precondition the argument value is a positive integer value encoded
     *               as a double precision floating point number
     * @param target the double value that is being tested 
     * @return wasSet true if the argument value was acceptable and the 
     *                     heard value was set to be the argument value
     *                false if the argument value was unacceptable and the
     *                      heard value was not changed
     */
    public boolean setHeard(double target) {
        if ((target < 0.0) || (Math.floor(target) - target < 0.0) ) {
            return false;
        }
        else {
            this.totalHeard = target;
            return true;
        }
    }
    
    /**
     * setLiked(double) will reassign the private instance field liked
     * to the argument value double if the target value is an acceptable 
     * value. It the value is unacceptable, the value of heard is unchanged
     * @precondition the argument value is a positive integer value encoded
     *               as a double precision floating point number
     * @param target the double value that is being tested 
     * @return wasSet true if the argument value was acceptable and the 
     *                     heard value was set to be the argument value
     *                false if the argument value was unacceptable and the
     *                      heard value was not changed
     */
    public boolean setLiked(double target) {
        if ((target < 0.0) || (Math.floor(target) - target < 0.0) ) {
            return false;
        }
        else {
            this.totalLiked = target;
            return true;
        }
    }
    
    /**
     * toString() will return a String representation of the invoking Song
     * instance to the client code
     * EX Song with survey both datam    ->
     * "She Loves You", by the Beatles, rock and roll, released 1964,
     *  100 heards, 99 likes.   
     * EX Song without survey both datam ->
     *  "She Loves You", by the Beatles, rock and roll, released 1964,
     *   no survey data.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append(this.songTitle);
        sb.append("\", by ");
        sb.append(this.artistName);
        sb.append(", ");
        sb.append(this.genre);
        sb.append(", released ");
        sb.append(this.releaseYear);
        if ((Math.abs(this.totalHeard + 1.0) < 0.001) || 
            (Math.abs(this.totalLiked + 1.0) < 0.001)) {
            sb.append(", no survey data.");
        }
        else {
            sb.append(", ");
            sb.append((int) this.totalHeard);
            sb.append(" heards, ");
            sb.append((int) this.totalLiked);
            sb.append(" likes.");
        }
        return sb.toString();
    }
}

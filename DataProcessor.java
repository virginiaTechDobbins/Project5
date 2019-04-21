package prj5;

import java.util.Iterator;
/**
 * DataProcessor will do all of the back end calculations for the Project 5
 * Music survey response sorter 
 * @author Bryan Dobbins (bryand5)
 * @version 2019.04.15
 */
public class DataProcessor {

    private LinkedList<Song> songList;
    private LinkedList<Student> studentList;
    private LinkedList<Song> questionOrder;
    private LinkedList<String> artistOrder;
    private LinkedList<String> genreOrder;
    private LinkedList<String> titleOrder;
    
    
    /**
     * DataProcessor(LinkedList<Song>, LinkedList<Student>) is the only 
     * constructor for DataProcessor, and it will create the appropriate 
     * @param inSongs
     * @param inStudents
     */
    public DataProcessor(LinkedList<Song> inSongs, 
        LinkedList<Student> inStudents) {
        this.songList = inSongs;
        this.artistOrder = this.orderArtists();
        this.genreOrder = this.orderGenre();
        this.titleOrder = this.orderTitles();
        //System.out.println("The question order is " + 
        //    questionOrder.toString());
        System.out.println("The artist order is " + 
            artistOrder.toString());
        System.out.println("The genre order is " + 
            genreOrder.toString());
        System.out.println("The title order is " + 
            titleOrder.toString());
        this.questionOrder = new LinkedList<Song>();
        for (int i = 0; i < inSongs.getSize(); i++) {
            questionOrder.add(inSongs.get(i));
        }
        //questionOrder needs to preserve the original order of the LinkedList
        //of songs passed in the constructor because that will correspond to 
        //the order of the questions, which is needed to get the correct 
        //answers from the students response arrays
        this.studentList = inStudents;
    }
    
    /**
     * reodrderByData(int) will return to the client code
     * a LinkedList<Song> that is the argument LinkedList<Song> that is sorted
     *  according to the category encoded in the int argument
     * @precodition the int argument must be between 1 and 4 inclusive in value
     * @param input the LinkedList<Song> that will be resorted
     * @param category 1 sort by artist names
     *                 2 sort by song title
     *                 3 sort by genre
     *                 4 sort by date (ascending)
     * @return sortedList the sorted by the intended category
     */
    public LinkedList<Song> reorderByData(int category) {
        //Programmers note: Use Selection sort, 
        if ((1 > category) || (4 < category)) {
            throw new IllegalArgumentException("The int argument must be "
                + "on the range of 1 to 4 inclusive.");
        }
        int buf;
        for (int i = 0; i < this.songList.getSize(); i++) {
            buf = getIndexOfSmallest(i, category);
            swapSongs(i, buf);
        }
        
        return this.songList;
    }
    
    /**
     * calculateResponses(Song, int) will return the double value that encodes
     * the proportion of students
     * @param song the song object being sampled
     * @param enumer 1 the hobby enumerable type
     *               2 the major enumerable type
     *               3 the state enumerable type
     * @param val the ordered integer number corresponding to the target 
     *             value of the enumerable type. Ranges from 1 to 4 inclusive
     *             EX: if enumer = 1 (hobby), and resp = 1, it corresponds to 
     *                 reading. if enumer = 1 and resp = 2, it corresponds to 
     *                 art. Pattern continues for all 
     * @param resp the integer number that corresponds to the target question
     *             1 for the proportion of students who fell into the category
     *              and heard of the song
     *             2 for the proporiton of students who fell into the caetgory
     *              an liked the song
     * @return percentage the proportion of student
     */
    public double calculateResponses(Song song, int enumer, int val,
        int resp) {
        if ((1 > enumer) || (3 < enumer)) {
            throw new IllegalArgumentException("The int argument enumer"
                + " must be on the range of 1 to 3 inclusive.");
        }
        if ((1 > val) || (4 < val)) {
            throw new IllegalArgumentException("The int argument val must be "
                + "on the range of 1 to 4 inclusive.");
        }
        if ((1 > resp) || (2 < resp)) {
            throw new IllegalArgumentException("The int argument resp must be"
                + " on the range of 1 to 2 inclusive.");
        }
        if (!this.songList.contains(song)) {
            throw new IllegalArgumentException("The Song argument song is " +
                "not in the list of songs.");
        }
        double totalOfCategory = getTotalOfCategory(enumer, val);
        if (totalOfCategory == 0.0) {
            return 0.0;
        }
        double correctResponse = getNumberOfCorrect(song, enumer, val, resp);
        return correctResponse / totalOfCategory;
    }
    
///////////////////////////////////////////////////////////////////////////////    
    /**
     * swapSongs(int, int) is a private helper method that will swap the 
     * Song objects at the integer argument indices 
     * @param lesserIndex the index of the prior to be swapped song
     * @param biggerIndex the index of the latter to be swapped song
     */
    private void swapSongs(int lesserIndex, int biggerIndex) {
        if (lesserIndex != biggerIndex) {
            Song lesser = this.songList.get(lesserIndex);
            Song bigger = this.songList.get(biggerIndex);
            this.songList.remove(lesserIndex);
            this.songList.add(lesserIndex, bigger);
            this.songList.remove(biggerIndex);
            this.songList.add(biggerIndex, lesser);
        }
    }
    
    /**
     * getIndexOfSmallest(int, int) will return the int value of the Song
     * object with the smallest value of the selected category
     * @param beginIndex the index that the search will start at
     * @param category 1 search by artist name
     *                 2 search by song title
     *                 3 search by genre
     *                 4 search by date
     * @return smallest the index of the item in a list with the smallest 
     *                  comparison value within the specified bounds 
     */
    private int getIndexOfSmallest(int beginIndex, int category) {
        //for category = 1, 2, 3, the comparing variable type is going to 
        //be a toLowerCase String object, and for 4, the comparing variable 
        //type will be int
        if (beginIndex == this.songList.getSize() - 1) {
            return beginIndex;
        }
        int smallest = beginIndex;
        int compareValue = getCompareValue(this.songList.get(smallest), 
            category);
        for (int i = beginIndex; i < this.songList.getSize(); i++) {
            if (compareValue > getCompareValue(this.songList.get(i),
                category)) {
                smallest = i;
                compareValue = getCompareValue(this.songList.get(smallest), 
                    category);
            }
        }
        return smallest;
    }
    
    /**
     * getCompareValue(Song, int) will return to the 
     * @param song the song whose 
     * @param category 1 search by artist name
     *                 2 search by song title
     *                 3 search by genre
     *                 4 search by date
     * @return comparisonValue is value which will be compared
     */
    private int getCompareValue(Song song, int category) {
        int val;
        switch(category) {
            case 1: val = artistOrder.getIndex(song.getArtist());
                break;
            case 2: val = titleOrder.getIndex(song.getTitle());
                break;
            case 3: val = genreOrder.getIndex(song.getGenre()); 
                break;
            default: val = song.getYear();
                break;
        }
        return val;
    }
    
    /**
     * orderArtist(Song) will order the  
     * their alphabetical ranking. IE an artist will be rated lower is their
     * name comes before others in an alpabetical sorting of the names.
     * @param song
     * @return ranking the integer that encodes the relative ranking of the 
     *                 artist name in comarison to others 
     */
    private LinkedList<String> orderArtists() {
        LinkedList<String> artists = new LinkedList<String>();
        String buf1, buf2, buffer;
        for (Iterator<Song> iter = this.songList.iterator(); iter.hasNext();
            ) {
            buffer = iter.next().getArtist();
            if (!artists.contains(buffer)) {
                artists.add(buffer);
            }
            
        }
        for (int i = 0; i < artists.getSize(); i++) {
            for (int n = i + 1; n < artists.getSize(); n++) {
                if (comesFirst(artists.get(n).toLowerCase(), 
                    artists.get(n - 1).toLowerCase())){
                    buf1 = artists.get(n - 1);
                    buf2 = artists.get(n);
                    artists.remove(n - 1);
                    artists.add(n - 1, buf2);
                    artists.remove(n);
                    artists.add(n, buf1);
                }
            }
        }
        return artists;
        
    }
    
    /**
     * orderTitles() will process the input data and initalize the private 
     * instance field to have the order of the titles of songs in memory 
     * for purposes of reorganizing when prompted by the user
     * @return
     */
    private LinkedList<String> orderTitles() {
        LinkedList<String> titles = new LinkedList<String>();
        String buf1, buf2;
        for (Iterator<Song> iter = this.songList.iterator(); iter.hasNext();
            ) {
            titles.add(iter.next().getTitle());
        }
        for (int i = 0; i < titles.getSize(); i++) {
            for (int n = i + 1; n < titles.getSize(); n++) {
                if (comesFirst(titles.get(n).toLowerCase(), 
                    titles.get(n - 1).toLowerCase())){
                    buf1 = titles.get(n - 1);
                    buf2 = titles.get(n);
                    titles.remove(n - 1);
                    titles.add(n - 1, buf2);
                    titles.remove(n);
                    titles.add(n, buf1);
                }
            }
        }
        return titles;
    }
    
    /**
     * orderTitles() will process the input data and initalize the private 
     * instance field to have the order of the titles of songs in memory 
     * for purposes of reorganizing when prompted by the user
     * @return
     */
    private LinkedList<String> orderGenre() {
        LinkedList<String> genres = new LinkedList<String>();
        String buf1, buf2, buffer;
        for (Iterator<Song> iter = this.songList.iterator(); iter.hasNext();
            ) {
            buffer = iter.next().getGenre();
            if (!genres.contains(buffer)) {
                genres.add(buffer);
            }
        }
        for (int i = 0; i < genres.getSize(); i++) {
            for (int n = i + 1; n < genres.getSize(); n++) {
                if (comesFirst(genres.get(n), 
                    genres.get(n - 1))){
                    buf1 = genres.get(n - 1);
                    buf2 = genres.get(n);
                    genres.remove(n - 1);
                    genres.add(n - 1, buf2);
                    genres.remove(n);
                    genres.add(n, buf1);
                }
            }
        }
        return genres;
    }
    
    
    /**
     * comesFirst(String, String)
     * @param first the string that comes first
     * @param second the string that comes second
     * @return cameFirst true if the first argument string comes first
     *                   alphabetically,
     *                   false if the second string argument comes first
     *                   alphabetically
     */
    private boolean comesFirst(String first, String second) {
        int size;
        boolean cameFirst;
        if (first.length() > second.length()) {
            size = second.length();
            cameFirst = false;
        }
        else {
            size = first.length();
            cameFirst = true;
        }
        for (int i = 0; i < size; i++) {
            if (first.codePointAt(i) > second.codePointAt(i)) {
                cameFirst = true;
                break;
            }
            else if (first.codePointAt(i) < second.codePointAt(i)) {
                cameFirst = false;
                break;
            }
        }
        return cameFirst;
    }
    
    /**
     * getTotalOfCategory(int, int) will return the double encoding the total
     * number of students in the student list who are in the e
     * @param enumer must be 1 to 3 inclusive
     *               1 -> Hobby (read, art, music, sports)
     *               2 -> Major (Comp Sci, Other Engi, Math/CMDA, Other)
     *               3 -> Region (NE US, SE US, rest of US, outsid of US)
     * @param resp   must be 1 to 4 inclusive
     * @return totalStudents the total number of students in the list that 
     *                       responded accordingly in their survey
     */
    private double getTotalOfCategory(int enumer, int resp) {
        switch(enumer) {
            case 1: return (double) studentsOfHobby(resp).getSize();
            case 2: return (double) studentsOfMajor(resp).getSize();
            default:return (double) studentsOfRegion(resp).getSize();
        }
    }
    
    /**
     * numberOfHobby(int) will return the double encoding the total
     * number of students whos Hobby corresponds to the integer argument
     * @param resp must be 1 to 4 inclusive
     *             1 -> Hobby.READING
     *             2 -> Hobby.ART
     *             3 -> Hobby.SPORTS
     *             4 -> Major.MUSIC  
     * @return totalStudents the total number of students in the list that 
     *                       responded accordingly in their survey
     */
    private LinkedList<Student> studentsOfHobby(int resp) {
        Hobby target;
        switch(resp) {
            case 1: target = Hobby.READING;
                break;
            case 2: target = Hobby.ART;
                break;
            case 3: target = Hobby.SPORTS;
                break;
            default:target = Hobby.MUSIC;
                break;
        }
        LinkedList<Student> correctStudents = new LinkedList<Student>();
        for (int i = 0; i < this.studentList.getSize(); i++) {
            if (this.studentList.get(i).getHobby() == target) {
                correctStudents.add(this.studentList.get(i));
            }
        }
        return correctStudents;
    }
    
    /**
     * numberOfMajor(int) will return the double encoding the total
     * number of students whose Major corresponds to the integer argument
     * @param resp must be 1 to 4 inclusive
     *             1 -> Major.CS
     *             2 -> Major.ENGINEERING
     *             3 -> Major.MATH
     *             4 -> Major.OTHER  
     * @return totalStudents the total number of students in the list that 
     *                       responded accordingly in their survey
     */
    private LinkedList<Student> studentsOfMajor(int resp) {
        Major target;
        switch(resp) {
            case 1: target = Major.CS;
                break;
            case 2: target = Major.ENGINEERING;
                break;
            case 3: target = Major.MATH;
                break;
            default:target = Major.OTHER;
                break;
        }
        LinkedList<Student> correctStudents = new LinkedList<Student>();
        for (int i = 0; i < this.studentList.getSize(); i++) {
            if (this.studentList.get(i).getMajor() == target) {
                correctStudents.add(this.studentList.get(i));
            }
        }
        return correctStudents;
    }
    
    /**
     * numberOfRegion(int) will return the double encoding the total
     * number of students whose Region corresponds to the integer argument
     * @param resp must be 1 to 4 inclusive
     *             1 -> Region.NORTHEAST
     *             2 -> Region.SOUTHEAST
     *             3 -> Region.OTHER_US
     *             4 -> Region.OUTSIDE_US  
     * @return totalStudents the total number of students in the list that 
     *                       responded accordingly in their survey
     */
    private LinkedList<Student> studentsOfRegion(int resp) {
        Region target;
        switch(resp) {
            case 1: target = Region.NORTHEAST;
                break;
            case 2: target = Region.SOUTHEAST;
                break;
            case 3: target = Region.OTHER_US;
                break;
            default:target = Region.OUTSIDE_US;
                break;
        }
        LinkedList<Student> correctStudents = new LinkedList<Student>();
        for (int i = 0; i < this.studentList.getSize(); i++) {
            if (this.studentList.get(i).getRegion() == target) {
                correctStudents.add(this.studentList.get(i));
            }
        }
        return correctStudents;
    }
    
    /**
     * getNumerOfCorrect(int, int, int) will return the double value of
     * the total number of students who fall into the category given
     * @param song the song in question
     * @param enumer the integer encoding the enumerable type being searched
     * @param val the integer encoding the specific value of the enumerable 
     *            type 
     * @param resp 1 for the number of students who heard of the song
     *             2 for the number of students who liked the song
     * @return correctStudents
     */
    private double getNumberOfCorrect(Song song, int enumer, int val, 
        int resp) {
        double totalStudents = 0.0;
        LinkedList<Student> correctSubdivision;
        switch (enumer) {
            case 1: correctSubdivision = studentsOfHobby(val);
                break; 
            case 2: correctSubdivision = studentsOfMajor(val);
                break;
            default: correctSubdivision = studentsOfRegion(val);
                break;
        }
        int songIndex = this.questionOrder.getIndex(song);
        songIndex = 2 * songIndex;
        if (resp == 2) {
            songIndex = songIndex + 1;
        }
        for (int i = 0; i < correctSubdivision.getSize(); i++) {
            if (correctSubdivision.get(i).getResponses()[songIndex].
                equals("Yes")) {
                totalStudents = totalStudents + 1.0;
            }
        }
        return totalStudents;
    }
    
}

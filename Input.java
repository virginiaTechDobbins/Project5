package prj5;

import java.io.FileNotFoundException;
/**
 * Input is the class required by the Intermediate submission for project5
 * by our benevolent and generous-in-grading CS professors, and TAs
 * @author Bryan Dobbins (bryand5)
 * @version 2019.04.16
 */
public class Input {

    /**
     * main(Stringp[]) will have two strings passed to is as agrugments
     * in the array, and they will be 
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataProcessor dataProc;
        String buf;
        String buf2;
        String buf3;
        if (args.length == 2) {
            DataReader read = new DataReader(args[0], args[1]);
            dataProc = read.getProcessor();
            LinkedList<Song> songList = dataProc.reorderByData(3);
            
            for (int i = 0; i < songList.getSize(); i++) {
                System.out.println("Song Title: " + songList.get(i).
                    getTitle());
                System.out.println("Song Artist: " + songList.get(i).
                    getArtist());
                System.out.println("Song Genre: " + songList.get(i).
                    getGenre());
                System.out.println("Song Year: " + songList.get(i).
                    getYear());
                System.out.println("Heard");
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 1, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf = "reading:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 2, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf += " art:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 3, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf += " sports:" + buf3;  
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 4, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf += " music:" + buf3;
                System.out.println(buf);
                System.out.println("Likes");
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 1, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 = "reading:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 2, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 += " art:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 3, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 += " sports:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 4, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 += " music:" + buf3;
                System.out.println(buf2);
            }
           
            songList = dataProc.reorderByData(2);
            
            for (int i = 0; i < songList.getSize(); i++) {
                System.out.println("");
                System.out.println("Song Title: " + songList.get(i).
                    getTitle());
                System.out.println("Song Artist: " + songList.get(i).
                    getArtist());
                System.out.println("Song Genre: " + songList.get(i).
                    getGenre());
                System.out.println("Song Year: " + songList.get(i).
                    getYear());
                System.out.println("Heard");
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 1, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf = "reading:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 2, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf += " art:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 3, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf += " sports:" + buf3;  
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 4, 1) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf += " music:" + buf3;
                System.out.println(buf);
                System.out.println("Likes");
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 1, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 = "reading:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 2, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 += " art:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 3, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 += " sports:" + buf3;
                buf3 = String.valueOf(dataProc.calculateResponses(
                    songList.get(i), 1, 4, 2) * 100);
                buf3 = buf3.substring(0, buf3.length() - 1);
                buf2 += " music:" + buf3;
                System.out.println(buf2);
            }
        }
        
    }
}


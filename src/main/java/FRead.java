import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FRead {

    public static String FReader(String s){
        File file = new File(s);

        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String fileContent = "";

        while (scan.hasNextLine()) {
            fileContent = fileContent.concat(scan.nextLine() + "\n");

        }
        scan.close();
        return fileContent;

    }

    public List<String> FullFileToArraySplitter(String filename){
        String fullTxt = FRead.FReader(filename);

        String delimsStart = "START OF THIS PROJECT GUTENBERG";
        String delimsEnd = "END OF THIS PROJECT GUTENBERG";

        String[] discardStart = fullTxt.split(delimsStart);
        String[] discardEnd = discardStart[0].split(delimsEnd);

        String startAndEndRemoved = discardEnd[0];

        List<String> bookInArray = new ArrayList<String>();

        int index = 0;
        //loop to split the book into chunks of 15000 characters for CoreNLP analysis
        while (index < startAndEndRemoved.length()){
            bookInArray.add(startAndEndRemoved.substring(index, Math.min(index +10000, startAndEndRemoved.length())));
            index +=10000;
        }


        //*removed* chapterization - many books had unique names for chapters making unfeasible with a large corpus of texts.
        /*
        String delimsChapters = "Chapter [1-9]+";
        String[] ch = startAndEndRemoved.split(delimsChapters);
        System.out.println(ch[61]); //testing on Chap 61
        System.out.println("ch length: " + ch.length);*/




        //newBook1.setBrokenDownText((java.awt.List) bookInArray);
        //System.out.println("We have added the broken down book into ListArray for Book object");
        return bookInArray;
    }
}

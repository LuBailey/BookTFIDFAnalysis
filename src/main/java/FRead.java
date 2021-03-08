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
        return fileContent;

    }


    //TODO: - sometimes words at Start/End of Lists are being separated in half by a comma, need to check this loop.
    public List<String> FullFileToArraySplitter(String filename){

        //Book newBook1 = new Book(filename);
        String fullTxt = FRead.FReader(filename);

        //newBook1.setRawText(fullTxt);

        String delimsStart = "\\*\\*\\* START OF THIS PROJECT GUTENBERG";
        String delimsEnd = "\\*\\*\\* END OF THIS PROJECT GUTENBERG";

        String[] discardStart = fullTxt.split(delimsStart);
        String[] discardEnd = discardStart[1].split(delimsEnd);


        String startAndEndRemoved = discardEnd[0];


        List<String> bookInArray = new ArrayList<String>();

        int index = 0;

        //loop to split the book into chunks of 2000 elements for CoreNLP analysis (larger strings cannot be handled well.)

        while (index < startAndEndRemoved.length()){
            //bookInArray.add(bookInArray.size(), startAndEndRemoved.substring(index, Math.min(index + 2000, startAndEndRemoved.length())));
            //index += 2000;
            bookInArray.add(startAndEndRemoved.substring(index, Math.min(index + 2000, startAndEndRemoved.length())));
            index +=2000;

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

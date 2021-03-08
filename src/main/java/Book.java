import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book {

    private String fileName;
    private String title;
    private String author;
    private int year;
    private int noOfPages;
    private int noOfWords;
    private String publisher;
    private String source;
    private String rawText;
    private ArrayList<String> brokenDownText = new ArrayList<>();
    private List<String> brokenDownTextCompleteSet = new ArrayList<>();

    //private LinkedList<String> multiBookLemmatizedCollection;

    //String rawText;


    //creating constructor for book class
    public Book(String fileName){

    }
    public Book() {

    }

    //getters for book info

    public String getFileName() {
        return fileName;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public int getNoOfWords() {
        return noOfWords;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSource() {
        return source;
    }

    public String getRawText() {
        return rawText;
    }

    public ArrayList<String> getBrokenDownText() {
        return brokenDownText;
    }

    public List<String> getBrokenDownTextCompleteSet() {
        return brokenDownTextCompleteSet;
    }



    //setters for the field variables

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public void setNoOfWords(int noOfWords) {
        this.noOfWords = noOfWords;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public void setBrokenDownText(ArrayList<String> brokenDownText) {
            this.brokenDownText.addAll(brokenDownText);


    }

    public void setBrokenDownTextCompleteSet(ArrayList<String> brokenDownTextCompleteSet) {
        for (int i = 0; i < brokenDownTextCompleteSet.toString().length(); i++){
            this.brokenDownTextCompleteSet.add(i, brokenDownTextCompleteSet.toString());
        }
    }



    //toString to return stored bookInfo
    public String toString() {
        return "Book details: " + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Year: " + year + "\n" +
                "Number of Pages: " + noOfPages + "\n" +
                "Number of words: " + noOfWords + "\n" +
                "Publisher " + publisher + "\n" +
                "Source: " + source;

    }

    //initializing the complete collection linkedlist for appending the parsed sections to.



    public void addToCompleteBookArrList(String parsedSection) {
        //if statement initilize the linked list.
        this.brokenDownTextCompleteSet.add(parsedSection);
    }



    public List<String> flattenListOfLists(List<List<String>> listOfLists, int listOfListsLength){
        ArrayList<String> collatedArrStr = new ArrayList<>();
        for (int i = 0; i < listOfListsLength; i++){
            collatedArrStr.add(listOfLists.get(i).toString());
            }
        return collatedArrStr;

        }

    }



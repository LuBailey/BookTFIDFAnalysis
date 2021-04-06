import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import java.io.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class CoreNLP {
    Review rev = new Review();
    Book bk = new Book();
    tfidfMatrix tfidf = new tfidfMatrix();
    tfidfMatrix calctfidf = new tfidfMatrix();

    public static void main(String[] args) throws IOException {
        //new CoreNLP();
        CoreNLP obj = new CoreNLP();
    }
    public CoreNLP() {

        FRead fileReadObjOne = new FRead();
        FRead fileReadObjTwo = new FRead();
        FRead fileReadObjThree = new FRead();
        FRead fileReadObjFour = new FRead();
        //pre coreNLP processed texts

        ArrayList bookOneToList = (ArrayList) fileReadObjOne.FullFileToArraySplitter("The Project Gutenberg EBook of Pride and Prejudice, by Jane Austen.txt");
        ArrayList bookTwoToList = (ArrayList) fileReadObjTwo.FullFileToArraySplitter("The Project Gutenberg's EBook of Frankenstein, by Mary Wollstonecraft (Godwin) Shelley.txt");
        ArrayList bookThreeToList = (ArrayList) fileReadObjThree.FullFileToArraySplitter("The Project Gutenberg EBook of A Christmas Carol, by Charles Dickens.txt");
        ArrayList bookFourToList = (ArrayList) fileReadObjFour.FullFileToArraySplitter("The Project Gutenberg EBook of The Strange Case Of Dr. Jekyll .txt");

        List<ArrayList<String>> documents = new ArrayList<>();
        //ArrayList emptyList = new ArrayList<String>();
        //documents.add(emptyList);


        //BookOne (PaP) broken down
        Book bookOne = new Book("The Project Gutenberg EBook of Pride and Prejudice, by Jane Austen.txt");
        for (int i = 0; i < bookOneToList.size(); i++) {
            bookOne.setBrokenDownText(nlpProcess((String) bookOneToList.get(i)));
        }
        documents.add(bookOne.getBrokenDownText());

        //BookTwo (Frankenstein) broken down
        Book bookTwo = new Book("The Project Gutenberg's EBook of Frankenstein, by Mary Wollstonecraft (Godwin) Shelley.txt");
        for (int i = 0; i < bookTwoToList.size(); i++) {
            bookTwo.setBrokenDownText(nlpProcess((String) bookTwoToList.get(i)));
        }
        documents.add(bookTwo.getBrokenDownText());

        Book bookThree = new Book("The Project Gutenberg EBook of A Christmas Carol, by Charles Dickens.txt");
        for (int i = 0; i < bookThreeToList.size(); i++) {
            bookThree.setBrokenDownText(nlpProcess((String) bookThreeToList.get(i)));
        }
        documents.add(bookThree.getBrokenDownText());

        Book bookFour = new Book("The Project Gutenberg EBook of The Strange Case Of Dr. Jekyll .txt");
        for (int i = 0; i < bookFourToList.size(); i++) {
            bookFour.setBrokenDownText(nlpProcess((String) bookFourToList.get(i)));
        }
        documents.add(bookFour.getBrokenDownText());

        //TFIDF Calculation
        int index = 0; //index to specify array index of when adding the newly sorted LinkedHashMaps into the Arraylist
        for (ArrayList doc : documents) {
            tfidfMatrix TFIDFMat = new tfidfMatrix();
            for (int i = 0; i < doc.size(); i++) {
                if (TFIDFMat.mappedTFIDF.containsKey(doc.get(i))) {
                    continue;
                } else {
                    TFIDFMat.mappedTFIDF((String) doc.get(i), TFIDFMat.tfIdf(doc, documents, (String) doc.get(i)));
                }
            }
            //sorting the map <Word(K), TFIDF Values(V)> by the values, from lowest to highest TFIDF values.
            calctfidf.sortedMappedTFIDF = TFIDFMat.mappedTFIDF
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())  //can insert Comparator.reverseOrder() as a parameter to go from highest -> lowest
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            calctfidf.listOfMappedTFIDF.add(index, calctfidf.sortedMappedTFIDF);
            index++;
        }

        //System.out.println(calctfidf.listOfMappedTFIDF.get(0));

        calctfidf.bkOneTFIDFKeys = calctfidf.listOfMappedTFIDF.get(0).keySet();
        calctfidf.bkTwoTFIDFKeys = calctfidf.listOfMappedTFIDF.get(1).keySet();
        calctfidf.bkThreeTFIDFKeys = calctfidf.listOfMappedTFIDF.get(2).keySet();
        calctfidf.bkFourTFIDFKeys = calctfidf.listOfMappedTFIDF.get(3).keySet();

        calctfidf.bkOneTFIDFVal = calctfidf.listOfMappedTFIDF.get(0).values();

        calctfidf.bkTwoTFIDFVal = calctfidf.listOfMappedTFIDF.get(1).values();
        calctfidf.bkThreeTFIDFVal = calctfidf.listOfMappedTFIDF.get(2).values();
        calctfidf.bkFourTFIDFVal = calctfidf.listOfMappedTFIDF.get(3).values();


        List<String> bkOneArrListKeys = new ArrayList<>(calctfidf.bkOneTFIDFKeys);
        calctfidf.bkOneArrListKeys = (ArrayList<String>) bkOneArrListKeys;
        System.out.println("calctfidf.bkOneTFIDFKeys" + calctfidf.bkOneTFIDFKeys);
        List<String> bkTwoArrListKeys = new ArrayList<>(calctfidf.bkTwoTFIDFKeys);
        calctfidf.bkTwoArrListKeys = (ArrayList<String>) bkTwoArrListKeys;
        List<String> bkThreeArrListKeys = new ArrayList<>(calctfidf.bkThreeTFIDFKeys);
        calctfidf.bkThreeArrListKeys = (ArrayList<String>) bkThreeArrListKeys;
        List<String> bkFourArrListKeys = new ArrayList<>(calctfidf.bkFourTFIDFKeys);
        calctfidf.bkFourArrListKeys = (ArrayList<String>) bkFourArrListKeys;

        List<Double> bkOneArrListVals  = new ArrayList<>(calctfidf.bkOneTFIDFVal);
        calctfidf.bkOneArrListVals = (ArrayList<Double>) bkOneArrListVals;
        List<Double> bkTwoArrListVals  = new ArrayList<>(calctfidf.bkTwoTFIDFVal);
        calctfidf.bkTwoArrListVals = (ArrayList<Double>) bkTwoArrListVals;
        List<Double> bkThreeArrListVals  = new ArrayList<>(calctfidf.bkThreeTFIDFVal);
        calctfidf.bkThreeArrListVals = (ArrayList<Double>) bkThreeArrListVals;
        List<Double> bkFourArrListVals = new ArrayList<>(calctfidf.bkFourTFIDFVal);
        calctfidf.bkFourArrListVals = (ArrayList<Double>) bkFourArrListVals;

        rev.setBkOneArrayKeySet(calctfidf.listOfMappedTFIDF.get(0).keySet());
        rev.setBkTwoArrayKeySet(calctfidf.listOfMappedTFIDF.get(1).keySet());
        rev.setBkThreeArrayKeySet(calctfidf.listOfMappedTFIDF.get(2).keySet());
        rev.setBkFourArrayKeySet(calctfidf.listOfMappedTFIDF.get(3).keySet());

        rev.setBkOneBeginnerSet(rev.getBkOneArrSet());
        rev.setBkTwoBeginnerSet(rev.getBkTwoArrSet());
        rev.setBkThreeBeginnerSet(rev.getBkThreeArrSet());
        rev.setBkFourBeginnerSet(rev.getBkFourArrSet());

        rev.setBkOneIntermediateSet(rev.getBkOneArrSet());
        rev.setBkTwoIntermediateSet(rev.getBkTwoArrSet());
        rev.setBkThreeIntermediateSet(rev.getBkThreeArrSet());
        rev.setBkFourIntermediateSet(rev.getBkFourArrSet());

        rev.setBkOneAdvancedSet(rev.getBkOneArrSet());
        rev.setBkTwoAdvancedSet(rev.getBkTwoArrSet());
        rev.setBkThreeAdvancedSet(rev.getBkThreeArrSet());
        rev.setBkFourAdvancedSet(rev.getBkFourArrSet());

        rev.setBkOneTwentyBegSet(rev.getBkOneBeginnerArrList());
        rev.setBkTwoTwentyBegSet(rev.getBkTwoBeginnerArrList());
        rev.setBkThreeTwentyBegSet(rev.getBkThreeBeginnerArrList());
        rev.setBkFourTwentyBegSet(rev.getBkFourBeginnerArrList());

        rev.setBkOneTwentyIntermediateSet(rev.getBkOneIntermediateSet());
        rev.setBkTwoTwentyIntermediateSet(rev.getBkTwoIntermediateSet());
        rev.setBkThreeTwentyIntermediateSet(rev.getBkThreeIntermediateSet());
        rev.setBkFourTwentyIntermediateSet(rev.getBkFourIntermediateSet());

        rev.setBkOneTwentyAdvancedSet(rev.getbKOneAdvancedSet());
        rev.setBkTwoTwentyAdvancedSet(rev.getbKTwoAdvancedSet());
        rev.setBkThreeTwentyAdvancedSet(rev.getbKThreeAdvancedSet());
        rev.setBkFourTwentyAdvancedSet(rev.getbKFourAdvancedSet());

    }

        //nlpProcess used to get each lemma form of the text in a ArrayList
        public static ArrayList<java.lang.String> nlpProcess (String chapterized){
            ArrayList<String> allTokensFromFile = new ArrayList<>(); //ArrayList to store iteration output
            //setting up the pipeline for CoreNLP
            Properties propsNLP = new Properties();
            propsNLP.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
            StanfordCoreNLP pipeline2 = new StanfordCoreNLP(propsNLP);
            Annotation document = new Annotation(chapterized);
            pipeline2.annotate(document);
            List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
            StringBuffer currentNER = new StringBuffer();
            String newNERWord;
            StringBuffer previousNERTAG = new StringBuffer();
            for (CoreMap sentence : sentences) {
                for (CoreLabel token2 : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                    String word = token2.get(CoreAnnotations.TextAnnotation.class);
                    String lemma = token2.get(CoreAnnotations.LemmaAnnotation.class);
                    String ne = token2.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                    //if statement to remove any named entity from the below choices from the word choice
                    if (ne.equals("ORGANIZATION") ||
                            ne.equals("NUMBER") ||
                            ne.equals("PERSON") ||
                            ne.equals("LOCATION") ||
                            ne.equals("MISC") ||
                            ne.equals("MONEY") ||
                            ne.equals("ORDINAL") ||
                            ne.equals("PERCENT") ||
                            ne.equals("DATE") ||
                            ne.equals("TIME") ||
                            ne.equals("DURATION") ||
                            ne.equals("SET"))
                    {
                        word = word.trim();
                        word = word.replaceAll(word, "");
                        currentNER.append("" + word);
                        previousNERTAG = previousNERTAG.replace(0, previousNERTAG.length(), ne);
                    } else if ((currentNER.length() != 0)) {
                        newNERWord = currentNER.toString();
                        newNERWord = newNERWord.trim();
                        allTokensFromFile.add(newNERWord); //adding words outside of the NE parameters set
                        currentNER.setLength(0);
                        previousNERTAG = previousNERTAG.replace(0, previousNERTAG.length(), ne);
                        word = word.trim();
                        word.replaceAll("[\\s+]", "");
                        currentNER.append(word);

                        //removes any punctuation from the retrieved words by only adding lemma with more than one character in length.
                    } else {
                        lemma = lemma.toLowerCase();
                        if (lemma.length() != 1) {
                            lemma = lemma.trim();
                            lemma = lemma.replaceAll("[\\s+]", "");
                            allTokensFromFile.add(lemma);
                        }
                    }
                }
            }

            return allTokensFromFile;
        }

        //TODO optimize this for intext example sentence searching
        public static String getSentence(ArrayList<String> lemmatizedArrList, String word){


            Properties propsGetSentence = new Properties();
            propsGetSentence.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
            StanfordCoreNLP pipeline = new StanfordCoreNLP(propsGetSentence);
            Annotation document = new Annotation(lemmatizedArrList.toString());
            pipeline.annotate(document);
            List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

            String inTextSent = " ";
            for (CoreMap sentence:sentences){
                for (CoreLabel textLabel: sentence.get(CoreAnnotations.TokensAnnotation.class)){
                    if (textLabel.word().equals(word)){
                        //System.out.println(sentence);
                        inTextSent.concat("/n");
                        inTextSent.concat(sentence.get(CoreAnnotations.TokensAnnotation.class).toString());
                    }
                }
            }
            return inTextSent;
        }

    public Review getRev() {
        return rev;
    }

    public Book getBook() {
        return bk;
    }

    public tfidfMatrix getTfidf(){
        return tfidf;
    }

}




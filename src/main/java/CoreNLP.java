import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import java.io.*;
import java.util.*;
import java.lang.String;
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
/*
testing area
        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("Vituperata", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "id", "simul");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);
*/

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
        ArrayList emptyList = new ArrayList<String>();
        documents.add(emptyList);


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
            bookOne.setBrokenDownText(nlpProcess((String) bookThreeToList.get(i)));
        }
        documents.add(bookThree.getBrokenDownText());

        Book bookFour = new Book("The Project Gutenberg EBook of The Strange Case Of Dr. Jekyll .txt");
        for (int i = 0; i < bookFourToList.size(); i++) {
            bookFour.setBrokenDownText(nlpProcess((String) bookFourToList.get(i)));
        }
        documents.add(bookFour.getBrokenDownText());

        //TFIDF Calculations
        int tfValue;
        for (ArrayList doc : documents) {
            for (int i = 0; i < doc.size(); i++) {
                calctfidf.mappedTFIDF((String) doc.get(i), calctfidf.tfIdf(doc, documents, (String) doc.get(i)));

                /*
                System.out.println(doc.get(i) + " " + calctfidf.tf(doc, (String) doc.get(i)));
                System.out.println();
                System.out.println((String) doc.get(i) + " " + calctfidf.idf(documents, (String) doc.get(i)));

                 */


            /*
            for (int i = 0; i<doc.size(); i++){
                calctfidf.TFIDFValuesToArrList(calctfidf.tfIdf(doc, documents, (String) doc.get(i)));
                calctfidf.TFIDFStringToArrList((String) doc.get(i));
            }


             */
            }
        }


        //sorting the hashmap of words/TFIDF values.
        /*
        calctfidf.sortedMappedTFIDF = calctfidf.mappedTFIDF
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));


         */
        calctfidf.setSortedMappedTFIDF(calctfidf.mappedTFIDF
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new)));

        calctfidf.setStringTFIDF(calctfidf.getSortedMappedTFIDF().keySet());
        calctfidf.setTFIDFvalues(calctfidf.getSortedMappedTFIDF().values());
        System.out.println("calc tfidf TFIDF str " + calctfidf.getTFIDFValues());
        System.out.println("calc tfidf TFIDF vals " + calctfidf.getTFIDFStrings());

        System.out.println("calc tfidf val at pos 1" + calctfidf.getTFIDFValues().get(1));
        System.out.println("calc tfidf str at pos 1" + calctfidf.getTFIDFStrings().get(1));

        //System.out.println("tfidf sorted map keyset" + calctfidf.getSortedMappedTFIDF().keySet());
        //System.out.println("tfidf sorted map values" + calctfidf.getSortedMappedTFIDF().values());


//testing iterating over a hashmap by indexes
        /*
        for (int i = 0; i < calctfidf.sortedMappedTFIDF.size(); i++) {
            rev.setArrayKeySet(rev.getElementByIndex((LinkedHashMap) calctfidf.sortedMappedTFIDF, i));
        }

         */

        rev.setArrayKeySet(calctfidf.getSortedMappedTFIDF().keySet());
        //System.out.println(rev.getArraySet().get(0));

        rev.setBeginnerSet(rev.getArraySet());
        rev.setIntermediateSet(rev.getArraySet());
        rev.setAdvancedSet(rev.getArraySet());

        rev.setBkOneTwentyBegSet(rev.getBeginnerArrList());
        rev.setBkTwoTwentyBegSet(rev.getBeginnerArrList());
        rev.setBkThreeTwentyBegSet(rev.getBeginnerArrList());
        rev.setBkFourTwentyBegSet(rev.getBeginnerArrList());

        rev.setBkOneTwentyIntermediateSet(rev.getIntermediateSet());
        rev.setBkTwoTwentyIntermediateSet(rev.getIntermediateSet());
        rev.setBkThreeTwentyIntermediateSet(rev.getIntermediateSet());
        rev.setBkFourTwentyIntermediateSet(rev.getIntermediateSet());

        rev.setTwentyAdvancedSet(rev.getAdvancedSet());



        /*
        GUIReview guiReview = new GUIReview();
        guiReview.setArrayKeySet(calctfidf.getSortedMappedTFIDF().keySet());
        guiReview.setBeginnerSet(rev.getArraySet());
        guiReview.setIntermediateSet(rev.getArraySet());
        guiReview.setAdvancedSet(rev.getArraySet());

        guiReview.setBkOneTwentyBegSet(rev.getBeginnerArrList());
        guiReview.setBkOneTwentyIntermediateSet(rev.getIntermediateSet());
        guiReview.setTwentyAdvancedSet(rev.getAdvancedSet());

        for (int i = 0; i < guiReview.getBkOneTwentyBegSet().size(); i++) {
            new GUIReview();
            guiReview.revWord = (String) guiReview.getBkOneTwentyBegSet().get(i);
        }
    }
         */

    }

        //nlpProcess used to get each lemma form of the text in a linkedlist
        public static ArrayList<java.lang.String> nlpProcess (String chapterized){

            ArrayList<String> allTokensFromFile = new ArrayList<>();


            //need to insert a stop words Hashset here.

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
                    // this is the text of the token
                    String word = token2.get(CoreAnnotations.TextAnnotation.class);
//                System.out.println("the word is: " + word);
                    // this is the lemma of the token
                    String lemma = token2.get(CoreAnnotations.LemmaAnnotation.class);
//                System.out.println("lemma of this word is: " + lemma);
                    // this is the POS tag of the token
                    String pos = token2.get(CoreAnnotations.PartOfSpeechAnnotation.class);
//                System.out.println("part of speech of this word is: " + pos);
                    // this is the NER label of the token
                    String ne = token2.get(CoreAnnotations.NamedEntityTagAnnotation.class);
//                System.out.println("NER tag of this word is: " + ne);

                    String pattern = "\\p{Punct}";

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
                            ne.equals("SET")) {
                        word = word.trim();
                        word = word.replaceAll(word, "");
                        currentNER.append("" + word);
                        previousNERTAG = previousNERTAG.replace(0, previousNERTAG.length(), ne);

                        //adding the word from text not matching the above NER criteria to a linked list.
                    } else if ((currentNER.length() != 0)) {
                        newNERWord = currentNER.toString();
                        newNERWord = newNERWord.trim();
                        System.out.println("New NER word is: " + newNERWord);
                        allTokensFromFile.add(newNERWord);
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
            //System.out.println(allTokensFromFile);

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




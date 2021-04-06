import java.util.*;

public class tfidfMatrix {

    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    //mapped TFIDF values global

    public ArrayList<LinkedHashMap<String, Double>> listOfMappedTFIDF = new ArrayList<LinkedHashMap<String, Double>>();

    LinkedHashMap<String, Double> mappedTFIDF = new LinkedHashMap<>();
    LinkedHashMap<String, Double> sortedMappedTFIDF = new LinkedHashMap<>();

    Collection<String> bkOneTFIDFKeys;
    Collection<String> bkTwoTFIDFKeys;
    Collection<String> bkThreeTFIDFKeys;
    Collection<String> bkFourTFIDFKeys;

    Collection<Double> bkOneTFIDFVal;
    Collection<Double> bkTwoTFIDFVal;
    Collection<Double> bkThreeTFIDFVal;
    Collection<Double> bkFourTFIDFVal;


    ArrayList<String> bkOneArrListKeys;
    ArrayList<String> bkTwoArrListKeys;
    ArrayList<String> bkThreeArrListKeys;
    ArrayList<String> bkFourArrListKeys;

    ArrayList<Double> bkOneArrListVals;
    ArrayList<Double> bkTwoArrListVals;
    ArrayList<Double> bkThreeArrListVals;
    ArrayList<Double> bkFourArrListVals;


    public double tf(ArrayList<String> doc, String term) {
        double result = 0;

        for (String word : doc) {
            if (term.equals(word)) {
                result++;
            }
        }
        return result / doc.size();
    }
    public double idf(List<ArrayList<String>> docs, String term) {
        double n = 0;

        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equals(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log10(docs.size()/n);
    }

    public double tfIdf(ArrayList<String> doc, List<ArrayList<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }

    public void mappedTFIDF (String word, double tfidf){
        this.mappedTFIDF.put(word, tfidf);
    }

/*
    public void alterTFIDF (int index, int ease, int book){
        Double currTFIDFval = null;
        if (book == 0) {
            currTFIDFval = bkOneArrListVals.get(index);
        }
        if (book == 1) {
            currTFIDFval = bkTwoArrListVals.get(index);
        }
        if (book == 2) {
            currTFIDFval = bkThreeArrListVals.get(index);
        }
        if (book == 3) {
            currTFIDFval = bkFourArrListVals.get(index);
        } else{
            System.out.println("Book value out of range");
        }

        if (ease == 1){
            newTFIDFval = currTFIDFval*20;
            bkOneArrListVals.get(index).
            //TODO need to consider the multiplier used - used 20, 8 etc for testing purposes.
        }
        if (ease == 2){
            newTFIDFval = currTFIDFval*8;
        }
        if (ease == 3){
            newTFIDFval = currTFIDFval*2;
        } else{
            System.out.println("Ease value out of range");
        }

        TFIDFvalues.set(index, newTFIDFval);
    }


 */
    public Map<String, Double> getMappedTFIDF (){
        return mappedTFIDF;
    }

    public LinkedHashMap<String, Double> getSortedMappedTFIDF(){
        return sortedMappedTFIDF;
    }
/*
    public void reweightValuesEasy(String word, List TFIDFTerms, int book){
        for (int i = 0; i < TFIDFTerms.size(); i++){
            if (TFIDFTerms.get(i).equals(word)){
                alterTFIDF(i, 1, book);
            }

        }
    }



    public void reweightValuesMedium(String word){
        for (int i = 0; i < getTFIDFStrings().size(); i++){
            if (getTFIDFStrings().get(i).equals(word)){
                alterTFIDF(i, 2);
            }
        }
    }

    public void reweightValuesDifficult(String word){
        for (int i = 0; i < getTFIDFStrings().size(); i++){
            if (getTFIDFStrings().get(i).equals(word)){
                alterTFIDF(i, 3);
            }
        }
    }


 */


}


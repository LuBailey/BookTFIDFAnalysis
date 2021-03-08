import java.util.*;

public class tfidfMatrix {

    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
    //mapped TFIDF values global
    LinkedHashMap<String, Double> mappedTFIDF = new LinkedHashMap<>();
    LinkedHashMap<String, Double> sortedMappedTFIDF = new LinkedHashMap<>();
    ArrayList<Set<String>> StringTFIDF = new ArrayList<Set<String>>();
    ArrayList<Double> TFIDFvalues = new ArrayList<>();
    Double newTFIDFval = null;



    public double tf(List<String> doc, String term) {
        double result = 0;

        for (String word : doc) {
            //System.out.println("**Word being analysed**" + word);
            if (term.equals(word)) {
                result++;
            }

        }
        return result / doc.toString().length();
    }

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */

    public double idf(List<ArrayList<String>> docs, String term) {
        double n = 0;

        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */

    public double tfIdf(List<String> doc, List<ArrayList<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);
    }

    public void mappedTFIDF (String word, double tfidf){
        this.mappedTFIDF.put(word, tfidf);
    }
    
    

    public void setStringTFIDF (Set<String> list) {
        for (String word : list) {
            this.StringTFIDF.add(Collections.singleton(word));
        }
    }
    public void setTFIDFvalues (Collection<Double> TFIDF){
        for (Double val: TFIDF){
            this.TFIDFvalues.add(val);
        }
    }

    public void alterTFIDF (int index, int ease){
        Double currTFIDFval = TFIDFvalues.get(index);
        //Double newTFIDFval = null;

        if (ease == 1){
            newTFIDFval = currTFIDFval*20;
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

    public Map<String, Double> getMappedTFIDF (){
        return mappedTFIDF;
    }

    public LinkedHashMap<String, Double> getSortedMappedTFIDF(){
        return sortedMappedTFIDF;
    }

    public void setSortedMappedTFIDF(LinkedHashMap unsortedMap){
        this.sortedMappedTFIDF = unsortedMap;
    }
    public ArrayList<Double> getTFIDFValues(){
        return TFIDFvalues;
    }

    public void reweightValuesEasy(String word){
        for (int i = 0; i < getTFIDFStrings().size(); i++){
            if (getTFIDFStrings().get(i).equals(word)){
                alterTFIDF(i, 1);
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

    public ArrayList<Set<String>> getTFIDFStrings(){
        return StringTFIDF;
    }

    /*
    public int indexOfWord(Set<String> TFIDFStrSet, String word){
        int index = 0;
        for (String strWord: TFIDFStrSet){
            if (TFIDFStrSet.contains(word)){
                index = strWord.
            }
        }
    }

     */
}


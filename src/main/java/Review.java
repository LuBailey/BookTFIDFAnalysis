import java.util.*;

public class Review {

    private ArrayList ArrSet = new ArrayList<String>();

    private ArrayList begSet = new ArrayList<String>();
    private ArrayList intermediateSet = new ArrayList<String>();
    private ArrayList advancedSet = new ArrayList<String>();

    public ArrayList bkOneTwentyBegSet = new ArrayList<String>();
    public ArrayList bkOnetwentyInterSet = new ArrayList<String>();
    public ArrayList bkOnetwentyAdvancedSet = new ArrayList<String>();

    public ArrayList bkTwoTwentyBegSet = new ArrayList<String>();
    public ArrayList bkTwotwentyInterSet = new ArrayList<String>();
    public ArrayList bkTwotwentyAdvancedSet = new ArrayList<String>();

    public ArrayList bkThreeTwentyBegSet = new ArrayList<String>();
    public ArrayList bkThreeTwentyInterSet = new ArrayList<String>();
    public ArrayList bkThreeTwentyAdvancedSet = new ArrayList<String>();

    public ArrayList bkFourTwentyBegSet = new ArrayList<String>();
    public ArrayList bkFourtwentyInterSet = new ArrayList<String>();
    public ArrayList bkFourtwentyAdvancedSet = new ArrayList<String>();


    public void setArrayKeySet (Set sortedMapKey) {
        for (Object word: sortedMapKey){
            this.ArrSet.add(word);
        }
    }

    public void setBeginnerSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrList.size() - sortedArrSizeDivided3;
        //Collections.shuffle(sortedArrList);

        for (int i = startPoint; i < sortedArrList.size(); i++){
            this.begSet.add(sortedArrList.get(i));
        }
    }
    public void setIntermediateSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrList.size() - (sortedArrSizeDivided3*2);

        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < (sortedArrList.size() - sortedArrSizeDivided3); i++){
            this.intermediateSet.add(sortedArrList.get(i));
        }
    }
    public void setAdvancedSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = 0;
        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < sortedArrSizeDivided3; i++){
            this.advancedSet.add(sortedArrList.get(i));
        }
    }

    public void setBkOneTwentyBegSet(ArrayList<String> bookOneinArrList) {
        Collections.shuffle(bookOneinArrList);

        for (int j = 0; j < bookOneinArrList.size(); j++) {
            for (int i = 0; i < begSet.size(); i++) {
                if (bkOneTwentyBegSet.size() == 20) {
                    break;
                }
                if (begSet.get(i).equals(bookOneinArrList.get(j))) {
                    if (bkOneTwentyBegSet.contains(begSet.get(i))) {
                        continue;
                    } else {
                        bkOneTwentyBegSet.add(begSet.get(i));
                    }
                }
            }
        }
    }
    public void setBkTwoTwentyBegSet(ArrayList<String> bookTwoinArrList) {
        Collections.shuffle(bookTwoinArrList);

        for (int j = 0; j < bookTwoinArrList.size(); j++) {
            for (int i = 0; i < begSet.size(); i++) {
                if (bkTwoTwentyBegSet.size() == 20) {
                    break;
                }
                if (begSet.get(i).equals(bookTwoinArrList.get(j))) {
                    if (bkTwoTwentyBegSet.contains(begSet.get(i))) {
                        continue;
                    } else {
                        bkTwoTwentyBegSet.add(begSet.get(i));
                    }
                }
            }
        }
    }
    public void setBkThreeTwentyBegSet(ArrayList<String> bookThreeinArrList) {
        Collections.shuffle(bookThreeinArrList);

        for (int j = 0; j < bookThreeinArrList.size(); j++) {
            for (int i = 0; i < begSet.size(); i++) {
                if (bkThreeTwentyBegSet.size() == 20) {
                    break;
                }
                if (begSet.get(i).equals(bookThreeinArrList.get(j))) {
                    if (bkThreeTwentyBegSet.contains(begSet.get(i))) {
                        continue;
                    } else {
                        bkThreeTwentyBegSet.add(begSet.get(i));
                    }
                }
            }
        }
    }
    public void setBkFourTwentyBegSet(ArrayList<String> bookFourinArrList) {
        Collections.shuffle(bookFourinArrList);

        for (String s : bookFourinArrList) {
            for (int i = 0; i < begSet.size(); i++) {
                if (bkFourTwentyBegSet.size() == 20) {
                    break;
                }
                if (begSet.get(i).equals(s)) {
                    if (bkFourTwentyBegSet.contains(begSet.get(i))) {
                        continue;
                    } else {
                        bkFourTwentyBegSet.add(begSet.get(i));
                    }
                }
            }
        }
    }

    public void setBkOneTwentyIntermediateSet(ArrayList<String> bookOneinArrList) {
        Collections.shuffle(bookOneinArrList);
        for (String s : bookOneinArrList) {
            for (Object o : intermediateSet) {
                if (bkOnetwentyInterSet.size() == 20) {
                    break;
                }
                if (o.equals(s)) {
                    if (bkOnetwentyInterSet.contains(o)) {
                        continue;
                    } else {
                        bkOnetwentyInterSet.add(o);
                    }

                }
            }
        }
    }

    public void setBkTwoTwentyIntermediateSet(ArrayList<String> bookTwoinArrList) {
        Collections.shuffle(bookTwoinArrList);
        for (String s : bookTwoinArrList) {
            for (Object o : intermediateSet) {
                if (bkTwotwentyInterSet.size() == 20) {
                    break;
                }
                if (o.equals(s)) {
                    if (bkTwotwentyInterSet.contains(o)) {
                        continue;
                    } else {
                        bkTwotwentyInterSet.add(o);
                    }

                }
            }
        }
    }

    public void setBkThreeTwentyIntermediateSet(ArrayList<String> bookThreeinArrList) {
        Collections.shuffle(bookThreeinArrList);
        for (String s : bookThreeinArrList) {
            for (Object o : intermediateSet) {
                if (bkThreeTwentyInterSet.size() == 20) {
                    break;
                }
                if (o.equals(s)) {
                    if (bkThreeTwentyInterSet.contains(o)) {
                        continue;
                    } else {
                        bkThreeTwentyInterSet.add(o);
                    }

                }
            }
        }
    }

    public void setBkFourTwentyIntermediateSet(ArrayList<String> bookFourinArrList) {
        Collections.shuffle(bookFourinArrList);
        for (String s : bookFourinArrList) {
            for (Object o : intermediateSet) {
                if (bkFourtwentyInterSet.size() == 20) {
                    break;
                }
                if (o.equals(s)) {
                    if (bkFourtwentyInterSet.contains(o)) {
                        continue;
                    } else {
                        bkFourtwentyInterSet.add(o);
                    }

                }
            }
        }
    }

    public void setTwentyAdvancedSet(ArrayList<String> bookOneinArrList) {
        Collections.shuffle(bookOneinArrList);

        for (int j = 0; j < bookOneinArrList.size(); j++) {
            for (int i = 0; i < advancedSet.size(); i++) {
                if (bkOnetwentyAdvancedSet.size() == 20) {
                    break;
                }
                if (advancedSet.get(i).equals(bookOneinArrList.get(j))) {
                    if (bkOnetwentyAdvancedSet.contains(advancedSet.get(i))) {
                        continue;
                    } else {
                        bkOnetwentyAdvancedSet.add(advancedSet.get(i));
                    }

                }
            }
        }
    }

    public ArrayList getBeginnerArrList() {
        return begSet;
    }
    public ArrayList getIntermediateSet(){
        return intermediateSet;
    }
    public ArrayList getAdvancedSet(){
        return advancedSet;
    }

    public ArrayList getBkOneTwentyBegSet(){
        return bkOneTwentyBegSet;
    }
    public ArrayList getBkOneTwentyInterSet(){
        return bkOnetwentyInterSet;
    }
    public ArrayList getBkOneTwentyAdvancedSet(){
        return bkOnetwentyAdvancedSet;
    }

    public ArrayList getBkTwoTwentyBegSet(){
        return bkTwoTwentyBegSet;
    }
    public ArrayList getBkTwoTwentyInterSet(){
        return bkTwotwentyInterSet;
    }
    public ArrayList getBkTwoTwentyAdvancedSet(){
        return bkTwotwentyAdvancedSet;
    }

    public ArrayList getBkThreeTwentyBegSet(){
        return bkThreeTwentyBegSet;
    }
    public ArrayList getBkThreeTwentyInterSet(){
        return bkThreeTwentyInterSet;
    }
    public ArrayList getBkThreeTwentyAdvancedSet(){
        return bkThreeTwentyAdvancedSet;
    }

    public ArrayList getBkFourTwentyBegSet(){
        return bkFourTwentyBegSet;
    }
    public ArrayList getBkFourTwentyInterSet(){
        return bkFourtwentyInterSet;
    }
    public ArrayList getBkFourTwentyAdvancedSet(){
        return bkFourtwentyAdvancedSet;
    }


    public ArrayList getArraySet(){
        return ArrSet;
    }

}
import java.util.*;

public class Review {

    private ArrayList bkOneArrSet = new ArrayList<String>();
    private ArrayList bkTwoArrSet = new ArrayList<String>();
    private ArrayList bkThreeArrSet = new ArrayList<String>();
    private ArrayList bkFourArrSet = new ArrayList<String>();

    public ArrayList bKOneBegSet = new ArrayList<String>();
    public ArrayList bKTwoBegSet = new ArrayList<String>();
    public ArrayList bKThreeBegSet = new ArrayList<String>();
    public ArrayList bKFourBegSet = new ArrayList<String>();

    public ArrayList bKOneIntermediateSet = new ArrayList<String>();
    public ArrayList bKTwoIntermediateSet = new ArrayList<String>();
    public ArrayList bKThreeIntermediateSet = new ArrayList<String>();
    public ArrayList bKFourIntermediateSet = new ArrayList<String>();

    public ArrayList bKOneAdvancedSet = new ArrayList<String>();
    public ArrayList bKTwoAdvancedSet = new ArrayList<String>();
    public ArrayList bKThreeAdvancedSet = new ArrayList<String>();
    public ArrayList bKFourAdvancedSet = new ArrayList<String>();


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


    public void setBkOneArrayKeySet (Set sortedMapKey) {
        for (Object word: sortedMapKey){
            this.bkOneArrSet.add(word);
        }
    }
    public void setBkTwoArrayKeySet (Set sortedMapKey) {
        for (Object word: sortedMapKey){
            this.bkTwoArrSet.add(word);
        }
    }
    public void setBkThreeArrayKeySet (Set sortedMapKey) {
        for (Object word: sortedMapKey){
            this.bkThreeArrSet.add(word);
        }
    }
    public void setBkFourArrayKeySet (Set sortedMapKey) {
        for (Object word: sortedMapKey){
            this.bkFourArrSet.add(word);
        }
    }

    public void setBkOneBeginnerSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3*2;

        for (int i = startPoint; i < sortedArrList.size(); i++){
            this.bKOneBegSet.add(sortedArrList.get(i));
        }
    }
    public void setBkTwoBeginnerSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3*2;
        //Collections.shuffle(sortedArrList);

        for (int i = startPoint; i < sortedArrList.size(); i++){
            this.bKTwoBegSet.add(sortedArrList.get(i));
        }
    }
    public void setBkThreeBeginnerSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3*2;
        //Collections.shuffle(sortedArrList);

        for (int i = startPoint; i < sortedArrList.size(); i++){
            this.bKThreeBegSet.add(sortedArrList.get(i));
        }
    }
    public void setBkFourBeginnerSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3*2;
        //Collections.shuffle(sortedArrList);

        for (int i = startPoint; i < sortedArrList.size(); i++){
            this.bKFourBegSet.add(sortedArrList.get(i));
        }
    }

    public void setBkOneIntermediateSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3;

        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < (sortedArrSizeDivided3*2); i++){
            this.bKOneIntermediateSet.add(sortedArrList.get(i));
        }
    }
    public void setBkTwoIntermediateSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3;

        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < (sortedArrSizeDivided3*2); i++){
            this.bKTwoIntermediateSet.add(sortedArrList.get(i));
        }
    }
    public void setBkThreeIntermediateSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3;

        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < (sortedArrSizeDivided3*2); i++){
            this.bKThreeIntermediateSet.add(sortedArrList.get(i));
        }
    }
    public void setBkFourIntermediateSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = sortedArrSizeDivided3;

        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < (sortedArrSizeDivided3*2); i++){
            this.bKFourIntermediateSet.add(sortedArrList.get(i));
        }
    }

    public void setBkOneAdvancedSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = 0;
        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < sortedArrSizeDivided3; i++){
            this.bKOneAdvancedSet.add(sortedArrList.get(i));
        }
    }
    public void setBkTwoAdvancedSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = 0;
        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < sortedArrSizeDivided3; i++){
            this.bKTwoAdvancedSet.add(sortedArrList.get(i));
        }
    }
    public void setBkThreeAdvancedSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = 0;
        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < sortedArrSizeDivided3; i++){
            this.bKThreeAdvancedSet.add(sortedArrList.get(i));
        }
    }
    public void setBkFourAdvancedSet(ArrayList sortedArrList){

        int sortedArrSizeDivided3 = sortedArrList.size()/3;
        int startPoint = 0;
        //Collections.shuffle(Collections.singletonList(sortedArrList));

        for (int i = startPoint; i < sortedArrSizeDivided3; i++){
            this.bKFourAdvancedSet.add(sortedArrList.get(i));
        }
    }

    public void setBkOneTwentyBegSet(ArrayList<String> bookOneinArrList) {
        Collections.shuffle(bookOneinArrList);

        for (int j = 0; j < bookOneinArrList.size(); j++) {
                if (bkOneTwentyBegSet.size() == 20) {
                    break;
                }else{
                    bkOneTwentyBegSet.add(bookOneinArrList.get(j));
                }
        }
    }
    public void setBkTwoTwentyBegSet(ArrayList<String> bookTwoinArrList) {
        Collections.shuffle(bookTwoinArrList);

        for (int j = 0; j < bookTwoinArrList.size(); j++) {
            if (bkTwoTwentyBegSet.size() == 20) {
                break;
            } else {
                bkTwoTwentyBegSet.add(bKTwoBegSet.get(j));
            }
        }
    }

    public void setBkThreeTwentyBegSet(ArrayList<String> bookThreeinArrList) {
        Collections.shuffle(bookThreeinArrList);

        for (int j = 0; j < bookThreeinArrList.size(); j++) {
            if (bkThreeTwentyBegSet.size() == 20) {
                break;
            } else {
                bkThreeTwentyBegSet.add(bKThreeBegSet.get(j));
            }
        }
    }

    public void setBkFourTwentyBegSet(ArrayList<String> bookFourinArrList) {
        Collections.shuffle(bookFourinArrList);

        for (String s : bookFourinArrList) {
            for (int i = 0; i < bKFourBegSet.size(); i++) {
                if (bkFourTwentyBegSet.size() == 20) {
                    break;
                }
                if (bKFourBegSet.get(i).equals(s)) {
                    if (bkFourTwentyBegSet.contains(bKFourBegSet.get(i))) {
                        continue;
                    } else {
                        bkFourTwentyBegSet.add(bKFourBegSet.get(i));
                    }
                }
            }
        }
    }

    public void setBkOneTwentyIntermediateSet(ArrayList<String> bookOneinArrList) {
        Collections.shuffle(bookOneinArrList);
        for (String s : bookOneinArrList) {
            for (Object o : bKOneIntermediateSet) {
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
            for (Object o : bKTwoIntermediateSet) {
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
            for (Object o : bKThreeIntermediateSet) {
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
            for (Object o : bKFourIntermediateSet) {
                if (bkFourtwentyInterSet.size() == 20) {
                    break;
                }
                bkFourtwentyInterSet.add(o);
            }
        }
    }

    public void setBkOneTwentyAdvancedSet(ArrayList<String> bookOneinArrList) {
        Collections.shuffle(bookOneinArrList);

        for (int j = 0; j < bookOneinArrList.size(); j++) {
                if (bkOnetwentyAdvancedSet.size() == 20) {
                    break;
                } else{bkOnetwentyAdvancedSet.add(bookOneinArrList.get(j));
            }
        }
    }
    public void setBkTwoTwentyAdvancedSet(ArrayList<String> bookTwoinArrList) {
        Collections.shuffle(bookTwoinArrList);

        for (int j = 0; j < bookTwoinArrList.size(); j++) {
                if (bkTwotwentyAdvancedSet.size() == 20) {
                    break;
                }else{bkTwotwentyAdvancedSet.add(bookTwoinArrList.get(j));
            }
        }
    }
    public void setBkThreeTwentyAdvancedSet(ArrayList<String> bookThreeinArrList) {
        Collections.shuffle(bookThreeinArrList);

        for (int j = 0; j < bookThreeinArrList.size(); j++) {
                if (bkThreeTwentyAdvancedSet.size() == 20) {
                    break;
                } else {bkThreeTwentyAdvancedSet.add(bookThreeinArrList.get(j));
            }
        }
    }
    public void setBkFourTwentyAdvancedSet(ArrayList<String> bookFourinArrList) {
        Collections.shuffle(bookFourinArrList);

        for (int j = 0; j < bookFourinArrList.size(); j++) {
                if (bkFourtwentyAdvancedSet.size() == 20) {
                    break;
                } else {bkFourtwentyAdvancedSet.add(bookFourinArrList.get(j));
            }
        }
    }

    public ArrayList getBkOneBeginnerArrList() {
        return bKOneBegSet;
    }
    public ArrayList getBkTwoBeginnerArrList() {
        return bKTwoBegSet;
    }
    public ArrayList getBkThreeBeginnerArrList() {
        return bKThreeBegSet;
    }
    public ArrayList getBkFourBeginnerArrList() {
        return bKFourBegSet;
    }
    public ArrayList getBkOneIntermediateSet(){
        return bKOneIntermediateSet;
    }
    public ArrayList getBkTwoIntermediateSet(){
        return bKTwoIntermediateSet;
    }
    public ArrayList getBkThreeIntermediateSet(){
        return bKThreeIntermediateSet;
    }
    public ArrayList getBkFourIntermediateSet(){
        return bKFourIntermediateSet;
    }

    public ArrayList getbKOneAdvancedSet(){
        return bKOneAdvancedSet;
    }
    public ArrayList getbKTwoAdvancedSet(){
        return bKTwoAdvancedSet;
    }
    public ArrayList getbKThreeAdvancedSet(){
        return bKThreeAdvancedSet;
    }
    public ArrayList getbKFourAdvancedSet(){
        return bKFourAdvancedSet;
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


    public ArrayList getBkOneArrSet(){
        return bkOneArrSet;
    }

    public ArrayList getBkTwoArrSet(){
        return bkTwoArrSet;
    }

    public ArrayList getBkThreeArrSet(){
        return bkThreeArrSet;
    }

    public ArrayList getBkFourArrSet(){
        return bkFourArrSet;
    }

}
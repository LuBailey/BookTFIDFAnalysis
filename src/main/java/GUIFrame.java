import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIFrame extends JFrame{

    JPanel panel1 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JPanel panel1BkOneSub = new JPanel();
    JPanel panel1BkTwoSub = new JPanel();
    JPanel panel1BkThreeSub = new JPanel();
    JPanel panel1BkFourSub = new JPanel();

    JButton easy = new JButton();
    JButton medium = new JButton();
    JButton difficult = new JButton();
    WebLookup webLookup = new WebLookup();
    CoreNLP obj = new CoreNLP();
    Review rev = obj.getRev();

    //loop for the rev word
    public String currRevWord = "";
    int index = 1;

    public void setCurrRevWord(String revWord){
        this.currRevWord = revWord;
    }

    public String getCurrRevWord(){
        return currRevWord;
    }

    GUIFrame() {
        //new CoreNLP();

        /*
        ImageIcon imageIcon = new ImageIcon("image0.jpg");
        Image imgIconSize = imageIcon.getImage();
        Image newImg = imgIconSize.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledImgIcon = new ImageIcon(newImg);
        */

        BorderLayout borderLayoutMnger = new BorderLayout();

        panel1.setBackground(Color.DARK_GRAY);
        panel1.setBounds(0, 0, 300, 300);
        panel1.setVisible(true);

        panel1BkOneSub.setBackground(Color.DARK_GRAY);
        panel1BkOneSub.setBounds(0, 0, 300, 300);
        panel1BkOneSub.setVisible(false);

        panel1BkTwoSub.setBackground(Color.DARK_GRAY);
        panel1BkTwoSub.setBounds(0, 0, 300, 300);
        panel1BkTwoSub.setVisible(false);

        panel1BkThreeSub.setBackground(Color.DARK_GRAY);
        panel1BkThreeSub.setBounds(0, 0, 300, 300);
        panel1BkThreeSub.setVisible(false);

        panel1BkFourSub.setBackground(Color.DARK_GRAY);
        panel1BkFourSub.setBounds(0, 0, 300, 300);
        panel1BkFourSub.setVisible(false);

        //panel2.setBackground(Color.blue);
        //panel2.setBounds(0, 300, 300, 300);

        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.setBounds(300, 0, 300, 300);
        panel3.setLayout(borderLayoutMnger);

        panel4.setBackground(Color.WHITE);
        panel4.setBounds(0, 300, 600, 300);

        panel5.setBackground(Color.GRAY);
        panel5.setBounds(0, 600, 600, 100);
        panel5.setVisible(false);

        //adding the review word
        JLabel labelRevWord = new JLabel();
        labelRevWord.setVisible(false);

        JLabel labelRevWordInTextSent = new JLabel();
        labelRevWordInTextSent.setVisible(false);

        JTextArea wrappedText = new JTextArea();
        wrappedText.setBackground(Color.WHITE);
        //wrappedText.setFont(Font.getFont("Times New Roman"));
        //wrappedText.setWrapStyleWord(true);
        //wrappedText.setLineWrap(true);
        wrappedText.setBounds(20, 20, 560, 260);
        wrappedText.setLineWrap(true);
        wrappedText.setWrapStyleWord(true);
        wrappedText.setFont(new Font("Calbri", Font.PLAIN, 10));

        JButton home = new JButton();
        home.setText("Home");
        home.setBounds(100, 200, 50, 50);
        home.addActionListener(e -> {
            new GUI();
            /*
            panel1.setVisible(true);
            panel1BkOneSub.setVisible(false);
            panel1BkTwoSub.setVisible(false);
            panel1BkThreeSub.setVisible(false);
            panel1BkFourSub.setVisible(false);

             */
        });

        JButton buttonRevBkOne = new JButton();
        buttonRevBkOne.setText("Review Book One");
        buttonRevBkOne.setBounds(100, 50, 50, 50);
        buttonRevBkOne.addActionListener(e -> {
            panel1.setVisible(false);
            panel1BkOneSub.setVisible(true);
        });

        JButton revBkOneEasy = new JButton();
        revBkOneEasy.setText("Review easy words");
        revBkOneEasy.setBounds(100, 50, 50, 50);
        revBkOneEasy.addActionListener(e -> {
            this.currRevWord = (String) rev.getBkOneTwentyBegSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkOneArrSet().indexOf(currRevWord) + " / " + rev.getBkOneArrSet().size() + "</div></html>");

            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);
            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkOneInter = new JButton();
        revBkOneInter.setText("Review intermediate words");
        revBkOneInter.setBounds(100, 100, 50, 50);
        revBkOneInter.addActionListener(e -> {

            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkOneTwentyInterSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkOneArrSet().indexOf(currRevWord) + " / " + rev.getBkOneArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkOneDiff = new JButton();
        revBkOneDiff.setText("Review difficult words");
        revBkOneDiff.setBounds(100, 150, 50, 50);
        revBkOneDiff.addActionListener(e -> {
            this.currRevWord = (String) rev.getBkOneTwentyAdvancedSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkOneArrSet().indexOf(currRevWord) + " / " + rev.getBkOneArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show
        });


        JButton buttonRevBkTwo = new JButton();
        buttonRevBkTwo.setText("Review Book Two");
        buttonRevBkTwo.setBounds(100, 100, 50, 50);
        buttonRevBkTwo.addActionListener(e -> {
            panel1.setVisible(false);
            panel1BkTwoSub.setVisible(true);
        });

        JButton revBkTwoEasy = new JButton();
        revBkTwoEasy.setText("Review easy words");
        revBkTwoEasy.setBounds(100, 50, 50, 50);
        revBkTwoEasy.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkTwoTwentyBegSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkTwoArrSet().indexOf(currRevWord) + " / " + rev.getBkTwoArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show
        });

        JButton revBkTwoInter = new JButton();
        revBkTwoInter.setText("Review intermediate words");
        revBkTwoInter.setBounds(100, 50, 50, 50);
        revBkTwoInter.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkTwoTwentyInterSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkTwoArrSet().indexOf(currRevWord) + " / " + rev.getBkTwoArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkTwoDiff = new JButton();
        revBkTwoDiff.setText("Review difficult words");
        revBkTwoDiff.setBounds(100, 50, 50, 50);
        revBkTwoDiff.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkTwoTwentyAdvancedSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkTwoArrSet().indexOf(currRevWord) + " / " + rev.getBkTwoArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });


        JButton buttonRevBkThree = new JButton();
        buttonRevBkThree.setText("Review Book Three");
        buttonRevBkThree.setBounds(100, 150, 50, 50);
        buttonRevBkThree.addActionListener(e -> {
            panel1.setVisible(false);
            panel1BkThreeSub.setVisible(true);

        });

        JButton revBkThreeEasy = new JButton();
        revBkThreeEasy.setText("Review easy words");
        revBkThreeEasy.setBounds(100, 50, 50, 50);
        revBkThreeEasy.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkThreeTwentyBegSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkThreeArrSet().indexOf(currRevWord) + " / " + rev.getBkThreeArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkThreeInter = new JButton();
        revBkThreeInter.setText("Review intermediate words");
        revBkThreeInter.setBounds(100, 50, 50, 50);
        revBkThreeInter.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkThreeTwentyInterSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkThreeArrSet().indexOf(currRevWord) + " / " + rev.getBkThreeArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkThreeDiff = new JButton();
        revBkThreeDiff.setText("Review difficult words");
        revBkThreeDiff.setBounds(100, 50, 50, 50);
        revBkThreeDiff.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkThreeTwentyAdvancedSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkThreeArrSet().indexOf(currRevWord) + " / " + rev.getBkThreeArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });


        JButton buttonRevBkFour = new JButton();
        buttonRevBkFour.setText("Review Book Four");
        buttonRevBkFour.setBounds(100, 200, 50, 50);
        buttonRevBkFour.addActionListener(e -> {
            panel1.setVisible(false);
            panel1BkFourSub.setVisible(true);
        });

        JButton revBkFourEasy = new JButton();
        revBkFourEasy.setText("Review easy words");
        revBkFourEasy.setBounds(100, 50, 50, 50);
        revBkFourEasy.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkFourTwentyBegSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkFourArrSet().indexOf(currRevWord) + " / " + rev.getBkFourArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkFourInter = new JButton();
        revBkFourInter.setText("Review intermediate words");
        revBkFourInter.setBounds(100, 50, 50, 50);
        revBkFourInter.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkFourTwentyInterSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkFourArrSet().indexOf(currRevWord) + " / " + rev.getBkFourArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        JButton revBkFourDiff = new JButton();
        revBkFourDiff.setText("Review difficult words");
        revBkFourDiff.setBounds(100, 50, 50, 50);
        revBkFourDiff.addActionListener(e -> {
            //this.currRevWord = (String) rev.bkOneTwentyBegSet.get(index);
            this.currRevWord = (String) rev.getBkFourTwentyAdvancedSet().get(index);
            labelRevWord.setText("<html><div style='text-align: center;'>" + currRevWord + "<br/>" + " Current Index: " + rev.getBkFourArrSet().indexOf(currRevWord) + " / " + rev.getBkFourArrSet().size() + "</div></html>");
            labelRevWord.setVisible(true);
            //labelRevWordInTextSent.setText(obj.getSentence(obj.rev.getArraySet(), currRevWord));
            //labelRevWordInTextSent.setVisible(true);

            try {
                wrappedText.setText(webLookup.definition(currRevWord));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            panel5.setVisible(true); // makes buttons at the bottom of the GUI show

        });

        easy.setText("Easy");
        easy.setBounds(50, 600, 50, 50);
        easy.addActionListener(e -> {
            index++;
            if (obj.getRev().getBkOneArrSet().contains(currRevWord)) {
                if (obj.getRev().getBkOneBeginnerArrList().contains(currRevWord)) {
                    obj.getRev().bKOneBegSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book One has been removed from beginner level.");
                }
                if (obj.getRev().getBkOneIntermediateSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKOneIntermediateSet.indexOf(currRevWord);
                    obj.getRev().bKOneBegSet.add(currRevWord);
                    obj.getRev().bKOneIntermediateSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book One has been moved to beginner level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKOneIntermediateSet.size() + "\n" + "Beginner index: " + obj.getRev().bKOneBegSet.indexOf(currRevWord) + " / " + obj.getRev().bKOneBegSet.size());
                }
                if (obj.getRev().getbKOneAdvancedSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKOneAdvancedSet.indexOf(currRevWord);
                    obj.getRev().bKOneIntermediateSet.add(currRevWord);
                    obj.getRev().bKOneAdvancedSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book One has been moved to intermediate level. " + "\n" + "Advanced level index: " + prevIndex + " / " + obj.getRev().bKOneAdvancedSet.size()+ "\n" +  "intermediate level index: " + obj.getRev().bKOneIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKOneIntermediateSet.size());
                }
            }
            if (obj.getRev().getBkTwoArrSet().contains(currRevWord)) {
                if (obj.getRev().getBkTwoBeginnerArrList().contains(currRevWord)) {
                    obj.getRev().bKTwoBegSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Two has been removed from beginner level");
                }
                if (obj.getRev().getBkTwoIntermediateSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKTwoIntermediateSet.indexOf(currRevWord);
                    obj.getRev().bKTwoBegSet.add(currRevWord);
                    obj.getRev().bKTwoIntermediateSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Two has been moved to beginner level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKTwoIntermediateSet.size() + "\n" + "Beginner index: " + obj.getRev().bKTwoBegSet.indexOf(currRevWord) + " / " + obj.getRev().bKTwoBegSet.size());
                }
                if (obj.getRev().getbKTwoAdvancedSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKTwoAdvancedSet.indexOf(currRevWord);
                    obj.getRev().bKTwoIntermediateSet.add(currRevWord);
                    obj.getRev().bKTwoAdvancedSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Two has been moved to intermediate level. " + "\n" + "Advanced level index: " + prevIndex + " / " + obj.getRev().bKTwoAdvancedSet.size()+ "\n" +  "intermediate level index: " + obj.getRev().bKTwoIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKTwoIntermediateSet.size());
                }
            }
            if (obj.getRev().getBkThreeArrSet().contains(currRevWord)) {
                if (obj.getRev().getBkThreeBeginnerArrList().contains(currRevWord)) {
                    obj.getRev().bKThreeBegSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Three has been removed from beginner level.");
                }
                if (obj.getRev().getBkThreeIntermediateSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKThreeIntermediateSet.indexOf(currRevWord);
                    obj.getRev().bKThreeBegSet.add(currRevWord);
                    obj.getRev().bKThreeIntermediateSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Three has been moved to beginner level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKThreeIntermediateSet.size() + "\n" + "Beginner index: " + obj.getRev().bKThreeBegSet.indexOf(currRevWord) + " / " + obj.getRev().bKThreeIntermediateSet.size());
                }
                if (obj.getRev().getbKThreeAdvancedSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKThreeAdvancedSet.indexOf(currRevWord);
                    obj.getRev().bKThreeIntermediateSet.add(currRevWord);
                    obj.getRev().bkThreeTwentyAdvancedSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Three has been moved to intermediate level. " + "\n" + "Advanced level index: " + prevIndex + " / " + obj.getRev().bKThreeAdvancedSet.size()+ "\n" +  "intermediate level index: " + obj.getRev().bKThreeIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKThreeIntermediateSet.size());
                }
            }
            if (obj.getRev().getBkFourArrSet().contains(currRevWord)) {
                if (obj.getRev().getBkFourBeginnerArrList().contains(currRevWord)) {
                    obj.getRev().bKFourBegSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Four has been removed from beginner level.");
                }
                if (obj.getRev().getBkFourIntermediateSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKFourIntermediateSet.indexOf(currRevWord);
                    obj.getRev().bKFourBegSet.add(currRevWord);
                    obj.getRev().bKFourIntermediateSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Four has been moved to beginner level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKFourIntermediateSet.size() + "\n" + "Beginner index: " + obj.getRev().bKFourBegSet.indexOf(currRevWord) + " / " + obj.getRev().bKFourBegSet.size());
                }
                if (obj.getRev().getbKFourAdvancedSet().contains(currRevWord)) {
                    int prevIndex = obj.getRev().bKFourAdvancedSet.indexOf(currRevWord);
                    obj.getRev().bKFourIntermediateSet.add(currRevWord);
                    obj.getRev().bKTwoAdvancedSet.remove(currRevWord);
                    JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Four has been moved to intermediate level. " + "\n" + "Advanced level index: " + prevIndex + " / " + obj.getRev().bKFourAdvancedSet.size()+ "\n" +  "intermediate level index: " + obj.getRev().bKFourIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKFourIntermediateSet.size());
                }
            }
        });

        medium.setText("Medium");
        medium.setBounds(150, 600, 50, 50);
        medium.addActionListener(e -> {
            //WebLookup webLookup = new WebLookup();
            //webLookup.definition(revWord);
            //TODO also need to addin in-text examples sentences here.
            index++;
        });

        difficult.setText("Difficult");
        difficult.setBounds(250, 600, 50, 50);
        difficult.addActionListener(e -> {
            index++;
            if (obj.getRev().getBkOneArrSet().contains(currRevWord)) {

                        if (obj.getRev().getbKOneAdvancedSet().contains(currRevWord)) {
                            obj.getRev().bKOneAdvancedSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book One has been removed from advanced level");

                        }
                        if (obj.getRev().getBkOneIntermediateSet().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKOneIntermediateSet.indexOf(currRevWord);
                            obj.getRev().bKOneAdvancedSet.add(currRevWord);
                            obj.getRev().bKOneIntermediateSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book One has been moved to advanced level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKOneIntermediateSet.size() + "\n" + "Advanced index: " + obj.getRev().bKOneAdvancedSet.indexOf(currRevWord) + " / " + obj.getRev().bKOneAdvancedSet.size());
                        }

                        if (obj.getRev().getBkOneBeginnerArrList().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKOneBegSet.indexOf(currRevWord);
                            obj.getRev().bKOneIntermediateSet.add(currRevWord);
                            obj.getRev().bKOneBegSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book One has been moved to intermediate level. " + "\n" + "Beginner level index: " + prevIndex + " / " + obj.getRev().bKOneBegSet.size() + "\n" + "Intermediate index: " + obj.getRev().bKOneIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKOneIntermediateSet.size());
                        }
                    }
            if (obj.getRev().getBkTwoArrSet().contains(currRevWord)) {
                        if (obj.getRev().getbKTwoAdvancedSet().contains(currRevWord)) {
                            obj.getRev().bKTwoAdvancedSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Two has been removed from advanced level");

                        }
                        if (obj.getRev().getBkTwoIntermediateSet().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKTwoIntermediateSet.indexOf(currRevWord);
                            obj.getRev().bKTwoAdvancedSet.add(currRevWord);
                            obj.getRev().bKTwoIntermediateSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Two has been moved to advanced level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKTwoIntermediateSet.size() + "\n" + "Advanced index: " + obj.getRev().bKTwoAdvancedSet.indexOf(currRevWord) + " / " + obj.getRev().bKTwoAdvancedSet.size());
                        }

                        if (obj.getRev().getBkTwoBeginnerArrList().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKTwoBegSet.indexOf(currRevWord);
                            obj.getRev().bKTwoIntermediateSet.add(currRevWord);
                            obj.getRev().bKTwoBegSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Two has been moved to intermediate level. " + "\n" + "Beginner level index: " + prevIndex + " / " + obj.getRev().bKTwoBegSet.size() + "\n" + "Intermediate index: " + obj.getRev().bKTwoIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKTwoIntermediateSet.size());
                        }
                    }
            if (obj.getRev().getBkThreeArrSet().contains(currRevWord)) {
                        if (obj.getRev().getbKThreeAdvancedSet().contains(currRevWord)) {
                            obj.getRev().bKTwoAdvancedSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Three has been removed from advanced level");

                        }
                        if (obj.getRev().getBkThreeIntermediateSet().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKThreeIntermediateSet.indexOf(currRevWord);
                            obj.getRev().bKThreeAdvancedSet.add(currRevWord);
                            obj.getRev().bKThreeIntermediateSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Three has been moved to advanced level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKThreeIntermediateSet.size() + "\n" + "Advanced index: " + obj.getRev().bKThreeAdvancedSet.indexOf(currRevWord) + " / " + obj.getRev().bKThreeAdvancedSet.size());
                        }

                        if (obj.getRev().getBkThreeBeginnerArrList().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKThreeBegSet.indexOf(currRevWord);
                            obj.getRev().bKThreeIntermediateSet.add(currRevWord);
                            obj.getRev().bKThreeBegSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Three has been moved to intermediate level. " + "\n" + "Beginner level index: " + prevIndex + " / " + obj.getRev().bKThreeBegSet.size() + "\n" + "Intermediate index: " + obj.getRev().bKThreeIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKThreeIntermediateSet.size());
                        }
                    }
            if (obj.getRev().getBkFourArrSet().contains(currRevWord)) {
                        if (obj.getRev().getbKFourAdvancedSet().contains(currRevWord)) {
                            obj.getRev().bKFourAdvancedSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Four has been removed from advanced level");

                        }
                        if (obj.getRev().getBkFourIntermediateSet().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKFourIntermediateSet.indexOf(currRevWord);
                            obj.getRev().bKFourAdvancedSet.add(currRevWord);
                            obj.getRev().bKFourIntermediateSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Four has been moved to advanced level. " + "\n" + "Intermediate level index: " + prevIndex + " / " + obj.getRev().bKFourIntermediateSet.size() + "\n" + "Advanced index: " + obj.getRev().bKFourAdvancedSet.indexOf(currRevWord) + " / " + obj.getRev().bKFourAdvancedSet.size());
                        }

                        if (obj.getRev().getBkFourBeginnerArrList().contains(currRevWord)) {
                            int prevIndex = obj.getRev().bKFourBegSet.indexOf(currRevWord);
                            obj.getRev().bKFourIntermediateSet.add(currRevWord);
                            obj.getRev().bKFourBegSet.remove(currRevWord);
                            JOptionPane.showMessageDialog(null, "'" + currRevWord + "'" + " in Book Four has been moved to intermediate level. " + "\n" + "Beginner level index: " + prevIndex + " / " + obj.getRev().bKFourBegSet.size() + "\n" + "Intermediate index: " + obj.getRev().bKFourIntermediateSet.indexOf(currRevWord) + " / " + obj.getRev().bKFourIntermediateSet.size());
                        }
                    }
        });

        JFrame frame = new JFrame();
        //ImageIcon image = new ImageIcon("book-imageIcon.png");
        //frame.setIconImage(image.getImage());
        frame.setTitle("Honyomi");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setResizable(true);
        frame.setSize(600, 700);
        frame.setVisible(true);
        //frame.setContentPane(label0);
        frame.setLayout(null);
        //frame.setLayout(new GridBagLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        //gbc.gridwidth = GridBagConstraints.REMAINDER;

        //frame.add(buttonBkOneTxt, gbc);
        //frame.add(buttonRevBkOne, gbc);
        //panel1.add(buttonBkOneTxt);
        panel1.add(buttonRevBkOne);
        panel1.add(buttonRevBkTwo);
        panel1.add(buttonRevBkThree);
        panel1.add(buttonRevBkFour);

        frame.add(panel1);

        panel1BkOneSub.add(revBkOneEasy);
        panel1BkOneSub.add(revBkOneInter);
        panel1BkOneSub.add(revBkOneDiff);
        panel1BkOneSub.add(home);

        panel1BkTwoSub.add(home);
        panel1BkTwoSub.add(revBkTwoEasy);
        panel1BkTwoSub.add(revBkTwoInter);
        panel1BkTwoSub.add(revBkTwoDiff);

        panel1BkThreeSub.add(home);
        panel1BkThreeSub.add(revBkThreeEasy);
        panel1BkThreeSub.add(revBkThreeInter);
        panel1BkThreeSub.add(revBkThreeDiff);

        panel1BkFourSub.add(home);
        panel1BkFourSub.add(revBkFourEasy);
        panel1BkFourSub.add(revBkFourInter);
        panel1BkFourSub.add(revBkFourDiff);

        frame.add(panel1BkOneSub);
        frame.add(panel1BkTwoSub);
        frame.add(panel1BkThreeSub);
        frame.add(panel1BkFourSub);

        //frame.add(panel2);
        panel3.add(labelRevWord);
        //panel3.add(labelRevWordInTextSent, BorderLayout.SOUTH);
        frame.add(panel3);
        panel4.add(wrappedText);
        //panel4.add(defintionGUI);
        frame.add(panel4);

        panel5.add(easy);
        panel5.add(medium);
        panel5.add(difficult);
        frame.add(panel5);


        //frame.pack(); // need to add this after all components are added
    }
}


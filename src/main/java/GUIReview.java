/*import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIReview extends Review {

    int index = 0;
    String revWord = "test";
    JButton showDict = new JButton();
    JButton easy = new JButton();
    JButton medium = new JButton();
    JButton difficult = new JButton();
    JButton unknown;
    JLabel label0 = new JLabel();
    tfidfMatrix reweightWord = new tfidfMatrix();
    WebLookup webLookup = new WebLookup();

    GUIReview() {
            ImageIcon imageIcon = new ImageIcon("image0.jpg");
            Image imgIconSize = imageIcon.getImage();
            Image newImg = imgIconSize.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
            ImageIcon scaledImgIcon = new ImageIcon(newImg);

            label0.setText(revWord);
            label0.setIcon(scaledImgIcon);
            label0.setHorizontalAlignment(JLabel.CENTER);
            label0.setVerticalAlignment(JLabel.CENTER);
            label0.setHorizontalTextPosition(JLabel.CENTER);
            label0.setVerticalTextPosition(JLabel.TOP);
            label0.setFont(new Font("Times New Roman", Font.BOLD, 25));
            label0.setIconTextGap(-100);
            label0.setBackground(Color.white);
            label0.setOpaque(false);
            label0.setVisible(true);

            /*

            label1.setText(webDict.definition(revWord));
            label1.setIcon(scaledImgIcon);
            label1.setHorizontalAlignment(JLabel.CENTER);
            label1.setVerticalAlignment(JLabel.CENTER);
            label1.setHorizontalTextPosition(JLabel.CENTER);
            label1.setVerticalTextPosition(JLabel.CENTER);
            label1.setFont(new Font("Times New Roman", Font.PLAIN, 10));
            label1.setIconTextGap(-50);
            label1.setBackground(Color.white);
            label1.setOpaque(false);
            label1.setVisible(false);

//
            showDict.setText("Show Definition");
            showDict.setVerticalAlignment(JButton.BOTTOM);
            showDict.setHorizontalAlignment(JButton.LEFT);
            showDict.addActionListener(e -> {
                new GUIDefinition(revWord);
            });


            easy.setText("Easy");
            easy.setVerticalAlignment(JButton.BOTTOM);
            easy.setHorizontalAlignment(JButton.LEFT);
            easy.addActionListener(e -> {
                //WebLookup webLookup = new WebLookup();
                //webLookup.definition(revWord);
                //TODO also need to addin in-text examples sentences here.

                reweightWord.reweightValuesEasy(revWord);
            });
            easy.setBounds(50, 700, 100, 50);
            easy.setSize(100, 50);


            medium.setText("Medium");
            medium.setVerticalAlignment(JButton.BOTTOM);
            medium.setHorizontalAlignment(JButton.CENTER);
            medium.addActionListener(e -> {
                //WebLookup webLookup = new WebLookup();
                //webLookup.definition(revWord);
                //TODO also need to addin in-text examples sentences here.

                reweightWord.reweightValuesMedium(revWord);
            });
            medium.setBounds(200, 700, 100, 50);
            medium.setSize(100, 50);

            difficult.setText("Difficult");
            difficult.setVerticalAlignment(JButton.BOTTOM);
            difficult.setHorizontalAlignment(JButton.RIGHT);
            difficult.addActionListener(e -> {
                //WebLookup webLookup = new WebLookup();
                //webLookup.definition(revWord);
                //TODO also need to addin in-text examples sentences here.

                reweightWord.reweightValuesDifficult(revWord);
            });
            difficult.setBounds(350, 700, 100, 50);
            difficult.setSize(100, 50);
            //unknown.setText("Unknown");

            JFrame frame = new JFrame();
            ImageIcon image = new ImageIcon("book-imageIcon.png");
            frame.setIconImage(image.getImage());
            frame.setTitle("Honyomi");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(true);
            frame.setSize(1200, 900);
            frame.setVisible(true);
            frame.setContentPane(label0);

            frame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;


            //frame.add(label1);
            frame.add(showDict, gbc);
            frame.add(easy, gbc);
            frame.add(medium, gbc);
            frame.add(difficult, gbc);
            //frame.add(unknown, gbc);

            frame.setLocationRelativeTo(null);

            frame.pack(); // need to add this after all components are added

        }
    }
*/



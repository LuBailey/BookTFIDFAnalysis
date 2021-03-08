import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIDefinition extends Review {

    JFrame frame = new JFrame();
    JLabel label1 = new JLabel();
    WebLookup webLookup = new WebLookup();

    GUIDefinition(String revWord) throws IOException {
        //System.out.println(webLookup.definition("what"));
        //System.out.println("console isnt working");
        ImageIcon imageIcon = new ImageIcon("image0.jpg");
        Image imgIconSize = imageIcon.getImage();
        Image newImg = imgIconSize.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledImgIcon = new ImageIcon(newImg);
        String definition = webLookup.definition(revWord);


        label1.setText(definition);
        //label1.setText("Take measures to check the quality, performance, or reliability of (something), esp. before putting it into widespread use or practice - this range has not been tested on animals -");
        label1.setIcon(scaledImgIcon);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setFont(new Font("Times New Roman", Font.PLAIN, 7));
        label1.setIconTextGap(-50);
        label1.setBackground(Color.white);
        label1.setOpaque(false);
        label1.setVisible(true);


        ImageIcon image = new ImageIcon("book-imageIcon.png");
        frame.setIconImage(image.getImage());
        frame.setTitle("Definition");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(700, 500);
        frame.setVisible(true);
        frame.setContentPane(label1);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        frame.setLocationRelativeTo(null);

        frame.pack(); // need to add this after all components are added
    }
}

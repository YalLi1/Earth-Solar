import javax.swing.*;

public class Main {
    public static void main(String[] args) {

           JFrame frame = new JFrame();
RunningImage image = new RunningImage();
frame.add(image);
frame.setSize(1000,1000);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

    }
}
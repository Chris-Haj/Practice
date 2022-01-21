

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Main extends JFrame {

    public static void Spam(){
        try {
            File file = new File("C:\\Users\\chris\\IdeaProjects\\Practice\\src\\main\\java\\animals.txt");
            Scanner scanner = new Scanner(file);
            String start = "You are a ";
            String full;
            Robot robot = new Robot();
            robot.delay(1000);
            while(scanner.hasNext()){
                full = start + scanner.nextLine();
                for(int i=0;i<full.length();i++){
                    if('A'<=i&&i<='Z') {
                        robot.keyPress(KeyEvent.VK_SHIFT);
                    }
                    robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(full.charAt(i)));
                    robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(full.charAt(i)));
                    if('A'<=i&&i<='Z') {
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                    }
                }
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rec = new Rectangle((int) (size.getWidth()/2), (int) (size.getHeight()/2));
            BufferedImage cap = new Robot().createScreenCapture(rec);
            File image = new File("screenshot.png");
            ImageIO.write(cap,"png",image);
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
//        crackImage("screenshot.png");
    }
}
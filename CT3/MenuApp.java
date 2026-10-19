import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.util.Date;
import java.util.Random;

public class MenuApp extends JFrame {

    public MenuApp() {
        setTitle("Menu App");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea box = new JTextArea(8, 30);
        add(box);

        Random r = new Random();
        Color green = new Color(r.nextInt(100), 100 + r.nextInt(156), r.nextInt(100));
        String hex = String.format("#%02X%02X%02X",
                green.getRed(), green.getGreen(), green.getBlue());

        JMenuItem item1 = new JMenuItem("Date/Time");
        JMenuItem item2 = new JMenuItem("Save to log.txt");
        JMenuItem item3 = new JMenuItem("Random Green");
        JMenuItem item4 = new JMenuItem("Exit");

        item1.addActionListener(e -> box.append(new Date() + "\n"));

        item2.addActionListener(e -> {
            try (FileWriter w = new FileWriter("log.txt")) {
                w.write(box.getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        item3.addActionListener(e -> {
            getContentPane().setBackground(green);
            box.append("Green hue: " + hex + "\n");
        });

        item4.addActionListener(e -> System.exit(0));

        JMenu menu = new JMenu("Menu");
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);

        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);
    }

    public static void main(String[] args) {
        new MenuApp().setVisible(true);
    }
}
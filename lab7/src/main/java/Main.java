import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static JFrame frame;
    public static JTextArea textArea;

    public static void main(String[] args) throws IOException {
        createTextArea();

        System.out.println("Enter the number of threads: ");
        Scanner sc = new Scanner(System.in);
        int threadNumber = sc.nextInt();
        Prim primObj = new Prim();
        primObj.findPrimSolution(threadNumber);

    }

    public static void createTextArea() {
        frame = new JFrame();
        JPanel panel = new JPanel();
        textArea = new JTextArea(20, 40);
        JScrollPane scroll = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(scroll);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setSize(700, 400);
        frame.setVisible(true);
    }
}

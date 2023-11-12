package views.createwindow;
import javax.swing.*;

public class CreateWindow extends JFrame{
    // constructor 
    public CreateWindow(){
        super("Read Data Mahasiswa");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // panel
        JPanel panel = new JPanel();

        // label
        JLabel label = new JLabel("KITA CREATING SEKARANG");

        panel.add(label);
        this.add(panel);
        this.setVisible(true);
    }
}

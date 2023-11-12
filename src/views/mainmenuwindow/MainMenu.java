package views.mainmenuwindow;

import javax.swing.*;

public class MainMenu extends JFrame{
    // constructor
    public MainMenu(){
        super("Aplikasi Mahasiswa"); // inisiasi object JFrame dengan title
        this.setSize(800, 600); // mengatur ukuran window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // menghentikan program ketika window ini ditutup.
        JPanel panel = new JPanel(); // panel untuk contain buttons

        JButton readButton = new JButton("Read Mahasiswa");
        JButton createButton = new JButton("Create Mahasiswa");

        ReadButtonListener readButtonListener = new ReadButtonListener(); // read button listener
        CreateButtonListener createButtonListener = new CreateButtonListener(); // create button listener
        
        readButton.addActionListener(readButtonListener); // binding ke readButton
        createButton.addActionListener(createButtonListener); // binding ke createButton

        panel.add(readButton); // memasukkan readButton ke panel
        panel.add(createButton); // memasukkan createButton ke panel
        
        this.add(panel); // memasukkan panel pada Frame MainMenu
        this.setVisible(true);
    }
}


package views.readwindow;


import java.util.List;

import javax.swing.*;

import daos.MahasiswaBIN;
import models.Mahasiswa;

public class ReadWindow extends JFrame{
    
    // data members
    protected JPanel panel;
    protected JTable table;
    protected JButton backButton;
    protected List<Mahasiswa> mahasiswaList;
    // constructor 
    public ReadWindow(List<Mahasiswa> mahasiswaList){
        // parent constructor call
        super("Read Data Mahasiswa");

        // inherit and convert into suitable data model
        this.mahasiswaList = mahasiswaList;


        // setting
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // panel
        panel = new JPanel();

        // label
        JLabel label = new JLabel("KITA READING SEKARANG");

        // table
        table = new JTable(new MahasiswaTableModel(mahasiswaList));
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(label);
        panel.add(scrollPane);
        panel.add(table);
        
        this.add(panel);
        this.setVisible(true);
    }

    // change List<Mahasiswa> into 
}

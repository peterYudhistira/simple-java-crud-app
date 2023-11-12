package views.readwindow;
import java.util.List;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import models.Mahasiswa;

public class MahasiswaTableModel extends AbstractTableModel{

    // data member
    private List<Mahasiswa> mahasiswaList;
    private String[] columnNames = {"NRP", "Nama", "Gender"};

    // constructor
    public MahasiswaTableModel(List<Mahasiswa> mahasiswalList){
        this.mahasiswaList = mahasiswalList;

    }

    @Override
    public int getRowCount() {
        return this.mahasiswaList.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mahasiswa currentMahasiswa = this.mahasiswaList.get(rowIndex);

        switch(columnIndex){
            case 0:
                return currentMahasiswa.getNrp();
            case 1:
                return currentMahasiswa.getNama();
            case 2:
                return currentMahasiswa.getGender();
            default:
                return null;
        }
    }
    
    public String getColumnName(int columnIndex){
        return this.columnNames[columnIndex];
    }
}

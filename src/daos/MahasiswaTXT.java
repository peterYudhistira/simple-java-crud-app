package daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Mahasiswa;

public class MahasiswaTXT implements MahasiswaDAO {
    // data member
    public File file;
    public FileWriter writer;
    public Scanner reader;

    // constructor
    public MahasiswaTXT() {
        this.file = new File("src/resources/mahasiswa.txt");
    }

    @Override
    public void create(Mahasiswa mahasiswa) {
        try {
            writer = new FileWriter(file, true);
            writer.write(mahasiswa.getNrp() + "\n");
            writer.write(mahasiswa.getNama() + "\n");
            writer.write(mahasiswa.getGender() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Mahasiswa> read() {
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();
        try {
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String nrp = reader.nextLine();
                String nama = reader.nextLine();
                String gender = reader.nextLine();
                mahasiswaList.add(new Mahasiswa(nrp, nama, gender));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mahasiswaList;
    }

    @Override
    public void update(Mahasiswa mahasiswa, String nrp) {
        // read all
        List<Mahasiswa> mahasiswaList = this.read();

        // cari yang nrp nya sama
        for (int i = 0; i < mahasiswaList.size(); i++) {
            // kalau ketemu replace datanya
            if (mahasiswaList.get(i).getNrp().equals(nrp)) {
                mahasiswaList.get(i).setNama(mahasiswa.getNama());
                mahasiswaList.get(i).setGender(mahasiswa.getGender());
                break;
            }
        }

        // write all
        writeAll(mahasiswaList);
    }

    @Override
    public void delete(String nrp) {
        // read all
        List<Mahasiswa> mahasiswaList = this.read();

        // cari yang nrp nya sama
        for (int i = 0; i < mahasiswaList.size(); i++) {
            // kalo ketemu remove dari array list
            if (mahasiswaList.get(i).getNrp().equals(nrp)) {
                mahasiswaList.remove(i);
                break;
            }
        }

        // write all
        writeAll(mahasiswaList);
    }

    public void writeAll(List<Mahasiswa> mahasiswaList) {
        try {
            writer = new FileWriter(file, false);
            for (Mahasiswa mhs : mahasiswaList) {
                writer.write(mhs.getNrp() + "\n");
                writer.write(mhs.getNama() + "\n");
                writer.write(mhs.getGender() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

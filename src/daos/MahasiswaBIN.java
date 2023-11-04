package daos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import models.Mahasiswa;

public class MahasiswaBIN implements MahasiswaDAO {
    public File file;

    // constructor
    public MahasiswaBIN() {
        file = new File("src/resources/mahasiswa.ser");
    }

    @Override
    public void create(Mahasiswa mahasiswa) {
        try {
            // read
            List<Mahasiswa> mahasiswaList = read();
            // append mahasiswa to list
            mahasiswaList.add(mahasiswa);

            // open file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // write mahasiswa to file
            objectOutputStream.writeObject(mahasiswaList);

            // close
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Mahasiswa> read() {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();

        try {
            // open file
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // read to list until out of mahasiswa
            while (true) {
                try {
                    mahasiswaList = (List<Mahasiswa>) objectInputStream.readObject();
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            // close file
            fileInputStream.close();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mahasiswaList;
    }

    @Override
    public void update(Mahasiswa mahasiswa, String nrp) {
        // get all mahasiswa
        List<Mahasiswa> mahasiswaList = read();

        // cari yang nrp nya sama
        for (int i = 0; i < mahasiswaList.size(); i++) {
            // kalau ketemu replace datanya
            if (mahasiswaList.get(i).getNrp().equals(nrp)) {
                mahasiswaList.get(i).setNama(mahasiswa.getNama());
                mahasiswaList.get(i).setGender(mahasiswa.getGender());
                break;
            }
        }

        // write ulang
        writeAll(mahasiswaList);
    }

    @Override
    public void delete(String nrp) {
        // get all mahasiswa
        List<Mahasiswa> mahasiswaList = read();

        // cari yang nrp nya sama
        for (int i = 0; i < mahasiswaList.size(); i++) {
            // kalau ketemu replace datanya
            if (mahasiswaList.get(i).getNrp().equals(nrp)) {
                mahasiswaList.remove(i);
                break;
            }
        }

        // write ulang
        writeAll(mahasiswaList);
    }

    public void writeAll(List<Mahasiswa> mahasiswaList) {
        try {
            // open file
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // write mahasiswa to file
            objectOutputStream.writeObject(mahasiswaList);

            // close
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

package daos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import models.Mahasiswa;
import models.MahasiswaSerializable;

public class MahasiswaBIN implements MahasiswaDAO {
    public String filePath;

    // constructor
    public MahasiswaBIN() {
        this.filePath = "src/resources/mahasiswa.ser";
    }

    @Override
    public void create(Mahasiswa mahasiswa) {
        try {
            // Open the file in append mode
            FileOutputStream fileOutputStream = new FileOutputStream(filePath, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // create a serializable copy of mahasiswa 
            MahasiswaSerializable mahasiswaSerializable = new MahasiswaSerializable(mahasiswa.getNrp(), mahasiswa.getNama(), mahasiswa.getGender());
            objectOutputStream.writeObject(mahasiswaSerializable);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Mahasiswa> read() {
        List<Mahasiswa> mahasiswas = new ArrayList<>();

        try {
            // Open the file in read mode
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // Read objects from the binary file until EOF
            while (true) {
                try {
                    MahasiswaSerializable mahasiswaSerializable = (MahasiswaSerializable) objectInputStream.readObject();
                    mahasiswas.add(mahasiswaSerializable);
                } catch (EOFException e) {
                    break; // End of file
                }
            }

            // Close the streams
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return mahasiswas;
    }

    @Override
    public void update(Mahasiswa mahasiswa, String nrp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String nrp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}

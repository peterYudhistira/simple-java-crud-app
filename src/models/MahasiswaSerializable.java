package models;

import java.io.Serializable;

public class MahasiswaSerializable extends Mahasiswa implements Serializable{

    public MahasiswaSerializable(String nrp, String nama, String gender) {
        super(nrp, nama, gender);
        //TODO Auto-generated constructor stub
    }
}

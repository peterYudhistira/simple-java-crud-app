package models;

import java.io.Serializable;

public class Mahasiswa implements Serializable{
    // data members
    String nrp;
    String nama;
    String gender;

    // constructor
    public Mahasiswa(String nrp, String nama, String gender){
        this.nrp = nrp;
        this.nama = nama;
        this.gender = gender;
    }

    // PAM
    public void setNrp(String nrp) {
        this.nrp = nrp;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getNrp() {
        return nrp;
    }
    public String getNama() {
        return nama;
    }
    public String getGender() {
        return gender;
    }

}

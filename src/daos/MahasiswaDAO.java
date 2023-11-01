package daos;
import java.util.List;
import models.Mahasiswa;

// taruh fungsi2 yang harus dimiliki class2 disini.
public interface MahasiswaDAO {
    void create(Mahasiswa mahasiswa); // create
    List<Mahasiswa> read(); // read
    void update(Mahasiswa mahasiswa, String nrp); // update
    void delete(String nrp); // delete
}

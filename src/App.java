import java.util.List;
import java.util.Scanner;

import daos.MahasiswaBIN;
import daos.MahasiswaTXT;
import models.Mahasiswa;

public class App {
    public static void main(String[] args) throws Exception {
        MahasiswaTXT mahasiswaTXT = new MahasiswaTXT();
        MahasiswaBIN mahasiswaBIN = new MahasiswaBIN();
        int choice;

        while (true) {
            choice = menu();

            if (choice == 1) {
                Mahasiswa mahasiswa = create();
                mahasiswaBIN.create(mahasiswa);
                // mahasiswaTXT.create(mahasiswa);
            } else if (choice == 2) {
                read(mahasiswaBIN.read());
            } else if (choice == 3) {
                Mahasiswa mahasiswa = create();
                mahasiswaTXT.update(mahasiswa, mahasiswa.getNrp());
            } else if (choice == 4) {
                String nrp = delete();
                mahasiswaTXT.delete(nrp);
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("SALAH");
            }
        }
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("0. Bye");
        return input.nextInt();
    }

    public static Mahasiswa create() {
        Scanner input = new Scanner(System.in);
        System.out.print("NRP : ");
        String nrp = input.nextLine();
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("Gender (L/P) : ");
        String gender = input.nextLine();
        input.nextLine();
        return new Mahasiswa(nrp, nama, gender);
    }

    public static void read(List<Mahasiswa> mahasiswaList) {
        for (Mahasiswa mahasiswa : mahasiswaList) {
            System.out.printf("NRP : %s\n Nama : %s\n Gender : %s\n*******\n",
                    mahasiswa.getNrp(),
                    mahasiswa.getNama(),
                    mahasiswa.getGender());
        }
    }

    public static String delete() {
        Scanner input = new Scanner(System.in);
        System.out.print("NRP : ");
        String nrp = input.nextLine();
        return nrp;
    }

}

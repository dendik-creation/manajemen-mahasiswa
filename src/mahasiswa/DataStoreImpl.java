package mahasiswa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataStoreImpl implements DataStore {
    private final List<Mahasiswa> mahasiswaList = new ArrayList<>();

    @Override
    public void create(Scanner sc) {
        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String jurusan = sc.nextLine();

        if (nama.isEmpty() || nim.isEmpty() || jurusan.isEmpty()) {
            System.out.println("Data tidak boleh kosong!");
            return;
        }

        boolean exists = mahasiswaList.stream().anyMatch(m -> m.nim().equalsIgnoreCase(nim));
        if (exists) {
            System.out.println("NIM sudah terdaftar.");
            return;
        }

        mahasiswaList.add(new Mahasiswa(nama, nim, jurusan));
        System.out.println("Data berhasil ditambahkan.");
    }

    @Override
    public void read() {
        if (mahasiswaList.isEmpty()) {
            System.out.println("Data kosong.");
            return;
        }

        System.out.println("\n=== Daftar Mahasiswa ===");
        mahasiswaList.forEach(m -> System.out.println("NIM: " + m.nim() + ", Nama: " + m.nama() + ", Jurusan: " + m.jurusan()));
    }

    @Override
    public void update(Scanner sc) {
        System.out.print("Masukkan NIM yang ingin diupdate: ");
        String nim = sc.nextLine();

        Mahasiswa mhs = mahasiswaList.stream().filter(m -> m.nim().equalsIgnoreCase(nim)).findFirst().orElse(null);
        if (mhs == null) {
            System.out.println("Data tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan Nama baru: ");
        String namaBaru = sc.nextLine();
        System.out.print("Masukkan Jurusan baru: ");
        String jurusanBaru = sc.nextLine();

        if (!namaBaru.isEmpty() && !jurusanBaru.isEmpty()) {
            mahasiswaList.remove(mhs);
            mahasiswaList.add(new Mahasiswa(namaBaru, nim, jurusanBaru));
            System.out.println("Data berhasil diupdate.");
        } else {
            System.out.println("Data baru tidak boleh kosong.");
        }
    }

    @Override
    public void delete(Scanner sc) {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String nim = sc.nextLine();
        boolean removed = mahasiswaList.removeIf(m -> m.nim().equalsIgnoreCase(nim));
        if (removed) {
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }
}
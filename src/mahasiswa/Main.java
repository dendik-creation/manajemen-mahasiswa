package mahasiswa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataStore dataStore = new DataStoreImpl();

        int pilih;
        do {
            System.out.println("\n=== Menu Mahasiswa ===");
            System.out.println("1. Tampilkan Data Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            while (!sc.hasNextInt()) {
                System.out.print("Input harus angka. Pilih menu: ");
                sc.next();
            }
            pilih = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (pilih) {
                case 1 -> dataStore.read();
                case 2 -> dataStore.create(sc);
                case 3 -> dataStore.update(sc);
                case 4 -> dataStore.delete(sc);
                case 0 -> System.out.println("Keluar dari program.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 0);
        sc.close();
    }
}
package mahasiswa;

import java.util.Scanner;

public interface DataStore {
    void create(Scanner sc);
    void read();
    void update(Scanner sc);
    void delete(Scanner sc);
}

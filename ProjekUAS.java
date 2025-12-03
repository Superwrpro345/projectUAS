
import java.util.ArrayList;
import java.util.Scanner;

public class ProjekUAS {

    static Scanner key = new Scanner(System.in);
    static ArrayList<String> playlist = new ArrayList<>();
    static ArrayList<String> musik = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> playlistLagu = new ArrayList<>();
    static int pilihan;
    static boolean keluar = false;

    public static void main(String[] args) {

        do {
            main_Interface();
            while (!key.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                key.nextLine();
                System.out.print("Please re-enter your choice: ");
            }
            pilihan = key.nextInt();
            key.nextLine();
            switch (pilihan) {
                case 1 -> tambah_playlist();
                case 2 -> lihat_daftar_playlist();
                case 3 -> hapus_playlist();
                case 4 -> cari_playlist();
                case 5 -> tambah_musik_ke_playlist();
                case 6 -> hapus_musik_dari_playlist();
                case 7 -> display_daftar_musik();
                case 8 -> tambah_musik();
                case 9 -> hapus_musik();
                case 10 -> keluar_program();
                default -> System.out.print("input salah. Silahkan Masukkan angka antara 1-10");
            }

        } while (!keluar);
        key.close();
    }

    static void main_Interface() {
        System.out.println("\n##########################");
        System.out.println("    Menu Playlist Lagu");
        System.out.println("##########################");
        System.out.println("1. Tambah Playlist Lagu");
        System.out.println("2. Lihat Daftar Playlist Lagu");
        System.out.println("3. Hapus Playlist Lagu");
        System.out.println("4. Cari Playlist Lagu");
        System.out.println("5. Tambah musik ke playlist");
        System.out.println("6. Hapus musik dari playlist");
        System.out.println("7. Daftar musik");
        System.out.println("8. Tambah lagu");
        System.out.println("9. Hapus lagu");
        System.out.println("10. Exit");
        System.out.print("Pilih menu: ");

    }

    static void tambah_playlist() {
        System.out.print("Tambah playlist lagu: ");
        String pLagu = key.nextLine();
        playlist.add(pLagu);
        playlistLagu.add(new ArrayList<>());
        System.out.println(" Playlist lagu berhasil ditambahkan.");
    }

    static void lihat_daftar_playlist() {
        System.out.println("Daftar playlist lagu: ");
        if (playlist.isEmpty()) {
            System.out.println("tidak ada playlist lagu.");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }

    static void hapus_playlist() {
        System.out.print("Masukkan nama playlist yang ingin dihapus: ");
        String del = key.nextLine();
        if (playlist.removeIf(p -> p.equalsIgnoreCase(del))) {
            System.out.println(" Playlist berhasil dihapus.");
        } else {
            System.out.println(" Playlist tidak ditemukan.");
        }
    }

    static void cari_playlist() {
        System.out.print("Cari playlist lagu: ");
        String cariplaylist = key.nextLine();
        boolean temuplaylist = false;
        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).toLowerCase().contains(cariplaylist.toLowerCase())) {
                System.out.println((i + 1) + ". " + playlist.get(i));
                temuplaylist = true;
                System.out.println("Daftar musik: ");
                if (musik.isEmpty()) {
                    System.out.println("Tidak ada musik");
                } else {
                    ArrayList<Integer> daftar = playlistLagu.get(i);
                    if (daftar.isEmpty()) {
                        System.out.println("Belum ada musik");
                    } else {
                        for (int c = 0; c < daftar.size(); c++) {
                            System.out.println((c + 1) + ". " + musik.get(c));
                        }
                    }
                }
            }
        }
        if (!temuplaylist) {
            System.out.println("Playlist tidak tersedia");
        }
    }

    static void tambah_musik_ke_playlist() {
        if (playlist.isEmpty()) {
            System.out.println("tidak ada playlist lagu.");
        } else {
            System.out.print("Cari playlist lagu: ");
            String carilagu = key.nextLine();
            int idxPlaylist = playlist.indexOf(carilagu);
            if (musik.isEmpty()) {
                System.out.println("Tidak ada musik");
            } else {
                for (int j = 0; j < musik.size(); j++) {
                    System.out.println((j + 1) + ". " + musik.get(j));
                }
            }
            System.out.println("Pilihlah lagu yang ingin ditambahkan");
            System.out.print("Pilih: ");
            int pilihMusik = key.nextInt() - 1;
            key.nextLine();
            playlistLagu.get(idxPlaylist).add(pilihMusik);
            System.out.println("Musik berhasil ditambahkan!");
        }

    }

    static void hapus_musik_dari_playlist() {
        if (musik.isEmpty()) {
            System.out.println("Tidak ada musik untuk dihapus.");
        } else {
            System.out.println("Daftar musik saat ini:");
            for (int i = 0; i < musik.size(); i++) {
                System.out.println((i + 1) + ". " + musik.get(i));
            }
            System.out.print("Masukkan nama musik yang ingin dihapus: ");
            String delMusika = key.nextLine();
            if (musik.removeIf(m -> m.equalsIgnoreCase(delMusika))) {
                System.out.println("Musik berhasil dihapus.");
            } else {
                System.out.println("Musik tidak ditemukan.");
            }
        }

    }

    static void display_daftar_musik() {
        if (musik.isEmpty()) {
            System.out.println("Tidak ada musik");
        } else {
            for (int i = 0; i < musik.size(); i++) {
                System.out.println((i + 1) + ". " + musik.get(i));
            }
        }
    }

    static void tambah_musik() {
        System.out.print("Tambah lagu: ");
        String music = key.nextLine();
        musik.add(music);
        System.out
                .println(" musik berhasil ditambahkan.");

    }

    static void hapus_musik() {
        System.out.print("Masukkan nama musik yang ingin dihapus: ");
        String dele = key.nextLine();
        if (musik.removeIf(p -> p.equalsIgnoreCase(dele))) {
            System.out.println(" musik berhasil dihapus.");
        } else {
            System.out.println(" musik tidak ditemukan.");
        }

    }

    static void keluar_program() {
        do {
            System.out.print("\nApakah anda yakin untuk keluar (y/n)");
            String out = key.nextLine();
            if (out.equalsIgnoreCase("y")) {
                System.out.println("Terima Kasih untuk Menggunakan Aplikasi Kita");
                keluar = true;
            } else if (out.equalsIgnoreCase("n")) {
                keluar = false;
                break;
            } else {
                System.out.println("Masukkan y/n : ");
            }
        } while (!keluar);
    }
}

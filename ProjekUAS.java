
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
                            int index = daftar.get(c);
                            System.out.println((c + 1) + ". " + musik.get(index));
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
        }

        System.out.print("Cari playlist lagu: ");
        String carilagu = key.nextLine();
        int idxPlaylist = -1;

        for (int i = 0; i < playlist.size(); i++) {
            if (playlist.get(i).equalsIgnoreCase(carilagu)) {
                idxPlaylist = i;
                break;
            }
        }
        System.out.println("Pilih Musik Yang Ingin ditambahkan");
        int pilihmusik = key.nextInt() - 1;
        key.nextLine();

        if (pilihmusik <= 0 && pilihmusik >= musik.size()) {
            System.out.println("Musik Tidak Ditemukan");
        }

        if (playlistLagu.get(idxPlaylist).contains(pilihmusik)) {
            System.out.println("Sudah ada musik yang ingin ditambahkan dalam playlist tersebut");
        }

        playlistLagu.get(idxPlaylist).add(pilihmusik);
        System.out.println("Musik Berhasil Ditambahkan");
    }

    static void hapus_musik_dari_playlist() {
        if (musik.isEmpty()) {
            System.out.println("Tidak ada musik untuk dihapus.");
            return;
        }

        if (playlist.isEmpty()) {
            System.out.println("Tidak Ada Playlist");
            return;
        }

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }

        int idPlaylist = key.nextInt() - 1;
        key.nextLine();

        if (idPlaylist < 0 || idPlaylist >= playlist.size()) {
            System.out.println("Playlist Tidak Ditemukan");
        }

        ArrayList<Integer> Select = playlistLagu.get(idPlaylist);

        if (Select.isEmpty()) {
            System.out.println("Tidak Musik yang ingin dihapus");
        }

        System.out.println("Daftar Musik");
        for (int i = 0; i < Select.size(); i++) {
            int Idselect = Select.get(i);
            System.out.println((i + 1) + ". " + Select.get(Idselect));
        }

        System.out.println("Pilih daftar musik yang ingin dihapus");
        int Musikpilih = key.nextInt();
        key.nextLine();

        if (Musikpilih >= 0 && Musikpilih <= Select.size()) {
            Select.remove(Musikpilih);
            System.out.println("Musik dalam playlist berhasil dihapus");
        } else {
            System.out.println("Musik Tidak ditemukan");
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

        int indexdelete = -1;

        for (int i = 0; i < musik.size(); i++) {
            if (musik.get(i).equalsIgnoreCase(dele)) {
                indexdelete = i;
                break;
            }
        }

        if (indexdelete != -1) {
            musik.remove(indexdelete);

            final int finalIndexDelete = indexdelete;
            for (ArrayList<Integer> pl : playlistLagu) {
                pl.removeIf(index -> index == finalIndexDelete);

                for (int i = 0; i < pl.size(); i++) {
                    if (pl.get(i) > finalIndexDelete) {
                        pl.set(i, pl.get(i) - 1);
                    }
                }
            }
            System.out.println("Musik Berhasil Dihapus");
        } else {
            System.out.println("Musik Tidak Berhasil Ditemukan");
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

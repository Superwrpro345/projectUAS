
import java.util.Scanner;
import java.util.ArrayList;

public class ProjekUAS {

    static Scanner key = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> playlist = new ArrayList<>();
        ArrayList<String> musik = new ArrayList<>();
        ArrayList<ArrayList<Integer>> playlistLagu = new ArrayList<>();
        int pilihan = 0;
        boolean keluar = false;
        do {
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
            if (!key.hasNextInt()) {
                System.out.println("Input tidak valid. Silakan masukkan angka antara 1-10.");
                key.nextInt();
                continue;
            } else {
                pilihan = key.nextInt();
                key.nextLine();
            }
            do {
                switch (pilihan) {
                    case 1:
                        System.out.print("Tambah playlist lagu: ");
                        String pLagu = key.nextLine();
                        playlist.add(pLagu);
                        playlistLagu.add(new ArrayList<>());
                        System.out.println(" Playlist lagu berhasil ditambahkan.");
                        break;
                    case 2:
                        System.out.println("Daftar playlist lagu: ");
                        if (playlist.isEmpty()) {
                            System.out.println("tidak ada playlist lagu.");
                        } else {
                            for (int i = 0; i < playlist.size(); i++) {
                                System.out.println((i + 1) + ". " + playlist.get(i));
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Masukkan nama playlist yang ingin dihapus: ");
                        String del = key.nextLine();
                        if (playlist.removeIf(p -> p.equalsIgnoreCase(del))) {
                            System.out.println(" Playlist berhasil dihapus.");
                        } else {
                            System.out.println(" Playlist tidak ditemukan.");
                        }
                        break;
                    case 4:
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
                                        for (Integer idx : daftar) {
                                            System.out.println((i + 1) + ". " + musik.get(idx));
                                        }
                                    }
                                }
                            }
                        }
                        if (!temuplaylist) {
                            System.out.println("Playlist tidak tersedia");
                        }
                        break;
                    case 5:
                        if (playlist.isEmpty()) {
                            System.out.println("tidak ada playlist lagu.");
                        } else {
                            System.out.print("Cari playlist lagu: ");
                            String carilagu = key.nextLine();
                            boolean temulagu = false;
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
                        break;
                    case 6:// Cari Playlist dulu setelah itu delete musik

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
                        } // Barisan kode ini ngedelete semua lagu yang sama dalam playlist berbeda

                        break;
                    case 7:
                        if (musik.isEmpty()) {
                            System.out.println("Tidak ada musik");
                        } else {
                            for (int i = 0; i < musik.size(); i++) {
                                System.out.println((i + 1) + ". " + musik.get(i));
                            }
                        }
                        break;
                    case 8:
                        System.out.print("Tambah lagu: ");
                        String music = key.nextLine();
                        musik.add(music);
                        System.out.println(" musik berhasil ditambahkan.");
                        break;
                    case 9:
                        System.out.print("Masukkan nama musik yang ingin dihapus: ");
                        String dele = key.nextLine();
                        if (musik.removeIf(p -> p.equalsIgnoreCase(dele))) {
                            System.out.println(" musik berhasil dihapus.");
                        } else {
                            System.out.println(" musik tidak ditemukan.");
                        }
                        break;
                    case 10:
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
                        break;
                    default:
                        System.out.println("Masukkan Input yang valid");
                }
            } while (pilihan < 1 && pilihan > 10);
        } while (!keluar);
        key.close();
    }
}

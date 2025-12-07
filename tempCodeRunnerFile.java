
            System.out.println("Daftar musik saat ini:");
            for (int i = 0; i < musik.size(); i++) {
                System.out.println((i + 1) + ". " + musik.get(i));
            }
            System.out.print("Masukkan nomor musik yang ingin dihapus: ");
            while (!key.hasNextInt()) {
                System.out.println("In
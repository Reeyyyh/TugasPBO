package TugasKasir;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Kasir hargaMenu = new Kasir();
        Pelanggan pelanggan = new Pelanggan();
        Scanner input = new Scanner(System.in);

        String DaftarMember;
        int JumlahPesan;

        boolean repeat = true;

        menu.tampilan();

        while(repeat){
        System.out.print("\nPilih menu : ");
        int pesan = input.nextInt();
        
            switch (pesan) {
            case 1:{
                pesan -= 1;
                System.out.printf("%s || Rp.%d\n",menu.getNamaMenu()[pesan],menu.getHarga()[pesan]);
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                pesan += 1;
                break;
            }
            case 2:{
                pesan -= 1;
                System.out.printf("%s || Rp.%d\n",menu.getNamaMenu()[pesan],menu.getHarga()[pesan]);
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                pesan += 1;
                break;
            }
            case 3:{
                pesan -= 1;
                System.out.printf("%s || Rp.%d\n",menu.getNamaMenu()[pesan],menu.getHarga()[pesan]);
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                pesan += 1;
                break;
            }
            case 4:{
                pesan -= 1;
                System.out.printf("%s || Rp.%d\n",menu.getNamaMenu()[pesan],menu.getHarga()[pesan]);
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                pesan += 1;
            }
            case 0:{
                repeat = false;
                break;
            }
        
            default:
            System.out.println("Menu tidak tersedia : ");
                break;
        }

    } 

        System.out.println("\nTotal Harga : "+hargaMenu.TotalHarga()+"\n");

    System.out.println("Daftar sebagai member untuk mendapatkan diskon 2% di pembelian berikutnya");
    System.out.println("Y | N");
    System.out.print("apakah ingin mendaftar : ");

    do {
        DaftarMember = input.next();
        DaftarMember = DaftarMember.toUpperCase();

        
    if (DaftarMember.equals("Y")) {
        System.out.println("mendaftar sebagai member");
        input.nextLine();
        System.out.print("Masukan nama anda : ");
        String nama = input.nextLine();
        nama = nama.toUpperCase();
        pelanggan.setNama(nama);

        System.out.print("Masukan Nomor anda : ");
        String nomor = input.nextLine();
        pelanggan.setNomor(nomor);

        pelanggan.cekData();
        break;

    } else if (DaftarMember.equals("N")) {
        System.out.println("tidak mendaftar sebagai member");
    } else {
        System.out.println("pilihan invalid");
        System.out.print("tolong masukan pilihan yang sesuai : ");
    }

    } while (!DaftarMember.equals("Y") || !DaftarMember.equals("N"));



    }
}

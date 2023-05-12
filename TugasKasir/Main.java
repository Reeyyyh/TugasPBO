package TugasKasir;

import java.util.Scanner;

public class Main {

    static int JumlahPesan;

    public static void main(String[] args) {

        Menu menu = new Menu();
        HargaMenu hargaMenu = new HargaMenu();
        Scanner input = new Scanner(System.in);
        
        int Harga[] = {15000, 13000, 11000};

        boolean repeat = true;

        menu.tampilan();

        while(repeat){
        System.out.print("\nPilih menu : ");
        int pesan = input.nextInt();
        
            switch (pesan) {
            case 1:{
                System.out.println("Cappucino || Rp.15000");
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(Harga[0] * JumlahPesan);
                break;
            }
            case 2:{
                System.out.println("Expresso  || Rp.13000");
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(Harga[1] * JumlahPesan);
                break;
            }
            case 3:{
                System.out.println("Macchiato || Rp.11000");
                System.out.print("masukan jumlah pesanan : ");
                JumlahPesan = input.nextInt();
                hargaMenu.SetHarga(Harga[2] * JumlahPesan);
                break;
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

        System.out.println("\nTotal Harga : "+hargaMenu.TotalHarga());

    }
}

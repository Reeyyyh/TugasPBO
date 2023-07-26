package TugasKasir;

import TugasKasir.Exception.FormatException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Kasir kasir = new Kasir();
        
        SignUpMember signUpMember = new SignUpMember();
        LoginMember loginMember = new LoginMember();

        Scanner input = new Scanner(System.in);

        String DaftarMember, MemilikiMember;
        int JumlahPesan = 0;

        boolean repeat = true;

        menu.tampilan();

        while (repeat) {

            System.out.print("\nPilih menu : ");
            int pesan = 0;
            boolean inputan = false;

            while (true) {

                try {
                    pesan = input.nextInt();
                    if (pesan < 0) {
                        throw new FormatException("angka tidak bisa negatif ", new RuntimeException());
                    }
                    inputan = true;
                } catch (InputMismatchException ime) {
                    System.out.println("Error : " + ime.getCause() + " | " + ime.fillInStackTrace());
                    input.nextLine();
                } catch (FormatException fe) {
                    System.out.println("Error : " + fe.getMessage() + fe.getCause());
                } finally {
                    if (pesan >= 0 && inputan) {
                        break;
                    } else {
                        System.out.println("pilih menu yang sesuai\n");
                        System.out.print("Pilih menu : ");
                        inputan = false;
                    }
                }

            }

            try {
                switch (pesan) {
                    case 1: {
                        pesan -= 1;
                        System.out.printf("%s || Rp.%d\n", menu.getNamaMenu()[pesan], menu.getHarga()[pesan]);
                        System.out.print("masukan jumlah pesanan : ");
                        JumlahPesan = input.nextInt();

                        if (JumlahPesan < 0) {
                            throw new FormatException("Pesanan tidak bisa negatif ", new RuntimeException());
                        } else if (JumlahPesan == 0) {
                            System.out.println("jumlah pesanan tidak valid");
                        }

                        kasir.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                        System.out.println("Harga : " + kasir.getHarga());
                        pesan += 1;
                        break;
                    }
                    case 2: {
                        pesan -= 1;
                        System.out.printf("%s || Rp.%d\n", menu.getNamaMenu()[pesan], menu.getHarga()[pesan]);
                        System.out.print("masukan jumlah pesanan : ");
                        JumlahPesan = input.nextInt();

                        if (JumlahPesan < 0) {
                            throw new FormatException("Pesanan tidak bisa negatif ", new RuntimeException());
                        } else if (JumlahPesan == 0) {
                            System.out.println("jumlah pesanan tidak valid");
                        }

                        kasir.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                        System.out.println("Harga : " + kasir.getHarga());
                        pesan += 1;
                        break;
                    }
                    case 3: {
                        pesan -= 1;
                        System.out.printf("%s || Rp.%d\n", menu.getNamaMenu()[pesan], menu.getHarga()[pesan]);
                        System.out.print("masukan jumlah pesanan : ");
                        JumlahPesan = input.nextInt();

                        if (JumlahPesan < 0) {
                            throw new FormatException("Pesanan tidak bisa negatif ", new RuntimeException());
                        } else if (JumlahPesan == 0) {
                            System.out.println("jumlah pesanan tidak valid");
                        }

                        kasir.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                        System.out.println("Harga : " + kasir.getHarga());
                        pesan += 1;
                        break;
                    }
                    case 4: {
                        pesan -= 1;
                        System.out.printf("%s || Rp.%d\n", menu.getNamaMenu()[pesan], menu.getHarga()[pesan]);
                        System.out.print("masukan jumlah pesanan : ");
                        JumlahPesan = input.nextInt();

                        if (JumlahPesan < 0) {
                            throw new FormatException("Pesanan tidak bisa negatif ", new RuntimeException());
                        } else if (JumlahPesan == 0) {
                            System.out.println("jumlah pesanan tidak valid");
                        }

                        kasir.SetHarga(menu.getHarga()[pesan] * JumlahPesan);
                        System.out.println("Harga : " + kasir.getHarga());
                        pesan += 1;
                    }
                    case 0: {
                        repeat = false;
                        break;
                    }

                    default: {
                        System.out.println("Menu tidak tersedia ");
                        break;
                    }

                }

            } catch (FormatException fe) {
                System.out.println("Error : " + fe.getMessage() + fe.getCause());
            } catch (InputMismatchException ime) {
                System.out.println("Error : Jumlah pesanan di batalkan " + ime.getCause() + " | " + ime.fillInStackTrace());
                input.nextLine();
            }

        }

        System.out.println("\nTotal Harga : " + kasir.getTotalHarga() + "\n"); // total harga belanja

        System.out.print("Memiliki Member [Y | N] : ");

        do {
            MemilikiMember = input.next();
            MemilikiMember = MemilikiMember.toUpperCase();

            if (MemilikiMember.equals("Y")) {
                loginMember.setTotalHarga(kasir.getTotalHarga());
                loginMember.login();

            } else if (MemilikiMember.equals("N")) {

                System.out.println("\nIngin mendaftar menjadi member dengan melakukan pembayaran sebesar Rp 100000 ?");
                System.out.println("Benefit : Mendapatkan diskon untuk Total harga berikutnya sebanyak 2%");
                System.out.print("\nDaftar menjadi member? [Y|N] : ");

                input.nextLine();

                do {
                    DaftarMember = input.nextLine();
                    DaftarMember = DaftarMember.toUpperCase();
                    if (DaftarMember.equals("Y")) {
                        System.out.print("Masukan nominal pembayaran : ");
                        int PembayaranDaftarMember = 0;

                        try {
                            PembayaranDaftarMember = input.nextInt();
                        } catch (InputMismatchException ime) {
                            System.out.println("inputan tidak valid | " + ime.fillInStackTrace());
                        }

                        if (PembayaranDaftarMember >= 100000) {
                            System.out.println("Kembalian : " + (PembayaranDaftarMember - 100000));
                            signUpMember.DaftarMember();
                            System.out.println("\nTotal Harga : " + kasir.getTotalHarga() + "\n");
                        } else if (PembayaranDaftarMember == 0) {
                            System.out.println("gagal mendaftar");
                            System.out.println("\nTotal Harga : " + kasir.getTotalHarga() + "\n");
                        } else {
                            System.out.println("gagal mendaftar karena nominal pembayaran kurang");
                            System.out.println("\nTotal Harga : " + kasir.getTotalHarga() + "\n");
                        }
                    } else if (DaftarMember.equals("N")) {
                        System.out.println("Terimakasih sudah berkunjung :) ");
                        System.out.println("\nTotal Harga : " + kasir.getTotalHarga() + "\n");
                    } else {
                        System.out.println("pilihan tidak tersedia");
                        System.out.print("tolong masukan pilihan yang sesuai : ");
                    }
                } while (!DaftarMember.equals("Y") && !DaftarMember.equals("N"));

            } else {
                System.out.println("pilihan invalid");
                System.out.print("tolong masukan pilihan yang sesuai : ");
            }

        } while (!MemilikiMember.equals("Y") && !MemilikiMember.equals("N"));

        //System.out.println("\nTotal Harga : " + kasir.getTotalHarga() + "\n");

    }
}
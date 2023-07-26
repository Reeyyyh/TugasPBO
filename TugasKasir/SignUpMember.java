package TugasKasir;

import java.util.Scanner;
import java.util.regex.Pattern;

import TugasKasir.Exception.NamaFormatException;
import TugasKasir.Exception.NomorFormatException;
import TugasKasir.Exception.PinFormatException;

public class SignUpMember {

    Scanner input = new Scanner(System.in);

    public void DaftarMember() {
        Pelanggan pelanggan = new Pelanggan();
        

        System.out.println("\nTerima kasih sudah mendaftar menjadi member :) ");
        System.out.println("Silahkan isi data di bawah");

        Pattern ForNama = Pattern.compile("[a-z A-Z]+");
        System.out.print("Masukan nama anda : ");
        String Nama = input.nextLine();

        while (true) {
            try {
                if (!ForNama.matcher(Nama).matches()) { // di Throws ke NamaFormatException
                    throw new NamaFormatException("Nama mengandung selain alfabet ");
                }
            } catch (NamaFormatException nfe) { // untuk mengcatch NamaFormatException
                System.out.println("Error : " + nfe.getMessage());
            } finally { // akan selalu di eksekusi biarpun exception ataupun tidak
                if (ForNama.matcher(Nama).matches()) {
                    pelanggan.setNama(Nama);
                    break;
                } else {
                    System.out.print("Masukan nama lagi : ");
                    Nama = input.nextLine();
                }
            }
        }

        Pattern ForNomor = Pattern.compile("\\+62\\d+"); //+62 membuat length menjadi 3
        System.out.print("Masukan Nomor anda menggunakan kode +62 : ");
        String Nomor = input.nextLine();
        while (true) {
            try {
                if (!ForNomor.matcher(Nomor).matches()) {
                    throw new NomorFormatException("Nomor tidak valid");
                } else if(Nomor.length() - 1 < 12){ // = 11
                    throw new NomorFormatException("Nomor tidak valid karena di bawah 12 digit ");
                } else if (Nomor.length() - 1 > 14){ // = 15
                    throw new NomorFormatException("Nomor tidak valid karena melebihi 14 digit");
                }
            } catch (NomorFormatException nfe) {
                System.out.println("Error : " + nfe.getMessage());
            } finally {
                if (ForNomor.matcher(Nomor).matches() && Nomor.length() >= 13 && Nomor.length() <= 15) {
                    pelanggan.setNomor(Nomor);
                    break;
                } else {
                    System.out.print("Masukan Nomor lagi : ");
                    Nomor = input.nextLine();
                }
            }
        }

        Pattern ForPIN = Pattern.compile("[0-9]+");
        System.out.println("Note : PIN berupa angka dan memiliki panjang 4-6 digit");
        System.out.print("Masukan PIN anda : ");
        String PIN = input.nextLine();
        while (true) {
            try {
                if (!ForPIN.matcher(PIN).matches()) {
                    throw new PinFormatException("Pin tidak valid");
                } else if(PIN.length() <= 3 ){
                    throw new PinFormatException("Pin anda di bawah 4 digit");
                } else if (PIN.length() >= 7){
                    throw new PinFormatException("Pin anda melebihi 6 digit");
                }
            } catch (PinFormatException pfe) {
                System.out.println("Error : " + pfe.getMessage());
            } finally {
                if (ForPIN.matcher(PIN).matches() && PIN.length() >= 4 && PIN.length() <= 6) {
                    pelanggan.setPIN(PIN);
                    break;
                } else {
                    System.out.print("Masukan PIN lagi : ");
                    PIN = input.nextLine();
                }
            }
        }
        
        if (pelanggan.cekData() == true) {
            System.out.println("anda berhasil terdaftar");
        } else {
            System.out.println("anda sudah pernah terdaftar");
        }
    }

}

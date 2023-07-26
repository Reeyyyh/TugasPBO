package TugasKasir;

import java.util.Scanner;
import java.util.regex.Pattern;

import TugasKasir.Exception.NomorFormatException;
import TugasKasir.Exception.PinFormatException;

import TugasKasir.Diskon.DiskonMember;

public class LoginMember implements DiskonMember{

    private int TotalHarga;

    public void setTotalHarga(int totalHarga) {
        TotalHarga = totalHarga;
    }

    public int getTotalHarga() {
        return TotalHarga;
    }

    //my opsional
    Kasir kasir = new Kasir();
    Scanner input = new Scanner(System.in);

    String NomorUser = "";
    String PinUser = "";
    
    public void login(){

        Pattern ForNomor = Pattern.compile("\\+62\\d+"); //+62 membuat length menjadi 3
        System.out.print("Masukan Nomor anda yang pernah terdaftar menggunakan kode +62 : ");
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
                    NomorUser = Nomor;
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
                } else if(PIN.length() < 4 ){
                    throw new PinFormatException("Pin anda di bawah 4 digit");
                } else if (PIN.length() > 7){
                    throw new PinFormatException("Pin anda melebihi 6 digit");
                }
            } catch (PinFormatException pfe) {
                System.out.println("Error : " + pfe.getMessage());
            } finally {
                if (ForPIN.matcher(PIN).matches()) {
                    PinUser = PIN;
                    break;
                } else {
                    System.out.print("Masukan PIN lagi : ");
                    PIN = input.nextLine();
                }
            }
        }

        if (kasir.SetPinMember(PinUser, NomorUser) == true) {
            System.out.println("\nanda mendapatkan potongan 5% ");
            double hargaDiskon = getTotalHarga() - (getTotalHarga() * diskon);
            System.out.println("harga menjadi : "+hargaDiskon);
        } else {
            
        }

    }

}

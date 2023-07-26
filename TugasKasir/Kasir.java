package TugasKasir;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class Kasir {

    private int TotalHarga; // total harga
    private int Harga; // harga benda?

    public void SetHarga(int harga) {
        this.Harga = harga;
        this.TotalHarga += harga;
    }

    // total dari setiap harga jika ditambahkan
    public int getTotalHarga() {
        // int total = 0;
        // total = total + TotalHarga;
        return TotalHarga;
    }

    // untuk harga benda di pesan berapa banyak
    public int getHarga() {
        int HargaItem = 0;
        HargaItem = HargaItem + Harga;
        return HargaItem;
    }
    
    public boolean SetPinMember(String PIN, String Nomor){
        boolean isMember = false;
        String fileName = "TugasKasir/DataPelanggan.txt";
        Map<String, String> dataMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String key1 = parts[2]; // PIN
                    String key2 = parts[1]; // Nomor
                    String value = parts[0]; // nama
                     
                    dataMap.put(key1, value);
                    dataMap.put(key2, value);
                }
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }

        if (dataMap.containsKey(PIN) && dataMap.containsKey(Nomor)) {
            String name = dataMap.get(Nomor);
            System.out.println("Member atas nama : "+name);
            isMember = true;
            return isMember;
        }else if(!dataMap.containsKey(PIN) && dataMap.containsKey(Nomor)){
            System.out.println("Pin yang anda masukan salah");
        }
        else {
            System.out.println("Nomor yang anda masukan belum pernah terdaftar");
        }
        return isMember;
    }

}

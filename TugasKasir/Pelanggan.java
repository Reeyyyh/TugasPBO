package TugasKasir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pelanggan {
    private String Nama;
    private String Nomor;

    private String fileName = "TugasKasir/DataPelanggan.txt";
    private boolean isDataAvailable = false;

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public void setNomor(String nomor) {
        this.Nomor = nomor;
    }

    public String getNama() {
        return Nama;
    }

    public String getNomor() {
        return Nomor;
    }

    public void cekData() {
        try {
            // Membaca isi file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            
            String line;
            
            String nama = getNama();
            String nomor = getNomor();
            String newData = nama + " " + nomor;

            while ((line = reader.readLine()) != null) {
                if (line.equals(newData)) {
                    isDataAvailable = true;
                    break;
                }
            }
            
            reader.close();

            // Menambahkan data baru jika tidak ada data yang sama
            if (!isDataAvailable) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(getNama()+" "+getNomor());
                writer.newLine();
                writer.close();
                System.out.println("\nAnda berhasil Terdaftar.\n");
            } else {
                System.out.println("\nAnda sudah Terdaftar.\n");
            }

        } catch (IOException e) {
            System.out.println("file tidak tersedia : " + e.getMessage());
        }
    }

}
            /* 
            while ((line = reader.readLine()) != null) {
                data = line.split(" ");
                if (data.length == 2 && data[0].equals(getNama()) && data[1].equals(getNomor())) {
                    isDataAvailable = true;
                    break;
                }
            }
            */
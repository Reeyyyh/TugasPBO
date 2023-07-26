package TugasKasir;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Pelanggan {
    private String Nama;
    private String Nomor;
    private String PIN;

    private String fileName = "TugasKasir/DataPelanggan.txt";
    private boolean isDataAvailable = false;

    //setter getter
    public void setNama(String nama) {
        this.Nama = nama;
    }

    public void setNomor(String nomor) {
        this.Nomor = nomor;
    }

    public void setPIN(String pin) {
        this.PIN = pin;
    }

    public String getNama() {
        return Nama;
    }

    public String getNomor() {
        return Nomor;
    }

    public String getPIN() {
        return PIN;
    }

    //methods
    public boolean cekData() {
        boolean check = false;
        try {
            // Membaca isi file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String line;

            String nama = getNama();
            String nomor = getNomor();
            String PIN = getPIN();
            String newData = nama + ", " + nomor + ", " + PIN;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if(line.equals(newData)){
                    if (parts[1].contains(nomor)) {
                        isDataAvailable = true;
                        break;
                    }
                }  
            }

            reader.close();
            // Menambahkan data baru jika tidak ada data yang sama
            if (!isDataAvailable) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(getNama() + ", " + getNomor() + ", " + getPIN());
                writer.newLine();
                writer.close();
                check = true;
            } else {
                check = false;
            }

        } catch (IOException ie) {
            System.out.println("file tidak tersedia" + ie.getMessage());
        }
        return check;
    }

}
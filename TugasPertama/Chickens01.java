public class Chickens01 {

    public static int hasil(int TelurPerAyam, int JumlahAyam) {
        int total;
        int penyimpanan = 0;
        //hari senin
        total = TelurPerAyam * JumlahAyam;
        penyimpanan += total;
        //hari selasa
        JumlahAyam++;
        total = TelurPerAyam * JumlahAyam;
        penyimpanan += total;
        //hasi rabu
        total = TelurPerAyam * (JumlahAyam / 2);
        penyimpanan += total;
        
        return penyimpanan;
    }

    public static void main(String[] args) {

        //scenario 1
        // telur per ayam = 5, jumlah ayam = 3;
        System.out.println("Scenario 1 : "+hasil(5, 3)); // hasil = 45

        // scenario 2
        // telur per ayam = 4, jumlah ayam = 8;
        System.out.println("Scenario 2 : "+hasil(4, 8)); // hasil = 84
        
    }
}

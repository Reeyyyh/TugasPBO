package TugasKasir;

public class Kasir {

    private int Harga;

    public int TotalHarga(){
        int total = 0;
        total = total + Harga;
        return total;
    }

    public void SetHarga(int harga) {
        this.Harga += harga;
    }

    

}

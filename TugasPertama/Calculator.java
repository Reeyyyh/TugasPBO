import java.util.Scanner;

public class Calculator {

    public static int penjumlahan(int x, int y) {
        return x + y;
    }

    public static double pembagian(double x, double y) {
        return x / y;
    }

    public static int perkalian(int x, int y) {
        return x * y;
    }

    public static int pengurangan(int x, int y) {
        return x - y;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int angka1, angka2;
        System.out.print("masukan angka : ");
        angka1 = input.nextInt();
        System.out.print("masukan angka : ");
        angka2 = input.nextInt();
        System.out.println("hasil penjumlahan : " + penjumlahan(angka1, angka2));
        System.out.printf("hasil pembagian : %.2f \n", pembagian(angka1, angka2));
        System.out.println("hasil perkalian : " + perkalian(angka1, angka2));
        System.out.println("hasil pengurangan : " + pengurangan(angka1, angka2));
        input.close();
    }

}

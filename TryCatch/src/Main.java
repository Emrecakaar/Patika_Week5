import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] myList = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            myList[i] = list[i];
        }


        try {
            System.out.print("Dizimizde ki görmek istediğiniz değere karşılık gelen indeksi giriniz : ");
            int number = input.nextInt();
            System.out.println(myList[number]);


        } catch (Exception e) {
            System.out.println("Dizinin boyutu dışında bir değer girdiniz !!");
            System.out.println(e.getMessage());
        }

    }
}
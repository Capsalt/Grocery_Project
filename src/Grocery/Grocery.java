package Grocery;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    /* Basarili Market alış-veriş programı.
	 *
	 * 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
	 * 			No 	   Ürün 		  Fiyat
			   ====	 =======	 	=========
				00	 Domates   	 	 2.10 TL
				01	 Patates   	 	 3.20 TL
				02	 Biber     	 	 1.50 TL
				03	 Soğan      	 2.30 TL
				04	 Havuç     	   	 3.10 TL
				05	 Elma      	   	 1.20 TL
				06	 Muz     	 	 1.90 TL
				07	 Çilek 	 		 6.10 TL
				08	 Kavun      	 4.30 TL
				09	 Üzüm      	 	 2.70 TL
				10	 Limon     	 	 0.50 TL
	 * 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
	 * 3. Adım: Kaç kg satın almak istediğini sorunuz.
	 * 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
	 * 5. Başka bir ürün alıp almak istemediğini sorunuz.
	 * 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
	 * 7. Eğer bitirmek istiyorsa ödeme kısmına geçiniz ve ödem sonrasında programı bitirinzi.
	 */

    public static List<String> products = new ArrayList();
    public static List<Double> prices = new ArrayList();
    public static List<String> cart = new ArrayList();
    public static List<Double> priceOnCart = new ArrayList();
    public static List<Double> weightOnCart = new ArrayList();


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        products.addAll(Arrays.asList("Domates","Patates","Biber","Soğan","Havuç",
                "Elma","Kiraz","Çilek","Kavun","Üzüm","Limon"));
        prices.addAll(Arrays.asList(2.1, 3.2, 1.5, 2.3, 3.1, 1.2, 1.9, 6.1, 4.3, 2.7, 0.5));

        int productNo;
        double kg=0;
        String move;
        double total=0;

        do {
            listProduct();
            System.out.println("Almak istediğiniz ürünün numarasını giriniz: ");
            productNo = scan.nextInt();
            System.out.println("Kaç kilo alacaksınız: ");
            kg = scan.nextDouble();

            addToCart(productNo,kg);
            total = showTheCart();
            System.out.println();
            System.out.println("Yeni ürün almak ister misiniz? E/H ");
            move = scan.next();


        }while (move.equalsIgnoreCase("E"));

        pay(total);

    }

    public static void pay(double total) {
        double quantity = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ödemeniz gereken miktar= " + total);

        do {
            System.out.println("Ne kadar paranız var?");

            quantity += scan.nextDouble();

            if (quantity<total) {
                System.out.println("Paranız yetersiz ekleme yapın");
                System.out.println("Ekleme yapacağınız miktar = " + (total - quantity) );
                System.out.println("....................");
            }
        }while(quantity<=total);

        double change = quantity - total;
        if (change > 0) {
            System.out.println("PARA ÜSTÜ : " + change);
        }
    }

    public static double showTheCart() {
        System.out.println("Ürün Adı \tKG \t\tFiyatı");
        System.out.println("=================================");

        double sepettekiToplam = 0;
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i) + "\t \t" + weightOnCart.get(i) + "\t\t" + priceOnCart.get(i));
            sepettekiToplam+= priceOnCart.get(i);

        }
        return sepettekiToplam;
    }

    public static void addToCart(int productNo, double kg) {

        cart.add(products.get(productNo));
        weightOnCart.add(kg);
        priceOnCart.add(prices.get(productNo)*kg);
    }

    public static void listProduct() {

        System.out.println("No\t Ürünler \tFiyatlar");
        System.out.println("===\t ======== \t========");

        for (int i = 0; i< products.size(); i++) {
            System.out.println(" "+ i + "\t" + products.get(i) + "\t\t" + prices.get(i));
        }
    }
}

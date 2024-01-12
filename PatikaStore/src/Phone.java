import java.util.ArrayList;
import java.util.Scanner;

public class Phone extends Products implements Operation {
    private int camera;
    private double batteryCapacity;
    private String color;
    private static ArrayList<Phone> phoneList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Phone(int id, String name, double price, double discountRate, int stock, String brandName, double screenSize, int ram, int memory, int camera, double batteryCapacity, String color) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public Phone() {
    }

    boolean isGone = true;

    @Override
    public void runMenu() {
        System.out.println("---------------------------");
        System.out.println("Telefon Yönetim Paneli");
        System.out.println("---------------------------");
        System.out.println("1 -Telefon listeleme \n" +
                "2 - Telefon ekleme \n" +
                "3 - Telefon silme \n" +
                "4 - id ye göre filtreleme \n" +
                "5 - Markaya göre filtreleme \n" +
                "0 - Çıkış Yap");
        System.out.println("---------------------------");
        System.out.print("Yapmak istediğiniz işlemi seçiniz : ");
        int selectionNotebook = input.nextInt();
        switch (selectionNotebook) {
            case 1:
                showProductList();
                break;
            case 2:
                addProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                filterByProductId();
                break;
            case 5:
                filterByProductBrand();
                break;
            case 0:
                PatikaStore patikaStore = new PatikaStore();
                patikaStore.run();
                System.out.println("Çıkış işleminiz yapıldı ");
                break;
            default:
                System.out.println("Hatalı bir değer girdiniz !!");
                isGone = false;
        }

    }

    @Override
    public void showProductList() {
        System.out.println("|ID NO |" + "|\t ÜRÜN ADI \t\t\t    |" + "| FİYAT |" + "| MARKA |" + "| DEPOLAMA |" + "| EKRAN |" + "| KAMERA |" + "| PİL |" + "| RAM |" + "| RENK |");
        for (Phone phones : phoneList) {
            System.out.println("|" + phones.getId() + "    |" + "| " + phones.getName() + " \t|" + "|\t " + phones.getPrice() + " |" + "| " + phones.getBrandName() + " |" + "| " + phones.getMemory() + " GB |" + "| " + phones.getScreenSize() + " |" + "| " + phones.getCamera() + " |" + "| " + phones.getBatteryCapacity() + " |" + "| " + phones.getRam() + "| " + "| " + phones.getColor() + " |");
        }
    }

    @Override
    public void addProduct() {
        ArrayList<Integer> phonesID = new ArrayList<>();
        for (Phone phones : phoneList) {
            phonesID.add(phones.getId());
        }
        System.out.println("Ürün bilgilerini aşağıdaki sıraya göre giriniz !!");
        System.out.print("ID numarası giriniz : ");
        int inputID = input.nextInt();
        if (!phonesID.contains(inputID)) {
            System.out.print("Ürün adı giriniz : ");
            String inputName = input.next().toUpperCase();
            System.out.println();
            System.out.print("Ürünün ücretini giriniz : ");
            double inputPrice = input.nextDouble();
            System.out.println();
            System.out.print("Ürünün indirim oranını giriniz : ");
            double inputdiscountRate = input.nextDouble();
            System.out.println();
            System.out.print("Ürün miktarını giriniz : ");
            int inputStock = input.nextInt();
            System.out.println();
            System.out.print("Marka adını giriniz : ");
            String inputBrandName = input.next().toUpperCase();
            System.out.println();
            System.out.print("Ekran boyutunu giriniz : ");
            double inputScreenSize = input.nextDouble();
            System.out.println();
            System.out.print("Ürünün RAM' ini giriniz : ");
            int inputRam = input.nextInt();
            System.out.println();
            System.out.print("Ürünün Depolama bilgisini giriniz : ");
            int inputMemory = input.nextInt();
            System.out.println();
            System.out.print("Ürünün Kamera özelliğini giriniz : ");
            int inputCamera = input.nextInt();
            System.out.println();
            System.out.print("Ürünün Pil kapasitesini giriniz : ");
            double inputBatteryCapacity = input.nextDouble();
            System.out.println();
            System.out.print("Ürünün rengini giriniz : ");
            String inputColor = input.next().toUpperCase();

            Phone phone4 = new Phone(inputID, inputName, inputPrice, inputdiscountRate, inputStock, inputBrandName, inputScreenSize, inputRam, inputMemory, inputCamera, inputBatteryCapacity, inputColor);
            phoneList.add(phone4);
        } else if (phonesID.contains(inputID)) {
            System.out.println("Bu ID numarasına ait başka bir ürün bulunmaktadır !!");
        } else {
            System.out.println("Geçersiz bir ID numarası girdiniz !!");
        }
    }

    @Override
    public void deleteProduct() {
        showProductList();
        System.out.print("Silmek istediğiniz ürünün ID numarasını giriniz : ");
        int deleteProduct = input.nextInt();
        try {
            for (Phone addPhone : phoneList) {
                if (deleteProduct == addPhone.getId()) {
                    phoneList.remove(addPhone);
                    System.out.println(addPhone.getName() + " isimli ürünü silindi.");

                } else {
                    System.out.println("Bu ID  numarasına ait ürün bulunamadı !!");

                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        showProductList();
    }

    @Override
    public void filterByProductId() {
        showProductList();
        ArrayList<Phone> filterArr = new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz ürünün ID sini giriniz : ");
        int selectID = input.nextInt();
        try {
            boolean found = false;
            for (Phone phone : phoneList) {
                if (selectID == phone.getId()) {
                    System.out.println();
                    System.out.println("Ürüne ait bilgiler aşağıdadır !!");
                    System.out.println("|ID NO |" + "|\t ÜRÜN ADI \t\t\t    |" + "| FİYAT\t|" + "| MARKA |" + "| DEPOLAMA |" + "| EKRAN |" + "| KAMERA |" + "| PİL |" + "| RAM |" + "| RENK |");
                    System.out.println("|" + phone.getId() + "    |" + "| " + phone.getName() + " \t|" + "|\t " + phone.getPrice() + " |" + "| " + phone.getBrandName() + " |" + "| " + phone.getMemory() + " GB |" + "| " + phone.getScreenSize() + " |" + "|\t " + phone.getCamera() + "\t|" + "| " + phone.getBatteryCapacity() + " |" + "| " + phone.getRam() + "| " + "| " + phone.getColor() + " |");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Bu ID  numarasına ait ürün bulunamadı !!");

            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    public void filterByProductBrand() {
        showProductList();
        ArrayList<Phone> filterArr = new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz ürünün markasını yazınız : ");
        String selectBrand = input.next().toUpperCase();
        try {
            boolean found = false;
            for (Phone phone : phoneList) {
                if (selectBrand.equals(phone.getBrandName())) {
                    System.out.println();
                    System.out.println("Ürüne ait bilgiler aşağıdadır !!");
                    System.out.println("|ID NO |" + "|\t ÜRÜN ADI \t\t\t    |" + "| FİYAT\t|" + "| MARKA |" + "| DEPOLAMA |" + "| EKRAN |" + "| KAMERA |" + "| PİL |" + "| RAM |" + "| RENK |");
                    System.out.println("|" + phone.getId() + "    |" + "| " + phone.getName() + " \t|" + "|\t " + phone.getPrice() + " |" + "| " + phone.getBrandName() + " |" + "| " + phone.getMemory() + " GB |" + "| " + phone.getScreenSize() + " |" + "|\t " + phone.getCamera() + "\t|" + "| " + phone.getBatteryCapacity() + " |" + "| " + phone.getRam() + "| " + "| " + phone.getColor() + " |");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Bu markaya ait ürün bulunamadı !!");

            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    static {
        Phone phone1 = new Phone(47, "SAMSUNG GALAXY A51    ", 3199, 0.9, 74, "SAMSUNG", 6.5, 6, 128, 32, 4000.0, "SİYAH ");
        Phone phone2 = new Phone(53, "IPHONE 11 64GB        ", 7379.0, 0.3, 82, "IPHONE", 6.1, 6, 64, 5, 3046.0, "MAVİ     ");
        Phone phone3 = new Phone(458, "REDMİ NOTE 10 PRO 8GB", 4012.0, 0.8, 175, "XİAOMİ", 6.5, 12, 128, 35, 4000.0, "BEYAZ ");

        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);
    }

}

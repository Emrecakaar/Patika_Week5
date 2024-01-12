import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;


public class Notebook extends Products implements Operation {
    private static ArrayList<Notebook> notebookList = new ArrayList<>();

    public Notebook(int id, String name, double price, double discountRate, int stock, String brandName, double screenSize, int ram, int memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }

    public Notebook() {
    }

    Scanner input = new Scanner(System.in);
    boolean isGone = true;

    @Override
    public void runMenu() {
        System.out.println("---------------------------");
        System.out.println("Notebook Yönetim Paneli");
        System.out.println("---------------------------");
        System.out.println("1 -Notebook listeleme \n" +
                "2 - Notebook ekleme \n" +
                "3 - Notebook silme \n" +
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
        System.out.println("|ID NO |" + "|\t ÜRÜN ADI \t\t\t|" + "| FİYAT  |" + "| MARKA  |" + "|DEPOLAMA|" + "| EKRAN|" + "| RAM   |");

        for (Notebook notebooks : notebookList) {
            System.out.println("| " + notebooks.getId() + "  |" + "| " + notebooks.getName() + "\t|" + "| " + notebooks.getPrice() + " |" + "| " + notebooks.getBrandName() + " |" + "| " + notebooks.getMemory() + "|" + "| " + notebooks.getScreenSize() + " |" + "| " + notebooks.getRam() + "    |");
        }
    }


    @Override
    public void addProduct() {
        ArrayList<Integer> notebooksID = new ArrayList<>();
        for (Notebook notebook : notebookList) {
            notebooksID.add(notebook.getId());
        }
        System.out.println("Ürün bilgilerini aşağıdaki sıraya göre giriniz !!");
        System.out.print("ID numarası giriniz : ");
        int inputID = input.nextInt();
        if (!notebooksID.contains(inputID)) {
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

            Notebook notebook4 = new Notebook(inputID, inputName, inputPrice, inputdiscountRate, inputStock, inputBrandName, inputScreenSize, inputRam, inputMemory);
            notebookList.add(notebook4);
        } else if (notebooksID.contains(inputID)) {
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
            for (Notebook addNotebook : notebookList) {
                if (deleteProduct == addNotebook.getId()) {
                    notebookList.remove(addNotebook);
                    System.out.println(addNotebook.getName() + " isimli ürünü silindi.");

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
        ArrayList<Notebook> filterArr = new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz ürünün ID sini giriniz : ");
        int selectID = input.nextInt();
        try {
            boolean found = false;
            for (Notebook notebook : notebookList) {
                if (selectID == notebook.getId()) {
                    System.out.println();
                    System.out.println("Ürüne ait bilgiler aşağıdadır !!");
                    System.out.println("|ID NO |" + "|\t ÜRÜN ADI \t\t\t|" + "| FİYAT  |" + "| MARKA  |" + "|DEPOLAMA|" + "| EKRAN|" + "| RAM   |");
                    System.out.println("| " + notebook.getId() + "  |" + "| " + notebook.getName() + "\t|" + "| " + notebook.getPrice() + " |" + "| " + notebook.getBrandName() + " |" + "| " + notebook.getMemory() + "|" + "| " + notebook.getScreenSize() + " |" + "| " + notebook.getRam() + "    |");
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
        ArrayList<Notebook> filterArr = new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz ürünün markasını yazınız : ");
        String selectBrand = input.next().toUpperCase();
        try {
            boolean found = false;
            for (Notebook notebook : notebookList) {
                if (selectBrand.equals(notebook.getBrandName())) {
                    System.out.println();
                    System.out.println("Ürüne ait bilgiler aşağıdadır !!");
                    System.out.println("|ID NO |" + "|\t ÜRÜN ADI \t\t\t|" + "| FİYAT  |" + "| MARKA  |" + "|DEPOLAMA|" + "| EKRAN|" + "| RAM   |");
                    System.out.println("| " + notebook.getId() + "  |" + "| " + notebook.getName() + "\t|" + "| " + notebook.getPrice() + " |" + "| " + notebook.getBrandName() + " |" + "| " + notebook.getMemory() + "|" + "| " + notebook.getScreenSize() + " |" + "| " + notebook.getRam() + "    |");
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

    @Override
    public int getId() {
        return super.getId();
    }

    static {
        Notebook notebook1 = new Notebook(725, "HUAWEİ Matebook 14", 7000.0, 10, 24, "HUAWEİ", 14.0, 16, 512);
        Notebook notebook2 = new Notebook(834, "LENOVO V14 IGL    ", 3699.0, 12, 84, "LENOVO", 14.0, 8, 1024);
        Notebook notebook3 = new Notebook(972, "ASUS Tuf Gaming   ", 8199.0, 14, 102, "ASUS  ", 15.6, 32, 2048);

        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);
    }
}



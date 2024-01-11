import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String text = "Bilgiye ulaşmanın hem çok kolay hem de çok zor olduğu şu son zamanlarda, insanların bilgi ihtiyacını karşılamak için ille de basılı kaynaklara yönelmelerini beklemek oldukça yanlış bir düşünce biçimidir. Bilgi patlaması teriminin tam anlamıyla karşıladığı bu bilgi çokluğu içerisindeki karmaşa, bilgiye olan talebin büyüklüğünü anlatmakla beraber; doğru bilgiye ulaşmanın zorluğunu da belirtmiş oluyor.\n" +
                "\n" +
                "Günlük hayatta yapmış olduğumuz gazete, kitap, magazin okuma, radyo dinleme, televizyon ya da film izleme, bilgisayar kullanma gibi hareketler bilgiye ulaşmak için kullandığımız yollardır. Her şeyin bu kadar çok ve çabuk değişti bir zaman diliminde, bilgiye ulaşmak için en önemli araçlardan birisi olarak tanımladığımız, bilgiye dayalı belgenin ham maddesi metinin ulaşım ve kullanım yollarının değişmemesini beklemek eksik bir düşüncedir.";

        String[] words = text.split(" ");

        for (String word : words) {
            //Burada kelimeleri küçük harfe çevirerek bütün kelimeleri eşit hale getiriyorum
            String cleanedWord = word.toLowerCase();

            // Kelimenin boş olup olmadığını kontrol ediyorum
            if (!cleanedWord.isEmpty()) {
                //Kelimenin kaç kere tekrar ettiğini buluyorum
                wordCountMap.put(cleanedWord, wordCountMap.getOrDefault(cleanedWord, 0) + 1);
            }
        }

        // Burada en sık kullanılan kelimeyi buluyorum.
        String mostFrequentWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        // Ve ekrana çıktı veriyorum.
        System.out.println("En çok geçen kelime: " + mostFrequentWord);
        System.out.println("Kelimenin tekrar sayısı: " + maxCount);
    }
}
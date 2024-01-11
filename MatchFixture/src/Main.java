import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> Clubs = new ArrayList<>();
        Clubs.add("Manchester United");
        Clubs.add("Liverpool");
        Clubs.add("Manchester City");
        Clubs.add("Chelsea");
        Clubs.add("Arsenal");
        Clubs.add("Tottenham Hotspur");
        Clubs.add("Leicester City");
        Clubs.add("Everton");

        Fixtur(Clubs);
    }

    public static void Fixtur(List<String> clubs) {
        int clubsNumber = clubs.size();

        for (int sezon = 1; sezon <= 2; sezon++) {

            System.out.println("Sezon " + sezon + " Fikstürü:");


            }

            // Takımları döndür
            Collections.rotate(clubs.subList(1, clubsNumber), 1);
            System.out.println();
        }
    }
}
package GUI.zadanie_01_01;

public class Main {
    public static void main(String[] args) {
        Singer s1 = new Singer("Martin"){
            @Override
            String sing() {
                return "Arrivederci, Roma";
            }
        };
        Singer s2 = new Singer("Joplin"){
            @Override
            String sing() {
                return "...for me and my Bobby MacGee";
            }
        };
        Singer s3 = new Singer("Houston"){
            @Override
            String sing() {
                return "I will always love youuuu";
            }
        };
        Singer sng[] = {s1, s2, s3};
        for (Singer s : sng) System.out.println(s);
        System.out.println("\n" + Singer.loudest(sng));
    }
}
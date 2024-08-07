package ar.edu.utn.frc.tup.lciii;

public class Printer{
    public static void println(String text) {
        try {
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(10);
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            Task10v2 ttt = new Task10v2();
            ttt.split("D:\\Games\\Maid.of.Sker.v1.0.42156-GOG\\123.bin","our",3000000000L);
            Task4 task4 = new Task4();
            task4.copeToUpperCase("source.txt", "destination.txt");
        }
        catch (Error err)
        {
            System.out.println(err.getMessage());
        }
    }
}
//"D:\\Games\\Maid.of.Sker.v1.0.42156-GOG\\123.bin"

import java.util.Random;

public class generatorUniqueID {
    public static void main(String args[]) {
        Random id = new Random();
        System.out.println(id.nextInt(10000));

    }

}

public class lowerCase {

    public static void main(String args[]) {
        String str = "Hello Maam";
        String str2 = str.toLowerCase();
        System.out.println(str2);
        String str3 = str2.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(str3);
    }

}

import java.util.LinkedList;

class linekdLists {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.add(("Monis"));
        list.add(("XYZ"));
        System.out.println(list);
        list.addFirst("Mohammed");
        System.out.println(list);
        list.addLast(("Raza"));
        System.out.println(list);
        list.remove();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
    }
}

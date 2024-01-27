import java.util.PriorityQueue;

public class priorityQueueObjects {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String args[]) {

        PriorityQueue<Student> pq = new PriorityQueue<>();// for reverse the order just add Comparator.reverseOrder int
                                                          // the functionheaps
        pq.add(new Student("A", 10));
        pq.add(new Student("B", 11));
        pq.add(new Student("C", 5));
        pq.add(new Student("D", 2));
        pq.add(new Student("E", 1));
        System.out.println("Ranks" + " Student Name");
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().rank + "\t " + pq.peek().name);
            pq.remove();
        }

    }

}

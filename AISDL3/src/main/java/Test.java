import java.util.HashSet;

public class Test {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add(5);
        hashSet.add(10);

        System.out.println(hashSet.size());

        hashSet.add(5);
        hashSet.add(5);
        hashSet.add(5);
        hashSet.add(5);
        System.out.println(hashSet.size());

    }
}

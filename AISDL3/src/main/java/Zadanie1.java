import Models.Edge;
import Models.Element;
import Structures.PriorityQueque;

import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        String[] arg = {"6", ""};
        Scanner scanner = new Scanner(System.in);
        PriorityQueque priorityQueque = new PriorityQueque(Element.class);
        String val;
        while (true) {
            // wszystko dziala nie wiem jak priority
            System.out.println("Podaj co chcesz zrobić: \n1. insert x p \n2. isEmpty \n3. top \n4. pop \n5. priority \n6. print");
            val = scanner.next();
            if (val.equals("1")) {
                priorityQueque.insert(new Element(scanner.nextInt(), scanner.nextInt()));
                priorityQueque.print();
            } else if (val.equals("2")) {
                System.out.println(priorityQueque.isEmpty());
            } else if (val.equals("3")) {
                System.out.println(priorityQueque.top());
            } else if (val.equals("4")) {
                System.out.println(priorityQueque.pop());
            } else if (val.equals("5")) {
                priorityQueque.changePriority(scanner.nextInt(), scanner.nextInt());
            } else if (val.equals("6")) {
                priorityQueque.print();
            }


        }


    }
}

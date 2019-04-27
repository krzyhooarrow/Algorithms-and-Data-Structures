package Models;

public class Element implements PriorityAble<Element> {

    private int value;
    private int priority;

    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Element o) {
        return this.priority - o.getPriority();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    @Override
    public String toString() {
        return "Models.Element{" +
                "value=" + value +
                ", priority=" + priority +
                '}';
    }



}

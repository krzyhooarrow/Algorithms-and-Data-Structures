import java.util.Arrays;

public class Vertex implements Comparable<Vertex> {

    private int number;
    private int[] label;

    public Vertex(int number, int[] label) {
        this.number = number;
        this.label = label;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int[] getLabel() {
        return label;
    }

    public void setLabel(int[] label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "number=" + number +
                ", label=" + Arrays.toString(label) +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        int counter1=0,counter2=0;
        for (int i=0 ; i < label.length;i++)
            if (label[i]==1)
                counter1+=Math.pow(2,i);

        for (int i=0 ; i < o.label.length;i++)
            if (o.label[i]==1)
                counter2+=Math.pow(2,i);
        return counter1-counter2;
    }
}

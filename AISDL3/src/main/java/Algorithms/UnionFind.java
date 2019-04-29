package Algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UnionFind {

    private List<Set<Integer>> SetsList = new LinkedList<>();

    public List<Set<Integer>> getSetsList() {
        return SetsList;
    }

    public Set<Integer> MakeSet(int x) {
        Set<Integer> a = new HashSet<Integer>();
        a.add(x);
        return a;

    }


    public Set<Integer> find(int x) {
        for (Set<Integer> set : SetsList) {
            if (set.contains(x))
                return set;
        }
        System.out.println("Nul");
        return null;
    }


    public <T> Set<T> union(Set<T> a, Set<T> b) {
        a.addAll(b);
//        b.clear();
        SetsList.remove(b);
        return a;
    }//sets remove
}



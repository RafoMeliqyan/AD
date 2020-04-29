package comparator;

import model.AD;

import java.util.Comparator;

public class ComparatorTitle implements Comparator<AD> {
    @Override
    public int compare(AD o1, AD o2) {
        System.out.println(o1.getTitle().compareTo(o2.getTitle()));
        return 0;
    }
}

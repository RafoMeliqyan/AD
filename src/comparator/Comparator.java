package comparator;

import model.AD;

public class Comparator implements java.util.Comparator<AD> {
    @Override
    public int compare(AD o1, AD o2) {
        System.out.println(o1.getDate().compareTo(o2.getDate()));
        return 0;
    }
}

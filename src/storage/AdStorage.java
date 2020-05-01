package storage;

import comparator.ComparatorTitle;
import model.AD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdStorage {
    List<AD> adList;

    public AdStorage(int length) {
        adList = new ArrayList<>(length);
    }

    public AdStorage() {
        adList = new ArrayList<>();
    }

    public void add(AD value) {
        adList.add(value);
    }


    public AD printAdByCategory(String category) throws Exception {
        if (adList.isEmpty()) {
            System.out.println("Add ad first!!!");
        } else {
            for (AD ad : adList) {
                if (ad.getCategory().equals(category)) {
                    System.out.println(ad);
                } else {
                    throw new Exception("No ad with %s category");
                }
            }
        }
        return null;
    }

    public void printAllAdsByTitleSort() {
        ComparatorTitle comparatorTitle = new ComparatorTitle();
        adList.sort(comparatorTitle);
        for (AD ad : adList) {
            System.out.println(ad);
        }
    }

    public void printAllAdsByDateSort() {
        comparator.Comparator comparator = new comparator.Comparator();
        adList.sort(comparator);
        for (AD ad : adList) {
            System.out.println(ad);
        }
    }

    public void deleteMyAllAds() {
        if (adList.isEmpty()) {
            System.out.println("Please add ad first!!!");
        } else {
            for (AD ad : adList) {
                adList.remove(ad);
            }
            System.out.println("Deleted!!!");
        }
    }

    public void deleteAdsByTitle(String title) throws Exception {
        if (adList.isEmpty()) {
            System.out.println("Please add ad first!!!");
        } else {
            for (AD ad : adList) {
                if (ad.getTitle().equals(title)) {
                    adList.remove(ad);
                    System.out.println("Deleted!!!");
                } else {
                    System.out.println("No ad with " + title + "title!");
                }
            }
            throw new Exception("No ad with %s title");
        }
    }

    public void printAllAds() {
        if (adList.isEmpty()) {
            System.out.println("Please add ad first!");
        } else {
            for (AD ad : adList) {
                System.out.println(ad);
            }
        }
    }


    public void printMyAllAds() {
        if (adList.isEmpty()) {
            System.out.println("Please add ad first!!");
        } else {
            for (AD ad : adList) {
                System.out.println(ad);
            }
        }
    }
}

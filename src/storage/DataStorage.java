package storage;

import file.FileUtil;
import file.FileUtilItem;
import model.Category;
import model.Item;
import model.User;

import java.io.IOException;
import java.util.*;

public class DataStorage {

    private static long itemId = 1;

    private Map<String, User> userMap = new HashMap<>();
    private List<Item> items = new ArrayList<>();

    public void add(User user) throws IOException, ClassNotFoundException {
        FileUtil fileUtil = new FileUtil();
        userMap.put(user.getPhoneNumber(), user);
        fileUtil.serializeUserMap(userMap);
        fileUtil.deserializeUserMap();
    }

    public void add(Item item) throws IOException, ClassNotFoundException {
        FileUtilItem fileUtilItem = new FileUtilItem();
        item.setId(itemId++);
        items.add(item);
        fileUtilItem.serializeItemMap(items);
        fileUtilItem.deserializeItemMap();
    }

    public User getUser(String phoneNumber) {
        return userMap.get(phoneNumber);
    }

    public Item getItemById(long id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void printItems() {
        if (items.isEmpty()) {
            System.out.println("Please add ad first!");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void printItemsOrderByTitle() {
        List<Item> orderedList = new ArrayList<>(items);
        Collections.sort(orderedList);
//        orderedList.sort(Item::compareTo);
        for (Item item : orderedList) {
            System.out.println(item);
        }
    }

    public void printItemsOrderByDate() {
        List<Item> orderedList = new ArrayList<>(items);
//        orderedList.sort(Comparator.comparing(Item::getCreatedDate));
        orderedList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getCreatedDate().compareTo(o2.getCreatedDate());
            }
        });
        for (Item item : orderedList) {
            System.out.println(item);
        }
    }

    public void printItemsByUser(User user) {
        if (items.isEmpty()) {
            System.out.println("Please add ad first!");
        } else {
            for (Item item : items) {
                if (item.getUser().equals(user)) {
                    System.out.println(item);
                }
            }
        }
    }

    public void printItemsByCategory(Category category) {
        if (items.isEmpty()) {
            System.out.println("Please add ad first!");
        } else {
            for (Item item : items) {
                if (item.getCategory() == category) {
                    System.out.println(item);
                }
            }
        }
    }

    public void deleteItemsByUser(User user) throws IOException, ClassNotFoundException {
        FileUtil fileUtil = new FileUtil();
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item next = iterator.next();
            if (next.getUser().equals(user)) {
                iterator.remove();
                System.out.println("Deleted!!");
                fileUtil.serializeUserMap(userMap);
                fileUtil.deserializeUserMap();
            }
        }
//        items.removeIf(item -> item.getUser().equals(user));
    }

    public void deleteItemsById(long id) throws IOException, ClassNotFoundException {
        FileUtilItem fileUtilItem = new FileUtilItem();
        items.remove(getItemById(id));
        fileUtilItem.serializeItemMap(items);
        fileUtilItem.deserializeItemMap();
        System.out.println("Deleted!!");
    }

    public void initData() throws IOException, ClassNotFoundException {
        FileUtil fileUtil = new FileUtil();
        FileUtilItem fileUtilItem = new FileUtilItem();
        fileUtil.deserializeUserMap();
        fileUtilItem.deserializeItemMap();
    }

}

package file;

import model.Item;

import java.io.*;
import java.util.List;

public class FileUtilItem {

    private static final String FILE_PATH_ITEM = "C:\\AD\\src\\file\\itemData.txt";

    public void serializeItemMap(List<Item> itemList) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH_ITEM));
        objectOutputStream.writeObject(itemList);
        objectOutputStream.close();
    }

    public List<Item> deserializeItemMap() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH_ITEM));
        Object object = objectInputStream.readObject();
        if (object instanceof Item) {
            Item item = (Item) object;
            System.out.println(item);
        }
        return null;
    }

}

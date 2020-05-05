package file;

import model.User;

import java.io.*;
import java.util.Map;

public class FileUtil {

    private static final String FILE_PATH_USER = "C:\\AD\\src\\file\\userData.txt";

    public static void serializeUserMap(Map<String, User> userMap) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH_USER));
        objectOutputStream.writeObject(userMap);
        objectOutputStream.close();
    }

    public static Map<String,User> deserializeUserMap() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH_USER));
        Object object = objectInputStream.readObject();
        if (object instanceof User) {
            User user1 = (User) object;
            System.out.println(user1);
        }
        return null;
    }

}

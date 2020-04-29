package storage;

import exception.UserNotFoundException;
import model.User;

import java.util.HashMap;
import java.util.Map;


public class UserStorage {
    Map<User,Integer> userIntegerMap;

    public UserStorage(int length) {
        userIntegerMap = new HashMap<>(length);
    }

    public UserStorage() {
        userIntegerMap = new HashMap<>();
    }

    public void add(User value) throws NullPointerException{
        userIntegerMap.put(value,1);
    }



    public User getUserByPhoneNumberAndPassword(int phoneNumber, String password) throws UserNotFoundException {
        for (User user : userIntegerMap.keySet()) {
            if (user.getPhoneNumber() == phoneNumber && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with email " + phoneNumber + " and password " + password + " does not exist");
    }

    public User getUserByName(String name) throws UserNotFoundException {
        for (User user : userIntegerMap.keySet()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with name " + name + " does not exist");
    }


    public boolean isEmptyUser() {
        return userIntegerMap.isEmpty();
    }
}

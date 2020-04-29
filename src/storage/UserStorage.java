package storage;

import exception.UserNotFoundException;

import model.User;

import java.util.ArrayList;
import java.util.List;


public class UserStorage {
//    private int size = 0;
    List<User> userList;
//    Object[] array;

    public UserStorage(int length) {
        userList = new ArrayList<>();
//        array = new Object[length];
    }

    public UserStorage() {
        userList = new ArrayList<>();
//        array = new Object[16];
    }

    public void add(User value) throws NullPointerException{
        userList.add(value);
    }

//    private void extend() {
//        Object[] tmp = new User[array.length + 10];
//        System.arraycopy(array,0,tmp,0,array.length);
//        array = tmp;
//    }

    public void printAllUsers() {
        for (User user : userList) {
            System.out.println(user);
        }
//        if (size != 0) {
//            for (int i = 0; i < size; i++) {
//                System.out.println(array[i]);
//            }
//        } else {
//            System.out.println("Please add post!!!");
//        }
    }

    public User getUserByEmail(String email) throws UserNotFoundException {
        userList.get(Integer.parseInt(email));
//        for (int i = 0; i < array.length; i++) {
//            User t = (User) array[i];
//            if (t.getEmail().equals(email)) {
//                return (T) array[i];
//            }
//        }
        throw new UserNotFoundException("User with " + email + " does not exist");
    }

    public User getUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(0).equals(email) && userList.get(0).equals(password)) {
                return (User) userList;
            } else {
                System.out.println("Wrong email or password!!!");
            }
        }
        throw new UserNotFoundException("User with email " + email + " and password " + password + " does not exist");
    }

    public User getUserByName(String name) throws UserNotFoundException {
//        for (int i = 0; i < array.length; i++) {
//            User t = (User) array[i];
//            if (t.getName().equals(name)) {
//                return (T) array[i];
//            }
//        }
        throw new UserNotFoundException("User with name " + name + " does not exist");
    }


    public boolean isEmptyUser() {
        return userList.isEmpty();
    }
}

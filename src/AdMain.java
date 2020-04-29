
import model.AD;
import model.User;
import storage.AdStorage;
import storage.UserStorage;

import java.util.Scanner;

public class AdMain implements Commands {
    public static UserStorage userStorage = new UserStorage();
    public static AdStorage adStorage = new AdStorage();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
                command = -1;
            }
            switch (command) {
                case EXIT:
                    System.out.println("Bye!!!");
                    isRun = false;
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    System.out.println("Wrong command!!!");
            }
        }
    }

    private static void register() {
        System.out.println("Please input name,surname,gender,age,phoneNumber,password");
        try {
            String userStr = scanner.nextLine();
            String[] userData = userStr.split(",");
            User user = new User();
            user.setName(userData[0]);
            user.setSurname(userData[1]);
            user.setGender(userData[2]);
            user.setAge(Integer.parseInt(userData[3]));
            user.setPhoneNumber(Integer.parseInt(userData[4]));
            user.setPassword(userData[5]);
            userStorage.add(user);
            System.out.println("User added!!!");
        } catch (Exception e) {
            System.out.println("Invalid data!!!");
            register();
        }
    }

    private static void login() {
        if (userStorage.isEmptyUser()) {
            System.out.println("Please register first!!!");
        } else {
            System.out.println("Please input phoneNumber,password");
            String userStr = scanner.nextLine();
            String[] userData = userStr.split(",");
            try {
                userStorage.getUserByPhoneNumberAndPassword(Integer.parseInt(userData[0]), userData[1]);
                userLogin();
            } catch (Exception e) {
                System.out.println("Incorrect value, please try again!");
            }
        }
    }

    private static void userLogin() {
        System.out.println("Welcome!!!");
        boolean isRun = true;
        while (isRun) {
            Commands.printADCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_NEW_AD:
                    addNewAd();
                    break;
                case PRINT_MY_ALL_ADS:
                    printMyAllAds();
                    break;
                case PRINT_ALL_ADS:
                    adStorage.printAllAds();
                    break;
                case PRINT_AD_BY_CATEGORY:
                    adByCategory();
                    break;
                case PRINT_ALL_ADS_BY_TITLE_SORT:
                    adStorage.printAllAdsByTitleSort();
                    break;
                case PRINT_ALL_ADS_BY_DATE_SORT:
                    printAdByDateSort();
                    break;
                case DELETE_MY_ALL_ADS:
                    adStorage.deleteMyAllAds();
                    break;
                case DELETE_AD_BY_TITLE:
                    deleteAdByTitle();
                    break;
                default:
                    System.out.println("Wrong command!!!");
            }
        }
    }

    private static void printAdByDateSort() {
        adStorage.printAllAdsByDateSort();
    }

    private static void deleteAdByTitle() {
        System.out.println("Import title for delete ad");
        String adTitle = scanner.nextLine();
        try {
            adStorage.deleteAdsByTitle(adTitle);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private static void adByCategory() {
        System.out.println("Import category for search");
        String adCategory = scanner.nextLine();
        try {
            adStorage.printAdByCategory(adCategory);
        } catch (Exception e) {
            System.out.println("Incorrect value");
        }
    }

    private static void printMyAllAds() {
        adStorage.printMyAllAds();
    }

    private static void addNewAd() {
        System.out.println("Input user name");
        String userName = scanner.nextLine();
        try {
            userStorage.getUserByName(userName);
            System.out.println("Import post data (title,text,price,category)");
            try {
                String postDataStr = scanner.nextLine();
                String[] postData = postDataStr.split(",");
                AD ad = new AD();
                ad.setTitle(postData[0]);
                ad.setText(postData[1]);
                ad.setPrice(Double.parseDouble(postData[2]));
                ad.setCategory(postData[3]);
                ad.setAuthor(userName);
                adStorage.add(ad);
                System.out.println("Ad added!!!");
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Incorrect value! Please try again!");
                addNewAd();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

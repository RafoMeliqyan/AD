
import commands.Commands;
import model.Category;
import model.Gender;
import model.Item;
import model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import storage.DataStorage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class AdvertisementMain implements Commands {

    private static Scanner scanner = new Scanner(System.in);
    private static DataStorage dataStorage = new DataStorage();
    private static User currentUser = null;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //init data
        dataStorage.initData();
//        dataStorage.add(new User("poxos","poxosyan",22,Gender.MALE,"321321","321321"));

        boolean isRun = true;
        while (isRun) {
            dataStorage.initData();
            Commands.printMainCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    loginUser();
                    break;
                case REGISTER:
                    registerUser();
                    break;
                case IMPORT_USERS:
                    importFromXlsx();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void importFromXlsx() throws ClassNotFoundException {
        System.out.println("Please select xlsx path");
        String xlsxPath = scanner.nextLine();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(xlsxPath);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 1; i <= lastRowNum; i++) {
                Row row = sheet.getRow(i);
                String name = row.getCell(0).getStringCellValue();
                String surname = row.getCell(1).getStringCellValue();
                Double age = row.getCell(2).getNumericCellValue();
                Gender gender = Gender.valueOf(row.getCell(3).getStringCellValue());
                Cell phoneNumber = row.getCell(4);
                String phoneNumberStr = phoneNumber.getCellType() == CellType.NUMERIC ? String.valueOf(Double.valueOf(phoneNumber.getNumericCellValue()).intValue())
                        : phoneNumber.getStringCellValue();
                Cell password = row.getCell(5);
                String passwordStr = password.getCellType() == CellType.NUMERIC ? String.valueOf(Double.valueOf(password.getNumericCellValue()).intValue())
                        : password.getStringCellValue();
                User user = new User();
                user.setName(name);
                user.setSurname(surname);
                user.setAge(age.intValue());
                user.setGender(gender);
                user.setPhoneNumber(phoneNumberStr);
                user.setPassword(passwordStr);
                System.out.println(user);
                dataStorage.add(user);
                System.out.println("Import was success");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error while importing users");
        }
    }

    private static void registerUser() throws IOException, ClassNotFoundException {
        System.out.println("Please input user data " +
                "name,surname,gender(MALE,FEMALE),age,phoneNumber,password");
        try {
            String userDataStr = scanner.nextLine();
            String[] userDataArr = userDataStr.split(",");
            User userFromStorage = dataStorage.getUser(userDataArr[4]);
            if (userFromStorage == null) {
                User user = new User();
                user.setName(userDataArr[0]);
                user.setSurname(userDataArr[1]);
                user.setGender(Gender.valueOf(userDataArr[2].toUpperCase()));
                user.setAge(Integer.parseInt(userDataArr[3]));
                user.setPhoneNumber(userDataArr[4]);
                user.setPassword(userDataArr[5]);
                dataStorage.add(user);
                System.out.println("User was successfully added");
            } else {
                System.out.println("User already exists!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong Data!");
        }
    }

    private static void loginUser() throws IOException, ClassNotFoundException {
        System.out.println("Please input phoneNumber,password");
        try {
            String loginStr = scanner.nextLine();
            String[] loginArr = loginStr.split(",");
            User user = dataStorage.getUser(loginArr[0]);
            if (user != null && user.getPhoneNumber().equals(loginArr[0]) && user.getPassword().equals(loginArr[1])) {
                currentUser = user;
                loginSuccess();
            } else {
                System.out.println("Wrong phoneNumber or password");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong Data!");
        }
    }

    private static void loginSuccess() throws IOException, ClassNotFoundException {
        System.out.println("Welcome " + currentUser.getName() + "!");
        boolean isRun = true;
        while (isRun) {
            Commands.printUserCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_NEW_AD:
                    addNewItem();
                    break;
                case PRINT_MY_ADS:
                    dataStorage.printItemsByUser(currentUser);
                    break;
                case PRINT_ALL_ADS:
                    dataStorage.printItems();
                    break;
                case PRINT_ADS_BY_CATEGORY:
                    printByCategory();
                    break;
                case PRINT_ALL_ADS_SORT_BY_TITLE:
                    dataStorage.printItemsOrderByTitle();
                    break;
                case PRINT_ALL_ADS_SORT_BY_DATE:
                    dataStorage.printItemsOrderByDate();
                    break;
                case DELETE_MY_ALL_ADS:
                    dataStorage.deleteItemsByUser(currentUser);
                    break;
                case DELETE_AD_BY_ID:
                    deleteById();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void deleteById() throws IOException, ClassNotFoundException {
        System.out.println("please choose id from list");
        dataStorage.printItemsByUser(currentUser);
        long id = Long.parseLong(scanner.nextLine());
        Item itemById = dataStorage.getItemById(id);
        if (itemById != null && itemById.getUser().equals(currentUser)) {
            dataStorage.deleteItemsById(id);
        } else {
            System.out.println("Wrong id!");
        }
    }

    private static void printByCategory() {
        System.out.println("Please choose category name from list: " + Arrays.toString(Category.values()));
        try {
            String categoryStr = scanner.nextLine();
            Category category = Category.valueOf(categoryStr);
            dataStorage.printItemsByCategory(category);
        } catch (Exception e) {
            System.out.println("Wrong Category!");
        }
    }

    private static void addNewItem() {
        System.out.println("Please input item data title,text,price,category");
        System.out.println("Please choose category name from list: " + Arrays.toString(Category.values()));
        try {
            String itemDataStr = scanner.nextLine();
            String[] itemDataArr = itemDataStr.split(",");
            Item item = new Item(itemDataArr[0], itemDataArr[1], Double.parseDouble(itemDataArr[2])
                    , currentUser, Category.valueOf(itemDataArr[3]), new Date());
            dataStorage.add(item);
            System.out.println("Item was successfully added");
        } catch (Exception e) {
            System.out.println("Wrong Data!");
        }
    }

}

public interface Commands {
    int EXIT = 0;
    int LOGIN = 1;
    int REGISTER = 2;

    int LOGOUT = 0;
    int ADD_NEW_AD = 1;
    int PRINT_MY_ALL_ADS = 2;
    int PRINT_ALL_ADS = 3;
    int PRINT_AD_BY_CATEGORY = 4;
    int PRINT_ALL_ADS_BY_TITLE_SORT = 5;
    int PRINT_ALL_ADS_BY_DATE_SORT = 6;
    int DELETE_MY_ALL_ADS = 7;
    int DELETE_AD_BY_TITLE = 8;

    static void printMainCommands() {
        System.out.println("Import " + EXIT + " for EXIT");
        System.out.println("Import " + LOGIN + " for LOGIN");
        System.out.println("Import " + REGISTER + " for REGISTER");
    }

    static void printADCommands() {
        System.out.println("Import " + LOGOUT + " for LOGOUT");
        System.out.println("Import " + ADD_NEW_AD + " for ADD_NEW_AD");
        System.out.println("Import " + PRINT_MY_ALL_ADS + " for PRINT_MY_ALL_ADS");
        System.out.println("Import " + PRINT_ALL_ADS + " for PRINT_ALL_ADS");
        System.out.println("Import " + PRINT_AD_BY_CATEGORY + " for PRINT_AD_BY_CATEGORY");
        System.out.println("Import " + PRINT_ALL_ADS_BY_TITLE_SORT + " for PRINT_ALL_ADS_BY_TITLE_SORT");
        System.out.println("Import " + PRINT_ALL_ADS_BY_DATE_SORT + " for PRINT_ALL_ADS_BY_DATE_SORT");
        System.out.println("Import " + DELETE_MY_ALL_ADS + " for DELETE_MY_ALL_ADS");
        System.out.println("Import " + DELETE_AD_BY_TITLE + " for DELETE_AD_BY_TITLE");
    }

}

package LooseCoupling;

public class LooseCouplingExample {

    public static void main(String[] args) {
        UserDataProvider databaseProvider = new UserDatabaseProvider();
        UserManager userManager = new UserManager(databaseProvider);
        System.out.println(userManager.getUserDetails());

        UserDataProvider webServiceDataProvider = new WebServiceDataProvider();
        UserManager userManagerWithWebServices = new UserManager(webServiceDataProvider);
        System.out.println(userManagerWithWebServices.getUserDetails());

    }
}

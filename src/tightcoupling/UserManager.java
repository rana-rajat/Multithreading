package tightcoupling;

public class UserManager {

    UserDatabase userDatabase = new UserDatabase();

    public String getUserDetails(){
        return userDatabase.getUserDetails();
    }
}

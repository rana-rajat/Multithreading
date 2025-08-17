package LooseCoupling;


public class UserManager {
    UserDataProvider userDataProvider;

    public UserManager(UserDataProvider userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    public String getUserDetails(){
       return userDataProvider.getUserDetails();
    }


}

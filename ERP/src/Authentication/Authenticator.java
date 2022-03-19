package Authentication;

public interface Authenticator {

    boolean hasLoggedUser();

    LoginStatus login(String name, String password);

    boolean isAdminLogged();

    boolean registerEmployee(String empName, String empPassword);

    void logout();
}

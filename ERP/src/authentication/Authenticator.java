package authentication;

import java.util.List;

public interface Authenticator {

    boolean hasLoggedAccount();

    LoginStatus login(String name, String password);

    boolean hasLoggedAdmin();

    boolean registerEmployee(String empName, String empPassword);

    void logout();

    List<PublicAccount> getEmployees();

    PublicAccount getLoggedAccount();
}

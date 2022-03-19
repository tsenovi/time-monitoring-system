package Authentication;

public class AuthenticatorImpl implements Authenticator {

    private final UserDatabase userDatabase;
    private Account loggedUser;

    public AuthenticatorImpl() {
        this.userDatabase = new UserDatabase();
        this.loggedUser = null;
    }

    @Override
    public boolean hasLoggedUser() {
        return loggedUser != null;
    }

    @Override
    public LoginStatus login(String name, String password) {
        Account account = userDatabase.getAccount(name);
        if (account != null && account.getAccountPassword().equals(password)){
            loggedUser = account;
            return loggedUser instanceof Admin ? LoginStatus.ADMIN_LOGGED : LoginStatus.EMPLOYEE_LOGGED;
        }
        return LoginStatus.LOGIN_FAILED;
    }

    @Override
    public boolean isAdminLogged() {
        return loggedUser instanceof Admin;
    }

    @Override
    public boolean registerEmployee(String name, String password) {
        if (userDatabase.accountExists(name)){
            return false;
        }

        Employee employee = new Employee(name, password);
        userDatabase.addEmployee(employee);
        return true;
    }

    @Override
    public void logout() {
        loggedUser = null;
    }
}

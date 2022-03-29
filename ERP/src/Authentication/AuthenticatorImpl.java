package Authentication;

public class AuthenticatorImpl implements Authenticator {

    private final AccountDatabase accountDatabase;
    private Account loggedUser;

    public AuthenticatorImpl() {
        this.accountDatabase = new AccountDatabase();
        this.loggedUser = null;
    }

    @Override
    public boolean hasLoggedUser() {
        return loggedUser != null;
    }

    @Override
    public LoginStatus login(String name, String password) {
        Account account = accountDatabase.getAccount(name);
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
        if (accountDatabase.accountExists(name)){
            return false;
        }

        Employee employee = new Employee(name, password);
        accountDatabase.addEmployee(employee);
        return true;
    }

    @Override
    public void logout() {
        loggedUser = null;
    }
}

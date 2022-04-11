package authentication;
import parse.IOcontroller;
import java.util.List;

public class AccountDatabaseImpl implements AccountDatabase {

    private static final String ADMIN_FILE = "admin.db";
    private static final String EMPLOYEES_FILE = "employees.db";

    public AccountDatabaseImpl() {

    }

    @Override
    public void addEmployee(Employee employee){
        List<Employee> employees = IOcontroller.loadFile(EMPLOYEES_FILE);
        employees.add(employee);
        IOcontroller.overwriteFile(EMPLOYEES_FILE, employees);
    }

    @Override
    public boolean accountExists(String userName) {
        return userExistsAsAdmin(userName) || userExistsAsEmployee(userName);
    }

    @Override
    public Account getAccount(String userName) {
        Account account = getAdmin(userName);
        if (account == null) {
            account = getEmployee(userName);
        }
        return account;
    }

    private Account getEmployee(String userName) {
        List<Employee> employees = IOcontroller.loadFile(EMPLOYEES_FILE);
        for (Employee employee : employees) {
            if (employee.getAccountName().equalsIgnoreCase(userName)) {
                return employee;
            }
        }
        return null;
    }

    private Account getAdmin(String userName) {
        Admin admin = IOcontroller.loadFile(ADMIN_FILE);
        if (admin.getAccountName().equalsIgnoreCase(userName)) return admin;
        return null;
    }

    private boolean userExistsAsEmployee(String userName) {
        return getEmployee(userName) != null;
    }

    private boolean userExistsAsAdmin(String userName) {
        return getAdmin(userName) != null;
    }
}

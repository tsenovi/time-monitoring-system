package authentication;

import java.util.ArrayList;
import java.util.List;

public class AccountDatabase {

    private final List<Employee> employees;
    private final Admin admin;

    public AccountDatabase() {
        this.employees = new ArrayList<>();
        this.admin = initDefaultAdmin();
        initDefaultEmployee();
    }

    private void initDefaultEmployee() {
        employees.add(new Employee("Ivan", "1111"));
        employees.add(new Employee("Pavlin", "1111"));
        employees.add(new Employee("Petar", "1111"));
    }

    private Admin initDefaultAdmin() {
        return new Admin("admin","admin");
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    private Admin getAdmin(String name){
        if (admin.getAccountName().equalsIgnoreCase(name)){
            return admin;
        } return null;
    }
    //TODO with stream
    private Employee getEmployee(String name){
        for (Employee e : employees) {
            if (e.getAccountName().equalsIgnoreCase(name)){
                return e;
            }
        }return null;
    }

    private Employee getEmployeeById(long id){
        for (Employee e : employees) {
            if (e.getAccountId() == id){
                return e;
            }
        }return null;
    }

    public Account getAccount(String name){
        Account account = getAdmin(name);
        if (account == null){
            account = getEmployee(name);
        }
        return account;
    }

    public boolean accountExists(String name) {
        return userExistsAsAdmin(name) || userExistsAsEmployee(name);
    }

    private boolean userExistsAsAdmin(String name){
        return getAdmin(name) != null;
    }

    private boolean userExistsAsEmployee(String name){
        return getEmployee(name) != null;
    }
}

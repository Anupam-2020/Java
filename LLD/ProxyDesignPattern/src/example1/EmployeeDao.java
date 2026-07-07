package example1;

public interface EmployeeDao {
    void getEmployeeById(int empID);
    void createEmployee(EmployeeDTO obj);
}

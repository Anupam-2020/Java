package example1;

import java.util.UUID;

public class EmployeeDTO {
    public EmployeeDTO(Long id, String department) {
        this.id = id;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    private Long id;
    private String department;
}

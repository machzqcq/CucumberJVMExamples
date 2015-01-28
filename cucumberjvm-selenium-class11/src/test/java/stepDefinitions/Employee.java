package stepDefinitions;
import java.util.Date;
import java.util.List;

public class Employee
{
    private Integer id;
    private String firstName;
    private String lastName;
    private List<String> roles;

    public Employee(){
    }

    public Employee(Integer id, String firstName, String lastName, Date birthDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public List<String> getRoles()
    {
        return roles;
    }
    public void setRoles(List<String> roles)
    {
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", firstName=" + firstName + ", " +
                "lastName=" + lastName + ", roles=" + roles + "]";
    }
}
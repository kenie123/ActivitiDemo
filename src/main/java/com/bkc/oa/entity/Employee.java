package com.bkc.oa.entity;

public class Employee
{
    private Long id;
    
    private String name;
    
    private String password;
    
    private String email;
    
    private String role;
    
    private Employee manager;
    
    public Long getId()
    {
        return id;
    }
    
    @Override
    public String toString()
    {
        return "Employee [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", role="
            + role + "]";
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name == null ? null : name.trim();
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password == null ? null : password.trim();
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email == null ? null : email.trim();
    }
    
    public String getRole()
    {
        return role;
    }
    
    public void setRole(String role)
    {
        this.role = role == null ? null : role.trim();
    }
    
    public Employee getManager()
    {
        return manager;
    }
    
    public void setManager(Employee manager)
    {
        this.manager = manager;
    }
}
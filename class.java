package jva;

class Employee {
    private String fullName;
    private int age;
    private int salary;
    private static int employeeCount = 0;  // Compteur statique

    public Employee() {
        employeeCount++;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Nom complet : " + fullName);
        System.out.println("Âge : " + age);
        System.out.println("Salaire : " + salary);
        System.out.println("Nombre d'employés : " + employeeCount);
    }
}
class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setFullName("John Dee");
        employee.setAge(30);
        employee.setSalary(50000);

        System.out.println("Nom complet : " + employee.getFullName());
        System.out.println("Âge : " + employee.getAge());
        System.out.println("Salaire : " + employee.getSalary());
        System.out.println("\nAffichage des informations de l'employé :");
        employee.displayInfo();
    }
}
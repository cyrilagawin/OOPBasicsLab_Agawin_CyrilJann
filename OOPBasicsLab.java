import java.util.Scanner;

public class OOPBasicsLab {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== ACTIVITY 1 & 2: STUDENT =====
        System.out.println("=== ACTIVITY 1 & 2: STUDENT CLASS ===");

        Student s1 = createStudent(scanner);
        Student s2 = createStudent(scanner);

        s1.displayInfo();
        s2.displayInfo();

        // ===== ACTIVITY 3: VEHICLE =====
        System.out.println("\n=== ACTIVITY 3: VEHICLE CLASS ===");

        Vehicle car = new Vehicle("Toyota", "Vios", 60);
        Vehicle motorcycle = new Vehicle("Honda", "Click", 40);

        car.displayStatus();
        car.accelerate(20);
        car.displayStatus();

        motorcycle.displayStatus();
        motorcycle.accelerate(15);
        motorcycle.displayStatus();

        // ===== ACTIVITY 4: BANK ACCOUNT =====
        System.out.println("\n=== ACTIVITY 4: BANK ACCOUNT ===");

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        BankAccount account = new BankAccount(name, 0);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = getInt(scanner);

            switch (choice) {
                case 1 -> {
                    double amount = getPositiveDouble(scanner, "Enter deposit amount: ");
                    account.deposit(amount);
                }
                case 2 -> {
                    double amount = getPositiveDouble(scanner, "Enter withdrawal amount: ");
                    account.withdraw(amount);
                }
                case 3 -> account.displayBalance();
                case 4 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }

        // ===== ACTIVITY 5: CIRCLE =====
        System.out.println("\n=== ACTIVITY 5: CIRCLE GEOMETRY ===");

        Circle c1 = new Circle(5);
        Circle c2 = new Circle(10);

        c1.displayDetails();
        c2.displayDetails();

        scanner.close();
    }

    /* ================= INPUT HELPERS ================= */
    static int getInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Invalid input. Enter a number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    static double getDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
            System.out.print("Invalid input. Enter a number: ");
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    static double getPositiveDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = getDouble(scanner);
            if (value > 0) return value;
            System.out.println("Value must be positive.");
        }
    }

    static Student createStudent(Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = getInt(scanner);

        System.out.print("Enter Grade: ");
        double grade = getDouble(scanner);

        return new Student(name, age, grade);
    }
}

/* ================= STUDENT CLASS ================= */
class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void displayInfo() {
        System.out.println("\nStudent Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

/* ================= VEHICLE CLASS ================= */
class Vehicle {
    private String brand;
    private String model;
    private double speed;

    public Vehicle(String brand, String model, double speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public void accelerate(double increment) {
        speed += increment;
    }

    public void displayStatus() {
        System.out.println("\nVehicle Status:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed + " km/h");
    }
}

/* ================= BANK ACCOUNT CLASS ================= */
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

/* ================= CIRCLE CLASS ================= */
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public void displayDetails() {
        System.out.println("\nCircle Details:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
}

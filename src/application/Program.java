package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Adress;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String depName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Adress adress = new Adress(email, phone);
		Department department = new Department(depName, payDay, adress);
		
		System.out.print("Quatos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		Employee employee;
		
		for (int i = 0; i < n; i++) {
			System.out.println("Dados do funcionário " + (i+1) +":");
			System.out.print("Nome: ");	
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();
			employee = new Employee(name, salary);
			department.addEmployee(employee); 
		}

		showReport(department);
		
		sc.close();
	}
	
	public static void showReport(Department dept) {
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO: ");
		System.out.println("Departamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()));
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionários: ");
		for (Employee emp : dept.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAdress().getEmail());
	}

}

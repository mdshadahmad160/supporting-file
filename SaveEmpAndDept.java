package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;
import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class SaveEmpAndDept {
	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		Department d=new Department();
		d.setName("Product Support");
		d.setLocation("New Delhi");
		
		
		Employee e1=new Employee();
		e1.setDept(d);
		e1.setName("Rahul");
		e1.setDesg("Anylyst");
		e1.setSalary(30000);
		
		
		Employee e2=new Employee();
		e2.setDept(d);
		e2.setName("Ronit");
		e2.setDesg("Data Anylst");
		e2.setSalary(560000);
		
		
		Employee e3=new Employee();
		e3.setDept(d);
		e3.setName("Shivam");
		e3.setDesg("Data Science");
		e3.setSalary(100000);
		//Assign The Employee In Department:
		d.setEmps(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		System.out.println("Your Data Will Be Saved Successfully: ");
		
	}

}

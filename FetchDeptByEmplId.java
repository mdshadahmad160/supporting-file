package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;
import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class FetchDeptByEmplId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Emp ID To Display Dept Details: ");
		int eid=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Employee e=manager.find(Employee.class, eid);
		if(e!=null) {
			    Department d=e.getDept();
			    System.out.println("ID: "+d.getId());
			    System.out.println("Name: "+d.getName());
			    System.out.println("Loc: "+d.getLocation());
		}else {
			System.out.println("Invalid ID: ");
		}
	
		
	}

}

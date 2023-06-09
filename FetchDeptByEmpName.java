package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;
import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class FetchDeptByEmpName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Name To Display Details Of Department: ");
		String name=sc.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query="select e.dept from Employee e where e.name=?1";
		Query q=manager.createQuery(query);
		q.setParameter(1, name);
		
		List<Department> dept=q.getResultList();
		for(Department d1: dept) {
			System.out.println(d1);
			System.out.println("ID: "+d1.getId());
			System.out.println("Name: "+d1.getName());
			System.out.println("Loc: "+d1.getLocation());
		
		}
	}

}

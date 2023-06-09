package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class FetchEmpByName {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Emp Name To Display The Details of Employee Only: ");
	String name=sc.next();
	String query="select e from Employee e where e.name=?1";
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	Query q=manager.createQuery(query);
	q.setParameter(1, name);
	try {
		Employee e=(Employee) q.getSingleResult();
		System.out.println(e);
	}catch(NoResultException e) {
		System.out.println("Invalid Name:");
	}
}
}

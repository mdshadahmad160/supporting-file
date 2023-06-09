package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class FetchEmplsByDeptName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Dept Name To Display the Empls Details : ");
		String name=sc.next();
		String query="select dept.emps from Employee e where e.dept.name=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(query);
		q.setParameter(1, name);
		List<Employee> emps=q.getResultList();
		if(emps.size()>0) {
			for(Employee e: emps) {
				System.out.println(e);
			}
		}else {
			System.out.println("Invalid Dept Name: ");
		}
		
	}

}

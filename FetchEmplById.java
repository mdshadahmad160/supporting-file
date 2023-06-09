package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class FetchEmplById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Id To Display Employee Details: ");
		int id=sc.nextInt();
		String query="select e from Employee e where e.id=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(query);
		q.setParameter(1, id);
		try {
			Employee e=(Employee) q.getSingleResult();
			System.out.println(e);
		}catch(NoResultException e) {
			System.out.println("invalid Emp Id:");
		}
		
	}

}

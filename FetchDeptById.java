package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;

public class FetchDeptById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter The Id To Fetch The Deapartment Details: ");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query="select d from Department d where d.id=?1";
		Query q=manager.createQuery(query);
		q.setParameter(1, id);
		try {
			Department d= (Department) q.getSingleResult();
			System.out.println("Name: "+d.getName());
			System.out.println("Location: "+d.getLocation());
		}catch(NoResultException e) {
			System.out.println("Invalid ID: ");
		}
	}

}

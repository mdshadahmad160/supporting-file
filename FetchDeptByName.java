package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;

public class FetchDeptByName {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name To Fetch Department Details: ");
		String name=sc.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query="select d from Department d where d.name=?1";
		Query q=manager.createQuery(query);
		q.setParameter(1, name);
		try {
			Department d= (Department) q.getSingleResult();
			System.out.println("ID: "+d.getId());
			System.out.println("Location: "+d.getLocation());
		}catch(NoResultException e) {
			System.out.println("Invalid Name: ");
		}
			
		
		}
	}



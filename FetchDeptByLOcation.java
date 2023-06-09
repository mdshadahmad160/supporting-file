package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;

public class FetchDeptByLOcation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Loacation To Fetch Department Details: ");
		String location=sc.next();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String query="select d from Department d where d.location=?1";
		Query q=manager.createQuery(query);
		q.setParameter(1, location);
		try {
            Department d=(Department) q.getSingleResult();
            System.out.println("ID: "+d.getId());
            System.out.println("Dept Name: "+d.getName());
		}catch(NoResultException e) {
			System.out.println("Invalid Loc: ");
		}
	}

}

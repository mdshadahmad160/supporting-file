package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Department;

public class FetchDeptByEmpDesg {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee Desg To Display Department Details: ");
		String desg=sc.next();
		String query="select e.dept from Employee e where e.desg=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(query);
		q.setParameter(1, desg);
		List<Department> dept=q.getResultList();
		
			for(Department d: dept) {
				System.out.println(d);
			}
		}
		
	}





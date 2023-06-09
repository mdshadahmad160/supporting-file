package org.jsp.One2ManyOrMany2OneBy.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.One2ManyOrMany2OneBy.dto.Employee;

public class FetchEmplsByDeptId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Dept Id To Display The Employee Details: ");
		int did=sc.nextInt();
		String query="select dept.emps from Employee  e where e.dept.id=?1";
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=manager.createQuery(query);
		q.setParameter(1,did);
		List<Employee> emps=q.getResultList();
		if(emps.size()>0) {
			for(Employee e:emps) {
				System.out.println(e);
			}
		}else {
			System.out.println("Invalid Dept ID: ");
		}
	}

}

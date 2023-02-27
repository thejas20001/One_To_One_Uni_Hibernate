package onetoone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import onetoone.dto.Aadharcard;
import onetoone.dto.Person;

public class PersonCrud {
	
	public EntityManager getEntityManager() {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		return entityManager;
		
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
			
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Aadharcard aadharcard = person.getAdharcard();
		
		entityTransaction.begin();
		entityManager.persist(aadharcard);
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Aadharcard aadharcard = person.getAdharcard();
		
		entityTransaction.begin();
		entityManager.merge(aadharcard);
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public void getPerson(int id) {
		EntityManager entityManager = getEntityManager();
		Person person = entityManager.find(Person.class,id);
		System.out.print(person);
		
	}
	
	public void getAllPerson() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		List<Person> persons= query.getResultList();
		System.out.println(persons);
	}
	
//	public void deleteAadhar(int id) {
//		EntityManager entityManager = getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		Aadharcard aadharcard = entityManager.find(Aadharcard.class,id );
//		entityTransaction.begin();
//		entityManager.remove(aadharcard);
//		entityTransaction.commit();
//	}
	
	public void deletePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		entityTransaction.begin();
		entityManager.remove(person);
		entityTransaction.commit();
		
	}
	
	
}

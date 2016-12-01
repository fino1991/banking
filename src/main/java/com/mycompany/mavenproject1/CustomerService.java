package com.mycompany.mavenproject1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CustomerService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Customer");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public List<Customer> retrieveCustomers() {
        return allEntries();
    }

    public List<Customer> allEntries() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public Customer retrieveCustomer(int id) {
        Customer test = em.find(Customer.class, id);//entityManager specify class to get 
        em.close(); // close entity manager  
        return test; // return test (object that was found in this case book)
    }

    public Customer createCustomer(Customer b) {
        Customer test = em.find(Customer.class, b.getId()); //entityManager specify class to get/use
        if (test == null) {
            tx.begin(); // begin transaction
            em.persist(b); // persist this object
            tx.commit(); // commit to DB

            em.close(); // close
        }
        return b;
    }

    public void deleteCustomer(int id) {
        Customer test = em.find(Customer.class, id);
        if (test != null) {
            tx.begin();
            em.remove(test);
            tx.commit();

            em.close();
        }
    }
}

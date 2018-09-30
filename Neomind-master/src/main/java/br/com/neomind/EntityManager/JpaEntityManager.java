package br.com.neomind.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {
    private EntityManagerFactory factory;
    private EntityManager em;

    {
    	factory = Persistence.createEntityManagerFactory("crud");
    	em = factory.createEntityManager();
    }
    
 public EntityManager getEntityManager(){
    return em;
  }
 
}

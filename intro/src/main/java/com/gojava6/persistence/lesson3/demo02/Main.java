package com.gojava6.persistence.lesson3.demo02;

import com.gojava6.persistence.lesson3.CD;
import com.gojava6.persistence.lesson3.Musician;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("module01-persistence-unit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    CDService service = new CDService(em);

    // Creates and persists a CD
    /*tx.begin();
    Set<Musician> beatles = new HashSet<>();
    Musician john = new Musician("John", "Lennon");
    Musician paul = new Musician("Paul", "McCartney");
    Musician ringo = new Musician("Ringo", "Starr");
    Musician georges = new Musician("Georges", "Harrison");
    em.persist(john);
    em.persist(paul);
    em.persist(ringo);
    em.persist(georges);
    beatles.add(john);

    beatles.add(paul);

    beatles.add(ringo);

    beatles.add(georges);
*/

    tx.begin();
    CD sergentPepper = new CD();
    sergentPepper.setTitle("Cache");
    /*sergentPepper.setMusicians(beatles);*/
    sergentPepper = service.createCD(sergentPepper);
    em.persist(sergentPepper);
    tx.commit();

    //System.out.println("CD Persisted : " + sergentPepper);
    em.close();
    /*Query query = em.createNativeQuery("select * from CD where id =  ?");
    query.setParameter(1, "1").getSingleResult();

    query.setParameter(1, "1").getSingleResult();*//*
*/

    // Finds the cd

    em = emf.createEntityManager();
    tx = em.getTransaction();
    tx.begin();
    sergentPepper = em.find(CD.class, 1L);
    /*sergentPepper = service.findCD(sergentPepper.getId());*/
    tx.commit();


    if (em.getEntityManagerFactory().getCache().contains(CD.class, 1L)) {
      System.out.println("exist!");
    }

    em.close();
    em = emf.createEntityManager();
    tx = em.getTransaction();
    tx.begin();
    /*service = new CDService(em);*/
    sergentPepper = em.find(CD.class, 1L);
    tx.commit();
    em.close();



    /*System.out.println("CD Found     : " + sergentPepper);
    System.out.println("   Musicians : " + sergentPepper.getMusicians());*/

    // Removes the cd
    /*tx.begin();
    service.removeCD(sergentPepper.getId());
    tx.commit();

    System.out.println("CD Removed");

    // Finds the cd
    sergentPepper = service.findCD(sergentPepper.getId());

    System.out.println("CD Not Found : " + sergentPepper);

    em.close();*/
    emf.close();
  }
}



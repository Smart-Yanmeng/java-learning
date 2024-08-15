package com.york;

import com.york.pojo.StudentPO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {

    private SessionFactory sessionFactory;

    @Before
    public void init() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Test
    public void testC() {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            StudentPO student = StudentPO.builder()
                    .studentName("York")
                    .studentNumber(123456L)
                    .build();

            session.persist(student);
            transaction.commit();
        }
    }

    @Test
    public void testU() {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            StudentPO student = StudentPO.builder()
                    .studentName("York")
                    .studentNumber(123456L)
                    .build();

            session.persist(student);

            transaction.commit();
        }
    }

    @Test
    public void testR() {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            StudentPO student = session.find(StudentPO.class, 1L);
            System.out.println(student);

            transaction.commit();
        }
    }

    @Test
    public void testD() {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            StudentPO student = StudentPO.builder()
                    .studentId(1L)
                    .build();

            session.remove(student);

            transaction.commit();
        }
    }

    @Test
    public void testCJQL() {

        EntityManager entityManager = sessionFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        StudentPO student = StudentPO.builder()
                .studentName("York")
                .studentNumber(123456L)
                .build();

        entityManager.merge(student);

        transaction.commit();
    }
}

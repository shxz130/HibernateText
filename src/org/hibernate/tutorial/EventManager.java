package org.hibernate.tutorial;

import org.hibernate.Session;

import java.util.*;

import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

         {
            mgr.createAndStoreEvent("first Event", new Date());
            mgr.createAndStoreEvent("second Event", new Date());
        }
        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event firstEvent = new Event();
        firstEvent.setTitle(title);
        firstEvent.setDate(theDate);
        session.save(firstEvent);

  


        session.getTransaction().commit();

    }

}
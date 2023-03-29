package homework2.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new  StandardServiceRegistryBuilder()
                .configure("config/hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        String hql = "FROM PurchaseList";
        List<PurchaseList> purchaseList = session.createQuery(hql).getResultList();

        for (PurchaseList list : purchaseList){
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            Query query = session.createQuery("FROM Student WHERE name =:s");
            List<Student> student = query.setParameter("s", list.getId().getStudentName()).getResultList();
            query = session.createQuery("FROM Course WHERE name =:c");
            List<Course> course = query.setParameter("c", list.getId().getCourseName()).getResultList();

            linkedPurchaseList.setId(
                    student.get(0).getId(), course.get(0).getId()
            );

            session.save(linkedPurchaseList);
        }

//        String hql1 = "FROM LinkedPurchaseList";
//        List<LinkedPurchaseList> linkedPurchase = session.createQuery(hql1).getResultList();
//        System.out.println("course_id  /  student_id");
//        for (LinkedPurchaseList list : linkedPurchase) System.out.println(
//               "\t" + list.getId().getCourseId() + "\t  |\t\t" + list.getId().getStudentId());

        transaction.commit();
        sessionFactory.close();

    }
}

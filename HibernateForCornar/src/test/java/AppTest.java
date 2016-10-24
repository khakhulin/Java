import com.netcracker.hibernateForCornar.dao.UsersEntity;
import com.netcracker.hibernateForCornar.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Taras on 24.10.2016.
 * This is  simple testing of Hibernate
 */
public class AppTest {
    @Test
    public void testSetUser(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        UsersEntity user = new UsersEntity();

        long id = 123;
        user.setUserId(id);
        user.setUserName("tester");
        user.setPassword("s");
        session.delete(user);
        user = session.load(UsersEntity.class, id);
        Assert.assertEquals(id, user.getUserId());
        user = new UsersEntity();
        user.setUserId(id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}

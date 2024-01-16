package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CarDaoImp implements CarDao {

    private final SessionFactory sessionFactory;

    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCar(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }
    @Override
    public List<Car> getCars() {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("from Car", Car.class);
        return query.getResultList();
    }
    @Override
    public List<User> getUser(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User user where user.car.model=:model and user.car.series=:series", User.class);
        query.setParameter("model", model);
        query.setParameter("series", series);
        return query.getResultList();
    }

}

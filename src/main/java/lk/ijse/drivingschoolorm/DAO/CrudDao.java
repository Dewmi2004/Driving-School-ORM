package lk.ijse.drivingschoolorm.DAO;

import lk.ijse.drivingschoolorm.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDao<T  extends SuperEntity,ID extends Serializable> extends SuperDao{
    void save(T t, Session session);

    void update(T t, Session session);

    void deleteByPk(ID pk, Session session);

    List<T> findAll(Session session);

    Optional<T> findByPk(ID pk, Session session);

    Optional<String> getLastPk(Session session);

}

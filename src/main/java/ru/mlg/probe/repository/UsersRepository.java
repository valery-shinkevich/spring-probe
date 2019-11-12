package ru.mlg.probe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mlg.probe.entity.User;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);

    @Query("select u from User u where u.email like '%@gmail.com%'")
    List<User> findWhereEmailIsGmail();

    @Query(value = "select * from users where name like '%smith%'", nativeQuery = true)
    List<User> findWhereNameStartsFromSmith();
}

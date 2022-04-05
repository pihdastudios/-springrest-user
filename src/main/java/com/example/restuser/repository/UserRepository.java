package com.example.restuser.repository;

import com.example.restuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findAllByOrderByIdAsc();
}

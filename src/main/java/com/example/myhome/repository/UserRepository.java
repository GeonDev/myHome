package com.example.myhome.repository;

import com.example.myhome.model.Board;
import com.example.myhome.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    // model 클래스에 있는 설정을 무시하고 JPA 호출을 할때 JOIN하여 값을 불러온다
    // 이렇게 값을 설정하지 않으면 값을 불러올때 쿼리를 여러번 날리게 되어 성능상 이슈가 발생하기도 한다.
    @EntityGraph(attributePaths = {"boards"})
    public List<User> findAll();
}

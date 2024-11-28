package kyungseo.poc.todo.jsp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // 추가
import kyungseo.poc.todo.jsp.persistence.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 사용자 이름으로 Todo 항목 삭제
    long deleteByUserName(String username);

    // 사용자 이름으로 Todo 항목 검색
    List<Todo> findByUserName(String username);
}

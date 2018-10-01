package bd.ac.seu.backendtravelmanagement.Repository;

import bd.ac.seu.backendtravelmanagement.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}

package CatchKorea.backend.repositroy;

import CatchKorea.backend.dto.PostDto;
import CatchKorea.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Category c JOIN c.postList p WHERE c.id= :categoryId")
    List<Post> findPostByCategoryId(@Param("categoryId") Long categoryId);

    List<Post> findPostsByTitle(String title);
    @Query("SELECT p FROM Post p WHERE :searchHashTag MEMBER OF p.hashtag")
    List<Post> findPostByHashtag(String searchHashTag);
}

package com.codeup.springblog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByTitle(String title);
    Post findById(String id);
    // The following method shows you how to use named params in a HQL custom query:
    @Query("from Post a where a.title like %:term%")
    List<Post> searchByTitleLike(@Param("term") String term);

    @Query("from Post a where a.id like %:term%")
    List<Post> searchById(@Param("term") String term);

}

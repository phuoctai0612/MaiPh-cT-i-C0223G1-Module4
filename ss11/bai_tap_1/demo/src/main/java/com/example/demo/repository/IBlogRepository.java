package com.example.demo.repository;


import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blogs  where title like concat('%',:name,'%') and category_id like concat('%',:category,'%') and id_flag_delete = 'false' ", nativeQuery = true)
    Page<Blog> searchBlog(@Param("name") String name,@Param("category") String category,Pageable pageable);
    List<Blog> findBlogByIdFlagDeleteIsFalse();

}

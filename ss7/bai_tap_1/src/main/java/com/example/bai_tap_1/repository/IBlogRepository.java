package com.example.bai_tap_1.repository;

import com.example.bai_tap_1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer>{
@Query(value = "select * from blogs where title like concat('%' ,:name,'%')",nativeQuery = true)
    List<Blog> searchBlog(@Param("name") String name);
}

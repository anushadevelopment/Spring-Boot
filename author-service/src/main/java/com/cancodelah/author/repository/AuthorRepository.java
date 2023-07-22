package com.cancodelah.author.repository;

import com.cancodelah.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByAuthorId(Long authorId);
    List<Author> findByAuthorFirstName(String authorFirstName);

    /*@Query("select * from Author u where (:authorFirstName is null or u.authorFirstName = :name)"
           +" or (:authorLastName is null or u.authorLastName = :name)")*/
    @Query("select a from Author a where (a.authorFirstName = :name)"
            +" or (a.authorLastName = :name)")

   /* @Query(value="select mt from MY_TABLE mt where mt.field1 = %searchtext% or mt.field2 = %searchtext% or mt.field3 = %searchtext%")
    Page<Item> findByAllColumns(@Param("searchtext") String searchtext, Pageable pageable);*/

    List<Author> findByAuthorFirstNameOrLastName(String name);

    }



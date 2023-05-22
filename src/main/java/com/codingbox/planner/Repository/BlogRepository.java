package com.codingbox.planner.repository;

import com.codingbox.planner.domain.Blog;
import com.codingbox.planner.domain.DTO.BlogDTO;
import com.codingbox.planner.domain.Members;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BlogRepository {

    private final EntityManager em;

    public Blog save(Blog blog) {
        em.persist(blog);
        return blog;
    }

    public Blog findByBlogId(Long blogId) {
        return em.find(Blog.class, blogId);
    }

    public List<Blog> findAll() {
        return em.createQuery("select b from Blog b", Blog.class)
                 .getResultList();
    }

    public void deleteById(Long blogId) {
        em.createQuery("DELETE FROM Blog b WHERE b.blogId = :blogId")
                .setParameter("blogId", blogId)
                .executeUpdate();
    }

    public Page<Blog> findAllPages(Pageable pageable) {

        String countQuery = "SELECT COUNT(b) FROM Blog b";
        String selectQuery = "SELECT b FROM Blog b";
        TypedQuery<Long> countTypedQuery = em.createQuery(countQuery, Long.class);
        TypedQuery<Blog> selectTypedQuery = em.createQuery(selectQuery, Blog.class);

        Long total = countTypedQuery.getSingleResult();
        selectTypedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        selectTypedQuery.setMaxResults(pageable.getPageSize());
        List<Blog> content = selectTypedQuery.getResultList();

        return new PageImpl<>(content, pageable, total);

    }

    public Blog findById(Long blogId) {
        return em.find(Blog.class, blogId);
    }
}

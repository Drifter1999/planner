package com.codingbox.planner.service;

import com.codingbox.planner.domain.Blog;
import com.codingbox.planner.domain.DTO.BlogDTO;
import com.codingbox.planner.domain.Members;
import com.codingbox.planner.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class BlogService {

    private final BlogRepository blogRepository;

    // 게시글 등록
    @Transactional
    public BlogDTO insertBlog(BlogDTO blogDTO) {



        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setDate(LocalDateTime.now());
        blog.setImgpath(blogDTO.getImgpath());


        Blog savedBlog = blogRepository.save(blog);

        BlogDTO savedBlogDTO = new BlogDTO();
        savedBlogDTO.setBlogId(savedBlog.getBlogId());
        savedBlogDTO.setTitle(savedBlog.getTitle());
        savedBlogDTO.setContent(savedBlog.getContent());
        savedBlogDTO.setDate(savedBlogDTO.getDate());
        savedBlogDTO.setImgpath(savedBlogDTO.getImgpath());

        return savedBlogDTO;
    }

    // 게시글 조회
    public Blog getBlogId(Long blogId) {
        return blogRepository.findByBlogId(blogId);
    }

    // 게시글 리스트 보기
    public List<Blog> findBlogs() {
        return blogRepository.findAll();
    }

    @Transactional
    public void updateBlog(Long blogId, BlogDTO dto) {

        Blog blog = blogRepository.findByBlogId(blogId);

        blog.setTitle(dto.getTitle());
        blog.setContent(dto.getContent());
        blog.setDate(LocalDateTime.now());
        blog.setImgpath(dto.getImgpath());

    }
    @Transactional
    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }


    public Page<Blog> findPages(Pageable pageable) {
        return blogRepository.findAllPages(pageable);
    }
}

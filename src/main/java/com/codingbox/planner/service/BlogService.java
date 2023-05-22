package com.codingbox.planner.service;

import com.codingbox.planner.domain.Blog;
import com.codingbox.planner.domain.DTO.BlogDTO;
import com.codingbox.planner.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly=true)
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public void insertBlog(Blog blog , MultipartFile file) throws Exception{
        /*우리의 프로젝트경로를 담아주게 된다 - 저장할 경로를 지정*/
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        /*식별자 . 랜덤으로 이름 만들어줌*/
        UUID uuid = UUID.randomUUID();

        /*랜덤식별자_원래파일이름 = 저장될 파일이름 지정*/
        String fileName = uuid + "_" + file.getOriginalFilename();

        /*빈 껍데기 생성*/
        /*File을 생성할건데, 이름은 "name" 으로할거고, projectPath 라는 경로에 담긴다는 뜻*/
        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        /*디비에 파일 넣기*/
        blog.setImgname(fileName);
        /*저장되는 경로*/
        blog.setImgpath("/files/" + fileName); /*저장된파일의이름,저장된파일의경로*/
        blog.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        blog.setTime(LocalDateTime.now());
        /*파일 저장*/
        blogRepository.save(blog);
    }
    // 게시글 등록
//    @Transactional
//    public BlogDTO insertBlog(BlogDTO blogDTO) {
//
//
//
//        Blog blog = new Blog();
//        blog.setTitle(blogDTO.getTitle());
//        blog.setContent(blogDTO.getContent());
//        blog.setDate(LocalDateTime.now());
//        blog.setImgpath(blogDTO.getImgpath());
//
//
//        Blog savedBlog = blogRepository.save(blog);
//
//        BlogDTO savedBlogDTO = new BlogDTO();
//        savedBlogDTO.setBlogId(savedBlog.getBlogId());
//        savedBlogDTO.setTitle(savedBlog.getTitle());
//        savedBlogDTO.setContent(savedBlog.getContent());
//        savedBlogDTO.setDate(savedBlogDTO.getDate());
//        savedBlogDTO.setImgpath(savedBlogDTO.getImgpath());
//
//        return savedBlogDTO;
//    }

    // 게시글 조회
    public Blog getBlogId(Long blogId) {
        return blogRepository.findByBlogId(blogId);
    }

    // 게시글 리스트 보기
    public List<Blog> findBlogs() {
        return blogRepository.findAll();
    }

    @Transactional
    public Blog updateBlog(Long blogId, Blog blog) {

        Blog blogDTO = blogRepository.findByBlogId(blogId);

        blogDTO.setTitle(blog.getTitle());
        blogDTO.setContent(blog.getContent());
        blogDTO.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        blogDTO.setTime(LocalDateTime.now());

        return blogDTO;

    }
    @Transactional
    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);
    }


    public Page<Blog> findPages(Pageable pageable) {
        return blogRepository.findAllPages(pageable);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";
        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);
        return "/files/" + fileName;
    }

    @Transactional
    public Blog updatesBlog(Long blogId, Blog blogDTO, MultipartFile file) throws IOException {
        // 블로그 업데이트를 위해 먼저 데이터베이스에서 해당 블로그를 조회합니다.
        Blog existingBlog = blogRepository.findById(blogId);

        // 블로그 정보 업데이트
        existingBlog.setTitle(blogDTO.getTitle());
        existingBlog.setContent(blogDTO.getContent());
        existingBlog.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        existingBlog.setTime(LocalDateTime.now());
        // 파일 업로드 처리 (예시)
        if (file != null && !file.isEmpty()) {
            // 파일을 저장하고 파일 경로를 블로그 엔티티에 설정합니다.
            String filePath = saveFile(file);
            existingBlog.setImgpath(filePath);
        }

        // 업데이트된 블로그를 저장합니다.
        return existingBlog;
    }


}

package com.codingbox.planner.controller;

import com.codingbox.planner.config.UploadFileUtil;
import com.codingbox.planner.domain.Blog;
import com.codingbox.planner.domain.DTO.BlogDTO;
import com.codingbox.planner.service.BlogService;
import com.codingbox.planner.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/blog")
@RequiredArgsConstructor
public class BlogController {

    @Autowired
    private final BlogService blogService;

    @Autowired
    private final UploadFileUtil fileUtil;

    @Autowired
    private final ImageService imageService;

    @Autowired
    private HttpServletRequest request;

    // 후기게시글 상세
    @GetMapping("/detailblog/{blogId}")
    public String detailblog(Model model, @PathVariable("blogId") Long blogId) {

        Blog blog= blogService.getBlogId(blogId);

        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogId(blogId);
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setContent(blog.getContent());
        blogDTO.setImgpath(blog.getImgpath());
        blogDTO.setDate(blog.getDate());


/*        if (content != null) {
            blogDTO.setContent(content.replace("temp", "" + blogDTO.getBlogId()));
        }*/

        model.addAttribute("blog", blog );
        return "blog/detailblog";
    }

    @GetMapping("/writeblog")
    public String writeBlogForm(Model model) {

        model.addAttribute("blogDTO", new BlogDTO());

        return "blog/writeblog";
    }
    
    // 이미지 등록
//    @ResponseBody
//    @PostMapping("/writeblog/image")
//    public ResponseEntity<?> imageUpload(@RequestParam("file") MultipartFile file) {
//        try {
//            String filePath = imageService.store(file);
//            return ResponseEntity.ok().body(filePath);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().build();
//        }
//    }

    //후기 게시글 등록
    // return "redirect:/blog/detailblog/{blogId}"
//    @PostMapping("/writeblog")
//    public String insertBlog(@RequestParam(required = false) String[] imgpath, BlogDTO blogDTO, RedirectAttributes redirectAttributes) {
//
//        // 이미지 blogDTO에 String으로 바뀐 이미지 Path 전달
//        if (imgpath != null) {
//            //String배열 문자열 치환 후 문자열로 변경
//            String uploadImg = Arrays.stream(imgpath).map(s -> s = s.split("temp")[1].substring(1)).collect(Collectors.joining(","));
//            blogDTO.setImgpath(uploadImg);
//        }
//
//        // blog에 insert
//        BlogDTO blog = blogService.insertBlog(blogDTO);
//
//        //imgpath가 null이 아닌 경우, fileUtil.moveImages() 메소드를 호출하여 블로그에 첨부된 이미지를 이동
//        if (blog.getImgpath() != null) {
//            fileUtil.moveImages(blog.getBlogId(), blog.getImgpath());
//        }
//
//        redirectAttributes.addAttribute("blogId", blog.getBlogId());
//
//        return "redirect:/blog/detailblog/{blogId}";
//    }

    @PostMapping("/writeblog")
    public String boardWritePro(Blog blog, Model model, MultipartFile file,  RedirectAttributes redirectAttribute) throws Exception{


        blogService.insertBlog(blog, file);

        redirectAttribute.addAttribute("blogId", blog.getBlogId());

        return "redirect:/blog/detailblog/{blogId}";
    }

    // 게시글 리스트 보기
 /*   @GetMapping("/selectblog")
    public String list(Model model){
        List<Blog> blogs = blogService.findBlogs();
        model.addAttribute("blogs", blogs);
        return "blog/selectblog";
    }*/
    @GetMapping("/selectblog")
    public String list(@PageableDefault(size = 4) Pageable pageable, Model model) {
        Page<Blog> blogPage = blogService.findPages(pageable);
        List<Blog> blogs = blogPage.getContent();
        int totalPages = blogPage.getTotalPages();

        model.addAttribute("blogs", blogs);
        model.addAttribute("totalPages", totalPages);
        return "blog/selectblog";
    }


    // 게시글 수정하기
    @GetMapping("/detailblog/{blogId}/edit")
    public String updateBlogForm(@PathVariable("blogId")Long blogId, Model model){

        Blog blog = blogService.getBlogId(blogId);

        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setContent(blog.getContent());
        blogDTO.setDate(blog.getDate());
        blogDTO.setImgpath(blog.getImgpath());

        model.addAttribute("blog",blog);

        return "blog/editblog";
    }

/*    @ResponseBody
    @PostMapping("/editblog/image")
    public ResponseEntity<?> imageReload(@RequestParam("file") MultipartFile file) {
        try {
            String filePath = imageService.store(file);
            return ResponseEntity.ok().body(filePath);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }*/

/*    @PostMapping ( "/detailblog/{blogId}/edit")
    public String updateBlog(@PathVariable("blogId") Long blogId,
                               BlogDTO dto,
                               @RequestParam(required = false) String[] imgpath) {

        if (imgpath != null) {
            //String배열 문자열 치환 후 문자열로 변경
            dto.setImgpath(dto.getImgpath() + "," + Arrays.stream(imgpath).map(s -> s = s.split("temp")[1].substring(1)).collect(Collectors.joining(",")));
        }

        blogService.updateBlog(blogId, dto);
        fileUtil.moveImages(blogId, dto.getImgpath());

        return "redirect:/blog/detailblog/{blogId}";
    }*/

    @PostMapping ( "/detailblog/{blogId}/edit")
    public String updateBlog(@ModelAttribute("blog")Blog blogDTO,
                             MultipartFile file)throws Exception {

        Blog blog = new Blog();

        blog.setBlogId(blogDTO.getBlogId());
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());

        if (file != null && !file.isEmpty()) {
            blogService.updatesBlog(blogDTO.getBlogId(), blogDTO, file);
        } else {
            blogService.updateBlog(blogDTO.getBlogId(), blogDTO);
        }


        return "redirect:/blog/detailblog/{blogId}";
    }

    // 게시글 삭제하기
    @PostMapping("/detailblog/{blogId}/deleteblog")
    public String deleteBlog(@PathVariable("blogId") Long blogId){
        blogService.deleteBlog(blogId);
        fileUtil.deleteImages(blogId);
        return "redirect:/blog/selectblog";
    }


}
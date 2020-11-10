package com.lala.blog.web;

import com.lala.blog.NotFoundException;
import com.lala.blog.service.BlogService;
import com.lala.blog.service.TagService;
import com.lala.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class controller {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/")
    public String index(@PageableDefault(size =8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
        //int i=1/0;//测试异常
//        String blog=null;
//        if (blog==null){
//            throw new NotFoundException("博客不存在！");
//        }
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
        System.out.println("---------index()---------");
        return "index";
    }

    @PostMapping("/search")
    public String search(@PageableDefault(size=8,sort = {"updateTime"},direction=Sort.Direction.DESC)Pageable pageable,
                         @RequestParam String query, Model model){
        model.addAttribute("page",blogService.listBlog("%"+query+"%",pageable));
        model.addAttribute("query",query);
        return "search";
    }

    @RequestMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
    model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}

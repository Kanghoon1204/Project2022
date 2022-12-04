package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {

    @Autowired
    @RequestMapping("/")
    public  String home()
    {
        return "posts";
    }

    @RequestMapping("addpostform")
    public  String addpostForm()
    {

        return "addpostform";
    }

    @RequestMapping("addpost")
    public  String addpost()
    {

        return "addpost";
    }

    @RequestMapping("posts")
    public  String posts()
    {

        return "posts";
    }

    @RequestMapping("deletepost")
    public  String deleteposts()
    {

        return "deletepost";
    }

    @RequestMapping("view")
    public  String view()
    {

        return "view";
    }

    @RequestMapping("editpost")
    public  String editpost()
    {

        return "editpost";
    }
    @Autowired    @RequestMapping("editform")
    public  String editform()
    {

        return "editform";
    }

    @RequestMapping("addMessagepost")
    public  String addMessagepost()
    {

        return "addMessagepost";
    }

}

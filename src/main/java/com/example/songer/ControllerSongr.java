package com.example.songer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerSongr {
    @GetMapping("/albums")
    public String getAlbums(Model model){

        AlbumModel Nassif = new AlbumModel("Toul Al Yom" ,"Nassif Zeytoun",13,3337,"https://www.annahar.com/ContentFiles/93331Image1.jpg?version=861098");
        AlbumModel Adham = new AlbumModel("Khayef" ,"Adham Nabulsi",11,4015,"https://cdn1-m.zahratalkhaleej.ae/store/archive/image/2020/11/16/ded505b1-6989-4384-9da4-eba715885bfb.jpg?format=jpg&preset=w1900");
        AlbumModel Hamaki = new AlbumModel("Ya Fatenny" ,"Hamaki",10,2725,"https://aawsat.com/sites/default/files/styles/article_img_top/public/2021/08/05/1628167094554394300.jpg?itok=WYuYEO-U");
        List <AlbumModel> albums = new ArrayList<AlbumModel>();
        albums.add(Nassif);
        albums.add(Adham);
        albums.add(Hamaki);
        model.addAttribute("albums" ,albums);

        return "songr.html";
    }
}

package com.example.songer;

import com.example.songer.Repositories.AlbumsRepository;
//import com.example.songer.Repositories.SongRepository;
import com.example.songer.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerSongr {

      @Autowired
      SongRepository songRepository;

    @Autowired
    AlbumsRepository albumsRepository;

    @PostMapping("/albums")
    public RedirectView addAlbum (@ModelAttribute AlbumModel albums , Model model){
       // model.addAttribute("albums",albums);
        albumsRepository.save(albums);
        return new RedirectView("/albums");
    }



    @GetMapping("/albums")
    public String getAlbums(Model model){
        model.addAttribute("albums" ,albumsRepository.findAll());
        return "songr.html";
    }

    @GetMapping("/oneAlbum")
    public String getOneAlbum(@RequestParam Integer id , Model model){
        AlbumModel albumModel = albumsRepository.findById(id).get();
        model.addAttribute("album" , albumModel);
        return "oneAlbum.html";

    }
}

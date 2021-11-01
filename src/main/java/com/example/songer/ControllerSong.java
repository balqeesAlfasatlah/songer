package com.example.songer;

import com.example.songer.Repositories.AlbumsRepository;
import com.example.songer.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class ControllerSong {

    @Autowired
    SongRepository songRepository;

     @Autowired
     AlbumsRepository albumsRepository;

    @GetMapping("/songs")
    public String songs(Model model) {
        List<SongModel> songs= (List<SongModel>) songRepository.findAll();
        model.addAttribute("songs",songs);
        return "songs.html";
    }

    @PostMapping("/addSong")
    public RedirectView addSong(@ModelAttribute SongModel song , Model model , @RequestParam Integer id) {
        AlbumModel album = albumsRepository.findById(id).get();
           SongModel addNewSong = new SongModel(song.getTitle(), song.getLength(), song.getTrackNumber(), album);
            songRepository.save(addNewSong);
            return new RedirectView("/oneAlbum?id=" + id);

    }
}

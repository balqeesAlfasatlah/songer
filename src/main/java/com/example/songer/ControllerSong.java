package com.example.songer;

import com.example.songer.Repositories.AlbumsRepository;
import com.example.songer.Repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public class ControllerSong {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping("/songs")
    public String songs(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "songs.html";
    }

    @PostMapping("/addSong")
    public RedirectView addSong(@RequestParam String title, int length, int trackNumber, int id, Model model) {
        AlbumModel song = albumsRepository.findById(id).get();
        List<SongModel> albums = songRepository.findAllByAlbum(song);
        if (song.getSongCount() > albums.size()) {
            SongModel addNewSong = new SongModel(title, length, trackNumber, song);
            songRepository.save(addNewSong);
            return new RedirectView("/oneAlbum?id=" + id);
        } else {
            return new RedirectView("full album");
        }
    }
}

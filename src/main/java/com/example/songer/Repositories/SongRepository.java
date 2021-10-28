package com.example.songer.Repositories;

import com.example.songer.AlbumModel;
import com.example.songer.SongModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<SongModel,Integer> {
    List<SongModel> findAllByAlbum (AlbumModel albumModel);
}

package com.example.songer.Repositories;

import com.example.songer.AlbumModel;
import com.example.songer.SongModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumsRepository extends CrudRepository<AlbumModel,Integer> {

}

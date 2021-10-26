package com.example.songer.Repositories;

import com.example.songer.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AlbumsRepository extends JpaRepository<AlbumModel,Integer> {
}

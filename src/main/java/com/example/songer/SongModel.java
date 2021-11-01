package com.example.songer;

import javax.persistence.*;
import java.util.List;

@Entity
public class SongModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    //@JoinColumn(name="albummodel_id")
    private AlbumModel albumModel;

    public SongModel() {
    }

    public SongModel(String title, int length, int trackNumber,AlbumModel albumModel) {
        this();
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.albumModel = albumModel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public AlbumModel getAlbumModel() {
        return albumModel;
    }

    public void setAlbumModel(AlbumModel albumModel) {
        this.albumModel = albumModel;
    }

    @Override
    public String toString() {
        return "SongModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", length=" + length +
                ", trackNumber=" + trackNumber +
                '}';
    }
}

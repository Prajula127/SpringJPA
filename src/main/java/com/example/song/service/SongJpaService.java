package com.example.song.service;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import java.util.*;

import com.example.song.model.Song;
import com.example.song.repository.*;

// Write your code here


@Service
public class SongJpaService implements SongRepository {
    @Autowired
    private SongJpaRepository songRepository;
    
    @Override
    public ArrayList<Song> getSongs() {
        List<Song> songlist = songRepository.findAll();
        ArrayList<Song> song = new ArrayList<>(songlist);
        return song;
    }

    @Override
    public Song getSongById(int songId) {
        try {
            Song song = songRepository.findById(songId).get();
            return song;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song) {
        songRepository.save(song);
        return song;
    }

    @Override
    public Song updateSong(int songId, Song song) {
        try {
            Song songs = songRepository.findById(songId).get();
            if (song.getSongName() != null) {
                songs.setSongName(song.getSongName());
            }

            if (song.getLyricist() != null) {
                songs.setLyricist(song.getLyricist());
            }

            if (song.getSinger() != null) {
                songs.setSinger(song.getSinger());
            }

            if (song.getMusicDirector() != null) {
                songs.setMusicDirector(song.getMusicDirector());
            }

            songRepository.save(songs);
            return songs;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteSong(int songId) {
        try {
            songRepository.deleteById(songId);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
package com.example.Rockstargames.repository;

import com.example.Rockstargames.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends JpaRepository<Game,String> {
}

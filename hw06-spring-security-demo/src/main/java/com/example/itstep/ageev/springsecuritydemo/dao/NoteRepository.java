package com.example.itstep.ageev.springsecuritydemo.dao;

import com.example.itstep.ageev.springsecuritydemo.domain.Note;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note,Integer> {
    List<Note> findByLabel(String label);
    List<Note> findByLabelContaining(String label);
    List<Note> findByLabelContainingOrMessageContaining(String label, String massege);
}

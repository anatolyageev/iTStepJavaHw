package com.example.itstep.ageev.springsecuritydemo.controller;


import com.example.itstep.ageev.springsecuritydemo.dao.NoteRepository;
import com.example.itstep.ageev.springsecuritydemo.domain.Note;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notes")
public class NoteController {
    private NoteRepository noteRepository;

    @Autowired
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String addNote(@ModelAttribute("note") Note note) {
        noteRepository.save(note);
        return "redirect:/notes/all";
    }

    @GetMapping("/all")
    public String notes(Model model) {
        model.addAttribute("notes", noteRepository.findAll());
        return "notes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") Integer id) {
        noteRepository.deleteById(id);
        return "redirect:/notes/all";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "word") String word, Model model){
        List<Note> list = noteRepository.findByLabelContainingOrMessageContaining(word, word);
        model.addAttribute("notes",list);
        return "notes";
    }
}

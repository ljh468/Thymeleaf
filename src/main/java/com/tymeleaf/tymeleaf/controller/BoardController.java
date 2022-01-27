package com.tymeleaf.tymeleaf.controller;

import com.tymeleaf.tymeleaf.Repository.BoardRepository;
import com.tymeleaf.tymeleaf.model.Board;
import com.tymeleaf.tymeleaf.validator.BoardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardValidator boardValidator;

    public BoardController(BoardRepository boardRepository, BoardValidator boardValidator) {
        this.boardRepository = boardRepository;
        this.boardValidator = boardValidator;
    }

    @Autowired



    @GetMapping("/list")
    public String list(Model model) {

        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);

        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id) {

        if(id == null){
            model.addAttribute("board", new Board());
        }else{
            Board board = boardRepository.findById(id).orElse(null);
            model.addAttribute("board", board);
        }
        return "board/form";
    }

    @PostMapping("/form")
    public String greetingSubmit(@Validated Board board, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "board/list";
        }
        Board save = boardRepository.save(board);
        return "redirect:/board/list";
    }
}
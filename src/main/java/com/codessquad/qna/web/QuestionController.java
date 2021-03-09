package com.codessquad.qna.web;

import com.codessquad.qna.domain.Qna;
import com.codessquad.qna.domain.QnaRepository;
import com.codessquad.qna.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QnaRepository qnaRepository;

    @PostMapping("/qna")
    public String qnaMain(Qna qna) {
        qnaRepository.save(qna);
        return "redirect:/";
    }

    @GetMapping("/")
    public String getQnaList(Model model) {
        model.addAttribute("qnaList", qnaRepository.findAll());
        return "index";
    }

    @GetMapping("qna/show/{qnaId}")
    public ModelAndView getOneQuestion(@PathVariable long qnaId) {
        ModelAndView modelAndView = new ModelAndView("qna/show");
        modelAndView.addObject("Qna", qnaRepository.findById(qnaId).get());
        return modelAndView;
    }
}

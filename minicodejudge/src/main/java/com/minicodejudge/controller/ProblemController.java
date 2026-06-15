package com.minicodejudge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minicodejudge.entity.Problem;
import com.minicodejudge.repository.ProblemRepository;

@Controller
public class ProblemController {

    @Autowired
    private ProblemRepository repository;

    @GetMapping("/problems")
    public String showProblems(Model model) {

        List<Problem> problems =
                repository.findAll();

        model.addAttribute("problems",
                problems);

        return "problems";
    }

    @GetMapping("/problems/new")
    public String newProblem(Model model) {

        model.addAttribute("problem",
                new Problem());

        return "add-problem";
    }

    @PostMapping("/problems")
    public String saveProblem(
            @ModelAttribute Problem problem) {

        repository.save(problem);

        return "redirect:/problems";
    }

    @GetMapping("/problems/{id}")
    public String problemDetails(
            @PathVariable Long id,
            Model model) {

        Problem problem =
                repository.findById(id)
                .orElseThrow();

        model.addAttribute("problem",
                problem);

        return "problem-details";
    }
}
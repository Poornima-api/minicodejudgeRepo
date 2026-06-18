package com.minicodejudge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.minicodejudge.entity.Submission;
import com.minicodejudge.service.CodeExecutionService;
import com.minicodejudge.service.SubmissionService;
@Controller
public class CodeController {
	@Autowired
	private CodeExecutionService codeExecutionService;
	@Autowired
	private SubmissionService submissionService;
@GetMapping("/run")
public String showEditor() {
	return "run-code";
}
@PostMapping("/run")
public String runCode(@RequestParam("code") String code,@RequestParam("action") String action,Model model) {
	System.out.println("---------post run reached---------");
	String output=codeExecutionService.executeJavaCode(code);
	model.addAttribute("output",output);
	if(action.equals("save")) {
	Submission submission=new Submission();
	submission.setSourceCode(code);
	submission.setOutput(output);
	submission.setStatus("Executed");
	submissionService.saveSubmission(submission);
	model.addAttribute(
	        "message",
	        "Submission saved successfully!");
	
	}
	
	return "run-code";
}

}

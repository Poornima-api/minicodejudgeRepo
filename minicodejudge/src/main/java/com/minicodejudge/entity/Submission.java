package com.minicodejudge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Submission {
	@ManyToOne
	@JoinColumn(name="problem_id")
	private Problem problem;
	public Problem getProblem() {
		return problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	@Column(columnDefinition ="LONGTEXT")
	private String sourceCode;
	@Column(columnDefinition="TEXT")
	private String output;
	
	public long getId() {
		return id;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public String getOutput() {
		return output;
	}

	public String getStatus() {
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

}

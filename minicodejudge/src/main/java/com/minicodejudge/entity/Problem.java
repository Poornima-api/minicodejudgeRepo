package com.minicodejudge.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String difficulty;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String sampleInput;

    private String sampleOutput;

    public Problem() {
    }

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public String getDescription() {
		return description;
	}

	public String getSampleInput() {
		return sampleInput;
	}

	public String getSampleOutput() {
		return sampleOutput;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSampleInput(String sampleInput) {
		this.sampleInput = sampleInput;
	}

	public void setSampleOutput(String sampleOutput) {
		this.sampleOutput = sampleOutput;
	}

    // Getters and Setters
}
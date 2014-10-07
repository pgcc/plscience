/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.ufjf.model.parsifal;

/**
 *
 * @author vitorfs
 */
public class Review {
    private Long id;
    private String name;
    private String title;
    private String description;
    private String author;
    private String create_date;
    private String last_update;
    private String objective;
    private String status;
    private Double quality_assessment_cutoff_score;
    private String study_selection_strategy;
    private String quality_assessment_strategy;
    private String data_extraction_strategy;
    private String population;
    private String intervention;
    private String comparison;
    private String outcome;
    private String context;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the create_date
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * @param create_date the create_date to set
     */
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    /**
     * @return the last_update
     */
    public String getLast_update() {
        return last_update;
    }

    /**
     * @param last_update the last_update to set
     */
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    /**
     * @return the objective
     */
    public String getObjective() {
        return objective;
    }

    /**
     * @param objective the objective to set
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the quality_assessment_cutoff_score
     */
    public Double getQuality_assessment_cutoff_score() {
        return quality_assessment_cutoff_score;
    }

    /**
     * @param quality_assessment_cutoff_score the quality_assessment_cutoff_score to set
     */
    public void setQuality_assessment_cutoff_score(Double quality_assessment_cutoff_score) {
        this.quality_assessment_cutoff_score = quality_assessment_cutoff_score;
    }

    /**
     * @return the study_selection_strategy
     */
    public String getStudy_selection_strategy() {
        return study_selection_strategy;
    }

    /**
     * @param study_selection_strategy the study_selection_strategy to set
     */
    public void setStudy_selection_strategy(String study_selection_strategy) {
        this.study_selection_strategy = study_selection_strategy;
    }

    /**
     * @return the quality_assessment_strategy
     */
    public String getQuality_assessment_strategy() {
        return quality_assessment_strategy;
    }

    /**
     * @param quality_assessment_strategy the quality_assessment_strategy to set
     */
    public void setQuality_assessment_strategy(String quality_assessment_strategy) {
        this.quality_assessment_strategy = quality_assessment_strategy;
    }

    /**
     * @return the data_extraction_strategy
     */
    public String getData_extraction_strategy() {
        return data_extraction_strategy;
    }

    /**
     * @param data_extraction_strategy the data_extraction_strategy to set
     */
    public void setData_extraction_strategy(String data_extraction_strategy) {
        this.data_extraction_strategy = data_extraction_strategy;
    }

    /**
     * @return the population
     */
    public String getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(String population) {
        this.population = population;
    }

    /**
     * @return the intervention
     */
    public String getIntervention() {
        return intervention;
    }

    /**
     * @param intervention the intervention to set
     */
    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    /**
     * @return the comparison
     */
    public String getComparison() {
        return comparison;
    }

    /**
     * @param comparison the comparison to set
     */
    public void setComparison(String comparison) {
        this.comparison = comparison;
    }

    /**
     * @return the outcome
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * @param outcome the outcome to set
     */
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    /**
     * @return the context
     */
    public String getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(String context) {
        this.context = context;
    }
}

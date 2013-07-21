package com.realtech.cloudschool.collaboration.domain.model;


import javax.persistence.*;

@Entity
public class GroupParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="GROUP_ID")
    private LearningGroup learningGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LearningGroup getLearningGroup() {
        return learningGroup;
    }

    public void setLearningGroup(LearningGroup learningGroup) {
        this.learningGroup = learningGroup;
    }
}

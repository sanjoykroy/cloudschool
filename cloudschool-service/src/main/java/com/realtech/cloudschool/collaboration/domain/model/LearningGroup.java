package com.realtech.cloudschool.collaboration.domain.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class LearningGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date createDate;
    private boolean enabled;
    @Embedded
    private GroupOwner owner;
    @OneToMany(mappedBy = "learningGroup")
    private List<GroupParticipant> participants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public GroupOwner getOwner() {
        return owner;
    }

    public void setOwner(GroupOwner owner) {
        this.owner = owner;
    }

    public List<GroupParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<GroupParticipant> participants) {
        this.participants = participants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LearningGroup)) return false;

        LearningGroup learningGroup = (LearningGroup) o;

        if (enabled != learningGroup.enabled) return false;
        if (createDate != null ? !createDate.equals(learningGroup.createDate) : learningGroup.createDate != null) return false;
        if (description != null ? !description.equals(learningGroup.description) : learningGroup.description != null) return false;
        if (id != null ? !id.equals(learningGroup.id) : learningGroup.id != null) return false;
        if (name != null ? !name.equals(learningGroup.name) : learningGroup.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LearningGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                '}';
    }
}

package org.bmn.knowledgemanagementsystem.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;

@Table(
        name = "DIRECTORY",
        uniqueConstraints = {@UniqueConstraint(name = "UniqueNameAndDepthLevel", columnNames = {"NAME", "DEPTH_LEVEL"})})
@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Directory {

    @Id
    @GeneratedValue(generator = "id-generator")
    @GenericGenerator(
            name = "id-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "id_sequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "ID", nullable = false)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @NotEmpty(
            message= "{validation.message.directory.name.notEmpty}")
    @Size(
            min=1,
            max=100,
            message="{validation.message.directory.name.size}")
    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED")
    private LocalDateTime created;

    @Column(name = "MODIFIED")
    private LocalDateTime modified;

    @DecimalMin(
            value = "1",
            message = "{validation.message.directory.depthLevel.minSize}")
    @DecimalMax(
            value = "1000",
            message = "{validation.message.directory.depthLevel.maxSize}"
    )
    @Column(name = "DEPTH_LEVEL")
    private Integer depthLevel;

    @OneToMany
    @JoinColumn(
            name = "CONTENT_ID",
            nullable = false
    )
    private Collection<Content> contents;

    @PrePersist
    void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate() {
        this.setModified(LocalDateTime.now());
    }

    //TODO add auto depthLevel

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return true;
        if (!(o instanceof Directory)) return false;
        Directory that = (Directory) o;
        return this.getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
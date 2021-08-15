//package org.bmn.knowledgemanagementsystem.model;
//
//import lombok.*;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Table(name = "BRANCH")
//@Entity
//@Setter
//@Getter
//@AllArgsConstructor
//@RequiredArgsConstructor
//@ToString
//public class Branch {
//
//    @Id
//    @GeneratedValue(generator = "id-generator")
//    @GenericGenerator(
//            name = "id-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @Parameter(name = "sequence_name", value = "id_sequence"),
//                    @Parameter(name = "initial_value", value = "1000"),
//                    @Parameter(name = "increment_size", value = "1")
//            }
//    )
//    @Column(name = "ID", nullable = false)
//    @Setter(value = AccessLevel.NONE)
//    private Long id;
//
//    @NotEmpty(
//            message= "{validation.message.branch.name.notEmpty}")
//    @Size(
//            max=100,
//            message="{validation.message.branch.name.size}")
//    @Column(name = "NAME", unique = true)
//    private String name;
//
//    @Column(name = "CREATED")
//    private LocalDateTime created;
//
//    @Column(name = "MODIFIED")
//    private LocalDateTime modified;
//
//    @ElementCollection
//    @CollectionTable(name = "BRANCH_DIRECTORIES")
//    @OrderColumn
//    @Column(name = "SUBDIRECTORIES")
////    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    List<Directory> directories;
//
//    @PrePersist
//    void onCreate() {
//        this.setCreated(LocalDateTime.now());
//        this.setModified(LocalDateTime.now());
//    }
//
//    @PreUpdate
//    void onUpdate() {
//        this.setModified(LocalDateTime.now());
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null) return true;
//        if (!(o instanceof Branch)) return false;
//        Branch that = (Branch) o;
//        return this.getName().equals(that.getName());
//    }
//
//    @Override
//    public int hashCode() {
//        return getName().hashCode();
//    }
//}

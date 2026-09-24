package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name ="is_template",nullable = false)
    private String isTemplate;

    @Column(name ="is_private",nullable = false)
    private String isPrivate;

    @Column(name ="created_at",nullable = false)
    private String createdAt;


    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name="assignment_id")
    private Assignment assignment;


    @OneToMany(mappedBy="repository",cascade = CascadeType.ALL)
    @JsonIgnore
    List<PullRequest> pullrequest;

    @OneToMany(mappedBy="repository",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Commit> commits;

    @ManyToOne
    @JoinColumn(name = "parent_repo_id")
    private Repository repository;





}

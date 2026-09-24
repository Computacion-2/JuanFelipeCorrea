package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

//    @Column(name = "full_name", nullable = false)
//    private String role;
//
//    @Column(nullable = false)
//    private String fullName;

    @Column(name = "full_name",nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String role;

    //revisada
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Classroom> ownedRepositories;

    //revisada
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Repository> taughtRepositories;

    //Revisada
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PullRequest> authoredPullRequests;

    //revisada
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<PullRequest> reviewedPullRequests;

    //revisada
    @OneToMany(mappedBy = "collaborators", cascade = CascadeType.ALL)
    private List<Commit> commits;

    //@OneToMany(mappedBy = "repos", cascade = CascadeType.ALL)
}

package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository extends JpaRepository<PullRequest, Long> {
//    List<PullRequest>findDistinctByUsers_Teacher_OwnedRepository_NameAndOwnedRepository_And_Teacher_OwnedRepositories_Repository
//            (
//                   String name,
//                   String status
//            );

    List<PullRequest>findDistinctByReviewer_OwnedRepositories_NameAndStatus(String name,String status);

}

package ru.stqa.pft.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Антон on 07.11.2017.
 */
public class GithubTests {


  @Test
  public void testCommits() throws IOException {
       Github github = new RtGithub("fbc562bd4a3e9014178cd00c09747b43c68dc6a6");
       RepoCommits commits = github.repos().get(new Coordinates.Simple("QL-Anton", "javaForTesters")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
           System.out.println(new RepoCommit.Smart(commit).message());
         }
      }
 }

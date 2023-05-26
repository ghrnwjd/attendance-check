package com.ghrnwjd.attendanceCheck;

import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.model.User;
import com.ghrnwjd.attendanceCheck.repository.GitRepoRepository;
import com.ghrnwjd.attendanceCheck.repository.UserRepository;
import com.ghrnwjd.attendanceCheck.service.GitRepoService;
import com.ghrnwjd.attendanceCheck.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AttendanceCheckApplicationTests {

	AttendanceCheckApplicationTests(GitRepoService gitRepoService, UserService userService) {
		this.gitRepoService = gitRepoService;
		this.userService = userService;
	}

	@Test
	void contextLoads() {
	}

	@Autowired
	private GitRepoRepository gitRepoRepository;

	@Autowired
	private UserRepository userRepository;

	private final GitRepoService gitRepoService;
	private final UserService userService;

	@Test

	void test() {
		List<User> users = userService.findAll();
		List<GitRepo> repoList = null;
		for(int j = 0; j < users.size(); j++) {
			for(int i = 0; i < users.size(); i++) {
				gitRepoService.getRepos(users.get(i).getGitId());
			}
			repoList = gitRepoRepository.findAllByUser(userRepository.findByGitId(users.get(j).getGitId()).orElseGet(()-> {
				System.out.println("해당 사용자를 찾을 수 없습니다.");
				return null;
			}));
		}

		for(GitRepo temp : repoList) {
			System.out.println(temp.getRepoName());
		}



	}

}

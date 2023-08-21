package com.ghrnwjd.attendanceCheck;

<<<<<<< HEAD
import com.ghrnwjd.attendanceCheck.config.GithubInfoConfig;
=======
import com.ghrnwjd.attendanceCheck.model.GitRepo;
import com.ghrnwjd.attendanceCheck.model.User;
import com.ghrnwjd.attendanceCheck.repository.GitRepoRepository;
import com.ghrnwjd.attendanceCheck.repository.UserRepository;
import com.ghrnwjd.attendanceCheck.service.GitRepoService;
import com.ghrnwjd.attendanceCheck.service.UserService;
>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

<<<<<<< HEAD
@SpringBootTest
class AttendanceCheckApplicationTests {

	@Autowired
	private GithubInfoConfig githubInfoConfig;

//	AttendanceCheckApplicationTests(GithubConfig githubConfig) {
//		this.githubConfig = githubConfig;
//	}
//


	@Test
	public void 깃허브아이디패스워드출력되는지() {
		System.out.println("깃허브 아이디: " + githubInfoConfig.getGithubId());
		System.out.println("깃허브 패스워드: " + githubInfoConfig.getGithubPassword());
	}
=======
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

>>>>>>> facc1e5b9e27b9e9335aaab8cfc5e84b5ac0e568
}

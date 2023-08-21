package com.ghrnwjd.attendanceCheck;

import com.ghrnwjd.attendanceCheck.config.GithubInfoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

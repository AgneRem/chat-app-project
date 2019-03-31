package lt.vtmc.webchat.payload;

import java.time.Instant;

public class UserSummary {

	private Long id;
	private String username;
	private String nickname;
	private String email;
	private Instant joinedAt;

	public UserSummary(Long id, String username, String nickname, String email,
			Instant joinedAt) {
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.joinedAt = joinedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String name) {
		this.nickname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Instant joinedAt) {
		this.joinedAt = joinedAt;
	}
}

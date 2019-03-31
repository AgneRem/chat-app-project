package lt.vtmc.webchat.payload;

import java.time.Instant;

public class UserProfile {

	private Long id;
	private String username;
	private String nickname;
	private Instant joinedAt;

	public UserProfile(Long id, String username, String nickname,
			Instant joinedAt) {
		this.id = id;
		this.username = username;
		this.nickname = nickname;
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

	public void setName(String nickname) {
		this.nickname = nickname;
	}

	public Instant getJoinedAt() {
		return joinedAt;
	}

	public void setJoinedAt(Instant joinedAt) {
		this.joinedAt = joinedAt;
	}
}

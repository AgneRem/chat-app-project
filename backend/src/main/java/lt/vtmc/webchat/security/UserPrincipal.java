package lt.vtmc.webchat.security;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lt.vtmc.webchat.model.User;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = -8699278984532812686L;

	private Long id;

	private String username;

	@JsonIgnore
	private String nickname;

	@JsonIgnore
	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;
	
	@JsonIgnore
	private Instant joinedAt;

	public UserPrincipal(Long id, String username, String nickname,
			String email, String password,
			Collection<? extends GrantedAuthority> authorities, Instant joinedAt) {
		this.id = id;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.joinedAt = joinedAt;
	}

	public static UserPrincipal create(User user) {
		List<GrantedAuthority> authorities = user.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserPrincipal(user.getId(), user.getUsername(),
				user.getNickname(), user.getEmail(), user.getPassword(),
				authorities, user.getCreatedAt());
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Instant getJoinedAt() {
		return joinedAt;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

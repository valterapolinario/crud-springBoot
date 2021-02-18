package com.valterApolinario.apiRest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails , Serializable {
	 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String userName;
	private String fullName;
	private String password;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;
	private Boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_permission",
	joinColumns = {@JoinColumn(name = "id_user")}
	,inverseJoinColumns = {@JoinColumn(name = "id_permission")})
	private List<Permission>permissions;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.permissions;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
	
	public List<String>getRoles(){
		List<String> roles = new ArrayList<>();
		for (Permission permission : this.permissions) {
			
			roles.add(permission.getDescription());
		}
		return roles;
	}

}

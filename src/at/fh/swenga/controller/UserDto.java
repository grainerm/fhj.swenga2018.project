package at.fh.swenga.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {
    @NotNull
    @NotEmpty
    private String vorname;
     
    @NotNull
    @NotEmpty
    private String nachname;
     
    @NotNull
    @NotEmpty
    private String passwort;
    private String matchingPasswort;
     
    @NotNull
    @NotEmpty
    private String nickname;

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getMatchingPasswort() {
		return matchingPasswort;
	}

	public void setMatchingPasswort(String matchingPasswort) {
		this.matchingPasswort = matchingPasswort;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	
}

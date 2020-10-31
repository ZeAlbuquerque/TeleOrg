package br.com.fiap.teleorg.dto;

public class TokenDto {
    private String login;
    private String token;

    public TokenDto() {
    }

    public TokenDto(String login, String token) {
        this.login = login;
        this.token = token;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

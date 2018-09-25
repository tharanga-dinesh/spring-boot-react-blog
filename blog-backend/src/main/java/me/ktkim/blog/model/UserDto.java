package me.ktkim.blog.model;

import lombok.Data;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Keumtae Kim
 */
public class UserDto {

    @Data
    public static class Create {
        private Long id;
        private String login;
        private String password;
        private String email;
        private String name;
        private Set<String> authorities;
        private boolean activated = false;
        private String createdBy;
        private LocalDateTime createdDate;
        private String lastModifiedBy;
        private LocalDateTime lastModifiedDate;

    }

    @Data
    public static class Update {
        private Long id;
        private String login;
        private String email;
        private String name;
        private Set<String> authorities;
        private boolean activated;

    }

    @Data
    public static class Response {
        private Long id;
        private String login;
        private String email;
        private String name;
        private Set<String> authorities;
        private boolean activated;


        public void setAuthorities(Set<Authority> authorities) {
            this.authorities = authorities.stream().map(Authority::getName).collect(Collectors.toSet());
        }
    }

    @Data
    public static class Login {
        private String login;
        @Size(min = 4, max = 12)
        private String password;

    }
}
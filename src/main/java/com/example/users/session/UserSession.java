package com.example.users.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSession implements Serializable {
   Long userId;
   Long roleId;
}

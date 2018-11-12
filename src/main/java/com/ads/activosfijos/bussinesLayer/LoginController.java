package com.ads.activosfijos.bussinesLayer;

import com.ads.activosfijos.dataAccessLayer.IUserService;
import com.ads.activosfijos.dataAccessLayer.impl.UserService;
import com.ads.activosfijos.entityLayer.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by Fabiani Lozano on 11/11/2018.
 */
@RestController
public class LoginController {

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private IUserService userService;

    /**
     * Operacion que autentica usuarios y genera jwt
     * @param login
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> login(@RequestBody @Valid final UserDTO login) {
        final boolean existUser = userService.existUser(login.getUser(), login.getPassword());
        if (!existUser) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        final Instant now = Instant.now();

        final String jwt = Jwts.builder()
                .setSubject(login.getUser())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secret))
                .compact();
        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    /**
     * Operacion que registra los usuarios
     * @param user
     * @return
     */
    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody @Valid final UserDTO user){
        userService.registerUser(user);
        return new ResponseEntity<>("Usuario creado correctamente",HttpStatus.OK);
    }

}

package com.ads.activosfijos.dataAccessLayer;

import com.ads.activosfijos.entityLayer.User;
import com.ads.activosfijos.entityLayer.dto.UserDTO;

/**
 * Created by Fabiani Lozano on 12/11/2018.
 */
public interface IUserService {
    /**
     * Comprueba que un usuario este registrado
     * @param user
     * @param password
     * @return
     */
    public boolean existUser(final String user, String password);

    /**
     * Consulta usuarios por nombre de usuario
     * @param user
     * @return
     */
    public User getUser(final String user) ;

    /**
     * Registra usuarios
     * @param user
     * @return
     */
    public User registerUser(UserDTO user) ;
}

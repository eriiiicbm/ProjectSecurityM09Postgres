package m09_project_spingsecurity.demo.servicio;

import m09_project_spingsecurity.demo.model.Usuari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserExtraService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService serveiUsuaris;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuari u= serveiUsuaris.findById(s);
        User.UserBuilder builder=null;
        if(u!=null){
            builder=User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("User not found");
        return builder.build();
    }

}

//package io.github.kduferreira.APIMedic.Service;
//
//import io.github.kduferreira.APIMedic.Domain.UserEntity;
//import io.github.kduferreira.APIMedic.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        // Consulta o banco de dados ou qualquer outra fonte para obter detalhes do usuário
//        // Substitua este exemplo pelo seu mecanismo de busca de usuário
//
//        // Exemplo: busca um usuário no banco de dados por nome de usuário
//        UserEntity userEntity = userRepository.findByUsername(username);
//        if (userEntity == null) {
//            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
//        }
//
//        // Constrói um objeto UserDetails com base nas informações do usuário
//        UserDetails userDetails = User.builder()
//                .username(userEntity.getUsername())
//                .password(userEntity.getPassword())
//                .roles(userEntity.getRoles()) // Se você estiver usando papéis (roles)
//                .build();
//
//        return userDetails;
//    }
//}

//package io.github.kduferreira.APIMedic.Security;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.function.Function;
//
//@Service
//public class JwtUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    // Método para gerar um token JWT
//    public String generateToken(UserDetails userDetails) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + expiration);
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    // Método para validar um token JWT
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    // Extrai o nome de usuário do token
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    // Extrai uma informação do token usando uma função
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    // Extrai todas as informações do token
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    // Verifica se o token expirou
//    private Boolean isTokenExpired(String token) {
//        final Date expiration = extractExpiration(token);
//        return expiration.before(new Date());
//    }
//
//    // Extrai a data de expiração do token
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//}
//

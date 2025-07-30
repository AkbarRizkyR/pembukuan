package pembukuan.exo.com.util;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class JwtUtils {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    @ConfigProperty(name = "jwt.expiration.minutes", defaultValue = "60")
    long expirationMinutes;

    public String generateToken(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");

        return Jwt.issuer(issuer)
                .upn(username)
                .groups(roles)
                .expiresIn(Duration.ofMinutes(expirationMinutes))
                .sign();
    }
}
package app;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public endpoint";
    }

    @GetMapping("/private")
    @PreAuthorize("hasRole('GERENTE')")
    public String privateEndpoint() {
        return "Private endpoint";
    }
}

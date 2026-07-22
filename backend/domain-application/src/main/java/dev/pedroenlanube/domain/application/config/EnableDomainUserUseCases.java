package dev.pedroenlanube.domain.application.config;

import dev.pedroenlanube.domain.application.user.UserUseCasesConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({UserUseCasesConfiguration.class})
public @interface EnableDomainUserUseCases { }

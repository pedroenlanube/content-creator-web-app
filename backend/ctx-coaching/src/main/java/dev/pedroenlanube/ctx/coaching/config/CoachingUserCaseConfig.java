package dev.pedroenlanube.ctx.coaching.config;

import dev.pedroenlanube.domain.model.coaching.command.ReserveSessionCmd;
import dev.pedroenlanube.domain.port.in.strategy.DomainConsumerStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class CoachingUserCaseConfig {

    @Bean
    public Consumer<ReserveSessionCmd> reserveSessionUseCase(
            List<DomainConsumerStrategy<ReserveSessionCmd>> strategies) {
        return cmd -> strategies.stream()
                .filter(strategy -> strategy.isApplicable(cmd))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No strategy found for command: " + cmd))
                .execute(cmd);
    }
}

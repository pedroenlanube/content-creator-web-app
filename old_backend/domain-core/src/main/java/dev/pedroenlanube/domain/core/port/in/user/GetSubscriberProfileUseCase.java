package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.user.User;
import dev.pedroenlanube.domain.core.model.user.query.GetSubscriberProfileQuery;

import java.util.function.Function;

public interface GetSubscriberProfileUseCase extends Function<GetSubscriberProfileQuery, User> {
}

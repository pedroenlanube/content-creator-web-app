package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.User;
import dev.pedroenlanube.domain.model.user.query.GetSubscriberProfileQuery;

import java.util.function.Function;

public interface GetSubscriberProfileUseCase extends Function<GetSubscriberProfileQuery, User> {
}

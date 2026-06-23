package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.Subscriber;
import dev.pedroenlanube.domain.model.user.query.GetSubscriberProfileQuery;

import java.util.function.Function;

public interface GetSubscriberProfileUseCase extends Function<GetSubscriberProfileQuery, Subscriber> {
}

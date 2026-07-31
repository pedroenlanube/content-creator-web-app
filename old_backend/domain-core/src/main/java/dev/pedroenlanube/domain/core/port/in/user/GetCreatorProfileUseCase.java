package dev.pedroenlanube.domain.core.port.in.user;

import dev.pedroenlanube.domain.core.model.user.User;
import dev.pedroenlanube.domain.core.model.user.query.GetCreatorProfileQuery;

import java.util.function.Function;

public interface GetCreatorProfileUseCase extends Function<GetCreatorProfileQuery, User> {
}

package dev.pedroenlanube.domain.port.in.user;

import dev.pedroenlanube.domain.model.user.Creator;
import dev.pedroenlanube.domain.model.user.query.GetCreatorProfileQuery;

import java.util.function.Function;

public interface GetCreatorProfileUseCase extends Function<GetCreatorProfileQuery, Creator> {
}

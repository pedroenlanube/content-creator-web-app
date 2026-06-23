package dev.pedroenlanube.domain.model.user.command;

public record UpdateCreatorProfileCmd(
        String creatorId,
        String username,
        String biography,
        String avatarUrl,
        String bannerUrl,
        String socialMedia //TODO revisar esto, cambiar por un listado de redes con tipo (enum) y url?
) {
}

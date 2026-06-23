package dev.pedroenlanube.domain.model.user.command;

import dev.pedroenlanube.domain.model.user.vo.SocialMediaLink;

import java.util.List;

public record UpdateCreatorProfileCmd(
        String creatorId,
        String username,
        String biography,
        String avatarUrl,
        String bannerUrl,
        List<SocialMediaLink> socialMediaLinks
) {
    public UpdateCreatorProfileCmd {
        if(socialMediaLinks == null)
            socialMediaLinks = List.of();
    }
}

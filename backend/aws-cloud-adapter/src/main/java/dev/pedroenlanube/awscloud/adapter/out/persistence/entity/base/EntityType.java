package dev.pedroenlanube.awscloud.adapter.out.persistence.entity.base;

public enum EntityType {
    // ctx-user
    USER,
    HANDLE_LOCK,

    // ctx-tenant
    TENANT_CONFIG,

    // ctx-tiers & ctx-billing
    TIER,
    SUBSCRIPTION,
    INVOICE,

    // ctx-community & ctx-media
    POST,
    POST_COMMENT,
    POST_LIKE,
    CONTENT_DOCUMENT,
    CONTENT_IMAGE,
    CONTENT_VIDEO,

    // ctx-coaching
    COACHING_SESSION,
    COACHING_SLOT,

    // ctx-notifications
    NOTIFICATION,

    // ctx-audit
    AUDIT_LOG
}

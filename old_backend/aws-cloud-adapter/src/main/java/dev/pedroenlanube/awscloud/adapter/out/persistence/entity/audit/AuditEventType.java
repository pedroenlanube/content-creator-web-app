package dev.pedroenlanube.awscloud.adapter.out.persistence.entity.audit;

public enum AuditEventType {
    // ctx-iam & ctx-user
    USER_SIGNED_UP,
    USER_PROFILE_CREATED,
    USER_PROFILE_UPDATED,
    USER_PROFILE_DELETED,

    // ctx-tiers
    TIER_CREATED,
    TIER_UPDATED,
    TIER_DELETED,

    // ctx-billing
    SUBSCRIPTION_REQUESTED,
    SUBSCRIPTION_CANCELLED,
    PAYMENT_SUCCEEDED,
    PAYMENT_FAILED,

    // ctx-community
    POST_PUBLISHED,
    POST_DELETED,
    COMMENT_ADDED,
    POST_LIKED,

    // ctx-media
    MEDIA_UPLOADED,
    MEDIA_PROCESSED,
    MEDIA_DELETED,

    // ctx-coaching
    COACHING_SESSION_SCHEDULED,
    COACHING_SESSION_COMPLETED,
    COACHING_SESSION_CANCELLED,

    // ctx-notifications
    NOTIFICATION_SENT,
    NOTIFICATION_FAILED,

    // ctx-tenant
    TENANT_CONFIG_UPDATED,

    // system
    SYSTEM_ERROR
}
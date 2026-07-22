package dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity.audit;

import dev.pedroenlanube.cloudcommons.infrastructure.adapter.out.persistence.entity.base.BaseDynamoEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@DynamoDbBean
public class AuditEntity extends BaseDynamoEntity {
    private String eventId;
    private AuditEventType eventType;
    private String actorId;         // Quién originó el evento
    private String resourceId;      // Sobre qué entidad (ej. el ID del post o del usuario)
    private String payload;         // JSON crudo con el detalle del evento para futuras investigaciones

    @DynamoDbAttribute("eventId")
    public String getEventId() { return eventId; }

    @DynamoDbAttribute("eventTypeString")
    public AuditEventType getEventType() { return eventType; }

    @DynamoDbAttribute("actorId")
    public String getActorId() { return actorId; }

    @DynamoDbAttribute("resourceId")
    public String getResourceId() { return resourceId; }

    @DynamoDbAttribute("payload")
    public String getPayload() { return payload; }
}
package pe.business.app.strips.repository.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@MappedSuperclass
public class AuditingEntity implements Serializable, BaseEntity {

    @Column(name = "updated_user"
            )
    private String updatedBy;


}

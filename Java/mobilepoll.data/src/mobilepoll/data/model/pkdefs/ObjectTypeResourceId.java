package mobilepoll.data.model.pkdefs;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ObjectTypeResourceId
{
    @Column(name = "TipoObjeto")
    private long objectTypeId;
    
    @Column(name = "ItemRecurso")
    private long resourceId;
}
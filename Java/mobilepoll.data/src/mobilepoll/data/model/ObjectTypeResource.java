package mobilepoll.data.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import mobilepoll.data.model.pkdefs.ObjectTypeResourceId;

/**
 * Associa recursos a tipos de objeto do sistema.
 * 
 * Cada recurso do sistema (páginas web, tela de aplicação móvel, etc) pode manipular um
 * ou mais tipos de objeto ou entidade do sistema. Por exemplo, podemos ter uma página
 * web onde são gerenciados usuários e permissões. Logo, este recurso (por exemplo, usermanager.html)
 * manipula 2 tipos de objeto do sistema (usuários e permissões).
 * 
 * Assim, habilita-se as funcionalidades na tela ou página de acordo com:
 * 
 *      1 - Os tipos de objeto que a página manipula
 *      2 - As permissões do usuário individualmente para os tipos de objeto
 * 
 * @author alira
 */
@Entity
@Table(name = "TipoObjeto_Recurso")
public class ObjectTypeResource
{
    /** Construtor */
    public ObjectTypeResource() { }
    
    @EmbeddedId
    ObjectTypeResourceId id;
    
    /** Recurso ao qual está sendo associado o tipo de objeto */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ItemRecurso", nullable = false)
    @PrimaryKeyJoinColumn
    Resource resourceItem;
    /** GET para o recurso ao qual está sendo associado o tipo de objeto */
    public Resource getResourceItem() { return this.resourceItem; }
    /** SET para o recurso ao qual está sendo associado o tipo de objeto */
    public void setResourceItem(Resource rItem) { this.resourceItem = rItem; }
    
    /** Tipo de objeto do sistema que está sendo associado ao recurso */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoObjeto", nullable = false)
    @PrimaryKeyJoinColumn
    ObjectType objectType;
    /** GET para o tipo de objeto do sistema que está sendo associado ao recurso */
    public ObjectType getObjectType() { return objectType; }
    /** SET para o tipo de objeto do sistema que está sendo associado ao recurso */
    public void setObjectType(ObjectType oType) { this.objectType = oType; }
    
    /** Permissões requeridas pelo tipo de objeto do sistema para o recurso em questão */
    @Column(name = "PermissoesUsadas", length = 20, nullable = false)
    String usedRights;
    /** GET para as permissões requeridas pelo tipo de objeto para o recurso em questão */
    public String getUsedRights() { return usedRights; }
    /** SET para as permissões requeridas pelo tipo de objeto para o recurso em questão */
    public void setUsedRights(String rights) { this.usedRights = rights; }
}
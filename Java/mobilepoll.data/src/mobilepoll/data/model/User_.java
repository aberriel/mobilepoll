package mobilepoll.data.model;

import java.util.Date;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mobilepoll.data.model.enums.UserType_Tp;


/** Modelo estático de metadados para usuários do sistema */
@StaticMetamodel(User.class)
public class User_
{
    /** Login do usuário do sistema */
    public static volatile SingularAttribute<User, String> login;
    /** Senha do usuário */
    public static volatile SingularAttribute<User, String> password;
    /** Tipo de usuário (se administrativo ou do cliente */
    public static volatile SingularAttribute<User, UserType_Tp> userType;
    /** Cliente ao qual o usuário pertence (para usuários do cliente) */
    public static volatile SingularAttribute<User, Client> client;
    /** Pergunta secreta (para recuperação de senha) */
    public static volatile SingularAttribute<User, String> secretQuestion;
    /** Resposta secreta (para recuperação de senha) */
    public static volatile SingularAttribute<User, String> secretAnswer;
    /** Flag de controle de solicitação de troca de senha */
    public static volatile SingularAttribute<User, Boolean> changePassword;
    /** Flag indicador de usuário gerenciador de cliente */
    public static volatile SingularAttribute<User, Boolean> masterUser;
    /** Caminho completo para arquivo de foto do usuário */
    public static volatile SingularAttribute<User, String> photo;
    /** Flag de redefinição de senha */
    public static volatile SingularAttribute<User, String> passwordResetControl;
    /** Data e hora da solicitação de redefinição */
    public static volatile SingularAttribute<User, Date> passwordResetRequestDateTime;
    public static volatile SingularAttribute<User, Interviewee> interviewee;
    public static volatile ListAttribute<User, Research> assignedResearchs;
    /** Grupos aos quais o usuário pertence */
    public static volatile ListAttribute<User, UserGroup> userGroupList;
    /** Permissões atribuídas diretamente ao usuário */
    public static volatile ListAttribute<User, Right> rightList;
    public static volatile ListAttribute<User, UserResearchAuthorization> researchAuthorizationHistory;
    public static volatile ListAttribute<User, InterviewerClientMail> mailBoxWithClient;
}
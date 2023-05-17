package top.moyel.ink.mark.modules.system.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.*;
import top.moyel.ink.mark.base.entity.BaseEntity;
import top.moyel.ink.mark.flex.MybatisFlexInsertInjectUser;
import top.moyel.ink.mark.flex.MybatisFlexUpdateInjectUser;
import top.moyel.ink.mark.modules.system.validate.SysUserPutGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_user", onInsert = MybatisFlexInsertInjectUser.class, onUpdate = MybatisFlexUpdateInjectUser.class)
public class SysUser extends BaseEntity {
    @NotBlank(groups = SysUserPutGroup.class)
    @Id(value = "id", keyType = KeyType.Auto)
    private Long id;
    @Null(groups = SysUserPutGroup.class)
    @Column(value = "username")
    private String username;
    @Column(value = "nickname")
    private String nickname;
    @Column(value = "email")
    private String email;
    @Column(value = "phone_number")
    private String phoneNumber;
    @Column(value = "sex")
    private Integer sex;
    @Column(value = "avatar")
    private String avatar;
    @Null(groups = SysUserPutGroup.class)
    @Column(value = "password")
    private String password;
    @Null(groups = SysUserPutGroup.class)
    @Column(value = "salt")
    private String salt;
    @Null(groups = SysUserPutGroup.class)
    @Column(value = "status")
    private String status;
    @Null(groups = SysUserPutGroup.class)
    @Column(value = "login_ip")
    private String loginIp;
    @Null(groups = SysUserPutGroup.class)
    @Column(value = "login_date")
    private Date loginDate;
}

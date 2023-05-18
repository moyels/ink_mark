package top.moyel.ink.mark.modules.system.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.moyel.ink.mark.base.entity.BaseEntity;
import top.moyel.ink.mark.flex.MybatisFlexInsertInjectUser;
import top.moyel.ink.mark.flex.MybatisFlexUpdateInjectUser;

/**
 * @author moyel
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_role", onInsert = MybatisFlexInsertInjectUser.class, onUpdate = MybatisFlexUpdateInjectUser.class)
public class SysRole extends BaseEntity {
    @Id(keyType = KeyType.Auto)
    private Long id;
    private String roleName;
    private String roleCode;
    private Long parentRole;
    private Integer sortNo;
    private Integer status;
}

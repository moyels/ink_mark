package top.moyel.ink.mark.modules.system.entity;

import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.moyel.ink.mark.base.entity.BaseEntity;
import top.moyel.ink.mark.flex.MybatisFlexInsertInjectUser;
import top.moyel.ink.mark.flex.MybatisFlexUpdateInjectUser;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_perm", onInsert = MybatisFlexInsertInjectUser.class, onUpdate = MybatisFlexUpdateInjectUser.class)
public class SysPerm extends BaseEntity {
    private Long id;
    private String permCode;
    private Integer permType;
    private String routePath;
    private String permDesc;
    private Boolean isFrame;
    private Integer sortNo;
    private Integer status;
    private String icon;
}

package top.moyel.ink.mark.modules.system.entity;

import com.mybatisflex.annotation.Column;
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
@Table(value = "sys_perm", onInsert = MybatisFlexInsertInjectUser.class, onUpdate = MybatisFlexUpdateInjectUser.class)
public class SysPerm extends BaseEntity {
    @Id(value = "id", keyType = KeyType.Auto)
    private Long id;
    @Column("parent_id")
    private Long parentId;
    @Column("perm_code")
    private String permCode;
    @Column("perm_type")
    private Integer permType;
    @Column("route_path")
    private String routePath;
    @Column("perm_desc")
    private String permDesc;
    @Column("is_frame")
    private Boolean isFrame;
    @Column("sort_no")
    private Integer sortNo;
    @Column("status")
    private Integer status;
    @Column("icon")
    private String icon;
}

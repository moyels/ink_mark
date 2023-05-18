package top.moyel.ink.mark.modules.system.vo;

import lombok.Data;

/**
 * @author moyel
 */
@Data
public class SysPermVO {
    private Long id;
    private Long parentId;
    private String permCode;
    private String routePath;
    private String permDesc;
    private Boolean isFrame;
    private Integer sortNo;
    private Integer status;
    private String icon;
}

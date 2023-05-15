package top.moyel.ink.mark.base.entity;

import com.mybatisflex.annotation.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity implements Serializable {
    @Column(value = "create_user")
    private Long createUser;
    @Column(value = "create_time", onInsertValue = "now()")
    private Date createTime;
    @Column(value = "update_user")
    private Long updateUser;
    @Column(value = "update_time", onUpdateValue = "now()")
    private Date updateTime;
    @Column(value = "deleted", isLogicDelete = true)
    private Boolean deleted;
}

package top.moyel.ink.mark.flex;

import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.annotation.AbstractInsertListener;
import top.moyel.ink.mark.base.entity.BaseEntity;

/**
 * @author moyel
 */
public class MybatisFlexInsertInjectUser extends AbstractInsertListener<BaseEntity> {
    @Override
    public Class<BaseEntity> supportType() {
        return BaseEntity.class;
    }

    @Override
    public void doInsert(BaseEntity entity) {
        if (!StpUtil.isLogin()) {
            return;
        }
        entity.setCreateUser(StpUtil.getLoginIdAsLong());
    }
}

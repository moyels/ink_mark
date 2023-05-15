package top.moyel.ink.mark.flex;

import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.annotation.AbstractUpdateListener;
import top.moyel.ink.mark.base.entity.BaseEntity;

public class MybatisFlexUpdateInjectUser extends AbstractUpdateListener<BaseEntity> {
    @Override
    public Class<BaseEntity> supportType() {
        return BaseEntity.class;
    }

    @Override
    public void doUpdate(BaseEntity entity) {
        if (!StpUtil.isLogin()) {
            return;
        }
        entity.setUpdateUser(StpUtil.getLoginIdAsLong());
    }
}

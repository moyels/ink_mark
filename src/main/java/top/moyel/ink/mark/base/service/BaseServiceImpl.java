package top.moyel.ink.mark.base.service;

import com.mybatisflex.core.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<M extends BaseMapper<E>, E> implements IService<E> {
    private M baseMapper;

    @Autowired
    public void setBaseMapper(M baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public M getBaseMapper() {
        return baseMapper;
    }
}

package top.moyel.ink.mark.base.service;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import org.springframework.transaction.annotation.Transactional;
import top.moyel.ink.mark.utils.SqlHelper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @param <E> 实体类型
 * @author moyel
 */
public interface IService<E> {
    // region save

    /**
     * 保存一个实体
     *
     * @param entity 实体
     * @return result
     */
    default boolean save(E entity) {
        return SqlHelper.retBoolean(getBaseMapper().insert(entity, true));
    }

    /**
     * 批量保存实体
     *
     * @param entities 实体列表
     * @return result
     */
    @Transactional(rollbackFor = Exception.class)
    default boolean saveBatch(List<E> entities) {
        return SqlHelper.retBoolean(getBaseMapper().insertBatch(entities));
    }
    // endregion

    // region remove

    /**
     * 根据主键移除
     *
     * @param id 主键
     * @return result
     */
    default boolean remove(Serializable id) {
        return SqlHelper.retBoolean(getBaseMapper().deleteById(id));
    }

    /**
     * 批量根据主键移除
     *
     * @param ids 主键列表
     * @return result
     */
    default boolean removeBatch(Collection<Serializable> ids) {
        return SqlHelper.retBoolean(getBaseMapper().deleteBatchByIds(ids));
    }

    /**
     * 根据id批量分片段删除
     *
     * @param ids  id列表
     * @param size 片段长度
     * @return result
     */
    default boolean removeBatch(List<Serializable> ids, int size) {
        return SqlHelper.retBoolean(getBaseMapper().deleteBatchByIds(ids, size));
    }
    // endregion

    // region update

    /**
     * 更新实体信息
     *
     * @param entity 实体
     * @return result
     */
    default boolean update(E entity) {
        return SqlHelper.retBoolean(getBaseMapper().update(entity));
    }

    /**
     * 根据 query 条件更新实体
     *
     * @param entity  实体
     * @param wrapper 条件
     * @return result
     */
    default boolean updateByQuery(E entity, QueryWrapper wrapper) {
        return updateByQuery(entity, true, wrapper);
    }

    /**
     * 根据 query 条件更新实体
     *
     * @param entity      实体
     * @param ignoreNulls 是否忽略空值
     * @param wrapper     条件
     * @return result
     */
    default boolean updateByQuery(E entity, boolean ignoreNulls, QueryWrapper wrapper) {
        return SqlHelper.retBoolean(getBaseMapper().updateByQuery(entity, ignoreNulls, wrapper));
    }
    // endregion

    // region list

    /**
     * 根据主键获取实体
     *
     * @param id 主键
     * @return 实体
     */
    default E fetch(Serializable id) {
        return getBaseMapper().selectOneById(id);
    }

    /**
     * 列出所有
     *
     * @return 实体列表
     */
    default List<E> list() {
        return getBaseMapper().selectAll();
    }

    /**
     * 根据查询条件获取实体
     *
     * @param wrapper 查询条件
     * @return 实体列表
     */
    default List<E> list(QueryWrapper wrapper) {
        return getBaseMapper().selectListByQuery(wrapper);
    }

    /**
     * 分页查询
     *
     * @param page    分页实体
     * @param wrapper 查询条件
     * @return 分页实体列表
     */
    default Page<E> page(Page<E> page, QueryWrapper wrapper) {
        return getBaseMapper().paginate(page, wrapper);
    }

    /**
     * 分页查询
     *
     * @param page    页数
     * @param size    每页条数
     * @param wrapper 查询条件
     * @return 分页实体列表
     */
    default Page<E> page(int page, int size, QueryWrapper wrapper) {
        return getBaseMapper().paginate(page, size, wrapper);
    }

    /**
     * 带总数缓存的分页查询
     *
     * @param page    页数
     * @param size    每页条数
     * @param total   缓存的总数
     * @param wrapper 查询条件
     * @return 分页实体列表
     */
    default Page<E> page(int page, int size, long total, QueryWrapper wrapper) {
        Page<E> entityPage = new Page<>(page, size, total);
        return page(entityPage, wrapper);
    }
    // endregion

    // region save or update

    /**
     * 保存或更新
     *
     * @param entity 实体
     * @return result
     */
    default boolean saveOrUpdate(E entity) {
        return SqlHelper.retBoolean(getBaseMapper().insertOrUpdate(entity));
    }

    /**
     * 批量保存或更新
     *
     * @param entities 实体列表
     * @return result
     */
    default boolean saveOrUpdateBatch(Collection<E> entities) {
        return SqlHelper.saveOrUpdateBatch(entities);
    }
    // endregion

    /**
     * 获取 mapper 实体
     *
     * @return mapper实体
     */
    BaseMapper<E> getBaseMapper();
}

package me.luocaca.model.mapper.base;


import java.util.List;

/**
 * 基础 mapper  抽象增删改查
 *
 * @param <T>
 */


public interface BaseMapper<T> {

    // + 添加一个对象
    int add(T t);

    int delete(long id);

    int update(T t);

    List<T> queryList(int limit, int offset);


    T queryById(long id);


}

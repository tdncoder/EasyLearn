package com.easy.learn.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;

/**
 * @author modani
 * @param <T>
 * @param <E>
 */
public abstract class AbstractMapper<T, E> {

    protected final ModelMapper mapper;
    private Class<?> tClazz;
    private Class<?> uClazz;

    /**
     * Constructor AbstractMapper
     */
    public AbstractMapper() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setPreferNestedProperties(false);
        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
    }

    /**
     * Constructor AbstractMapper
     * @param tClazz
     * @param uClazz
     */
    public AbstractMapper(Class<?> tClazz, Class<?> uClazz) {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setDeepCopyEnabled(false)
                .setPreferNestedProperties(false)
                .setSkipNullEnabled(true);
        //mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        this.tClazz = tClazz;
        this.uClazz = uClazz;
    }

    /**
     * Convert DTO to entity
     * @param e
     * @return
     */
    public T convertDTOToEntity(E e) {
        return convertDTOToEntity(e, tClazz);
    }

    /**
     * Convert DTO to entity
     * @param e
     * @param tClazz
     * @return
     */
    private T convertDTOToEntity(E e, Class<?> tClazz) {
        if (null == e) return null;
        return mapper.map(e, (Type) tClazz);
    };

    /**
     * Convert entity to DTO
     * @param t
     * @return
     */
    public E convertEntityToDTO(T t) {
        return convertEntityToDTO(t, uClazz);
    }

    /**
     * Convert entity to DTO
     * @param t
     * @param uClazz
     * @return
     */
    private E convertEntityToDTO(T t, Class<?> uClazz) {
        if (null == t) return null;
        return mapper.map(t, (Type) uClazz);
    }

    /**
     * Update dto against entity.
     * @param e dto
     * @param oldEntity entity
     * @return updated entity
     */
    public T mapDTOToEntity(E e, T oldEntity) {
        if (null == e) return null;
        mapper.map(e, oldEntity);
        return oldEntity;
    };
    /**
     * Update entity from DTO.
     * @param e DTO
     * @param oldEntity Existing entity
     */
    public void updateEntityFromDTO(E e, T oldEntity) {
        if (e != null && oldEntity != null) {
            mapper.map(e, oldEntity);
        }
    }


    //end
}
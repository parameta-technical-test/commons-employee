package co.parameta.technical.test.commons.util.mapper;

import org.mapstruct.Mapper;

import java.util.List;

public interface BaseMapper<E,D> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toListDto(List<E> entity);

    List<E> toListEntity(List<D> dto);

}

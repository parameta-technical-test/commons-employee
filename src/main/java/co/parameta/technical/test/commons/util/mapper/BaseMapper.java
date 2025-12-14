package co.parameta.technical.test.commons.util.mapper;

import java.util.List;

/**
 * Generic base mapper interface for entity–DTO conversions.
 * <p>
 * Provides common mapping operations used across the application
 * to transform persistence entities into DTOs and vice versa.
 *
 * @param <E> entity type
 * @param <D> DTO type
 */
public interface BaseMapper<E, D> {

    /**
     * Converts an entity to its corresponding DTO.
     *
     * @param entity persistence entity
     * @return mapped DTO
     */
    D toDto(E entity);

    /**
     * Converts a DTO to its corresponding entity.
     *
     * @param dto data transfer object
     * @return mapped entity
     */
    E toEntity(D dto);

    /**
     * Converts a list of entities into a list of DTOs.
     *
     * @param entity list of persistence entities
     * @return list of mapped DTOs
     */
    List<D> toListDto(List<E> entity);

    /**
     * Converts a list of DTOs into a list of entities.
     *
     * @param dto list of data transfer objects
     * @return list of mapped entities
     */
    List<E> toListEntity(List<D> dto);

}

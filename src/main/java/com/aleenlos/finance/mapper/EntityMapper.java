package com.aleenlos.finance.mapper;

public interface EntityMapper<D, E> {

    E toEntity(D dto);
    D toDTO(E entity);

}

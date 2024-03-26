package com.example.autosales.repository;

import com.example.autosales.dto.request.CarsRequest;
import com.example.autosales.entity.Cars;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarsCriteria {
    @PersistenceContext
    EntityManager entityManager;

    public Page<Cars> getCarsByFilter(CarsRequest request, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cars> criteriaQuery = criteriaBuilder.createQuery(Cars.class);
        Root<Cars> carRoot = criteriaQuery.from(Cars.class);
        List<Predicate> predicates = new ArrayList<>();

        // Filtering based on brand
        if (request.getBrand()!= null) {
            predicates.add(criteriaBuilder.equal(carRoot.get("brand"), request.getBrand()));

            // Filtering based on model
            if (request.getModel() != null ) {
                predicates.add(criteriaBuilder.equal(carRoot.get("model"), request.getModel()));
            }
        }

        // Filtering based on city
        if (request.getCity() != null ) {
            predicates.add(criteriaBuilder.equal(carRoot.get("city"), request.getCity()));
        }

        // Filtering based on year range
        if (request.getMinYear() != null && request.getMinYear() > 0) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(carRoot.get("year"), request.getMinYear()));
        }
        if (request.getMaxYear() != null && request.getMaxYear() > 0) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(carRoot.get("year"), request.getMaxYear()));
        }

        // Filtering based on price range
        if (request.getMinPrice() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(carRoot.get("price"), request.getMinPrice()));
        }
        if (request.getMaxPrice() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(carRoot.get("price"), request.getMaxPrice()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Cars> query = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

        List<Cars> cars = query.getResultList();
        return new PageImpl<>(cars, pageable, cars.size());
    }
}


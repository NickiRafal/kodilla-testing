package com.kodilla.good.patterns.challenges;

import java.util.List;

public interface SchowRepository {
    default String schowRepo(List <Product>schowRepo){

            for (Product saveRepo:schowRepo) {

                System.out.println(saveRepo.getProduct() + "  " + saveRepo.getDescription());

        }
        return "";
    }
}

package controllers;

import models.Brand;

public class BrandController {
  public Brand[] sortBubbleDesc(Brand[] brands) {
    // Implementación del método
    for (int i = 0; i < brands.length - 1; i++) {
      boolean swap = false;
      for (int j = 0; j < brands.length - i - 1; j++) {
        if (brands[i].getTotalValidYears() < brands[j + 1].getTotalValidYears()) {
          Brand aux = brands[j];
          brands[j] = brands[j + 1];
          brands[j + 1] = aux;
          swap = true;
        }

      }
      if (!swap) {
        break;
      }

    }
    return brands;

  }

}

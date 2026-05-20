package test;

import controllers.BrandController;
import models.Brand;
import models.CarModel;
import models.CarYear;

public class BrandControllerTest {

    private BrandController controller;

    public void setUp() {
        controller = new BrandController();
    }

    public void testGetTotalValidYears() {
        Brand[] brands = generarDatosPrueba();
        if (brands == null || brands.length == 0) {
            throw new RuntimeException("Error: El arreglo de marcas está vacío o es nulo");
        }
        for (int i = 0; i < brands.length; i++) {
            if (brands[i].getTotalValidYears() < 0) {
                throw new RuntimeException("Error: Cálculo de años válidos dio un número negativo");
            }
        }
    }

    public void testMetodoOrdenamiento() {
        Brand[] paraOrdenar = generarDatosPrueba();

        setUp();
        controller.sortBubbleDesc(paraOrdenar);
        
        for (int i = 0; i < paraOrdenar.length - 1; i++) {
            if (paraOrdenar[i].getTotalValidYears() < paraOrdenar[i + 1].getTotalValidYears()) {
                throw new RuntimeException("Error: El arreglo no está correctamente ordenado de forma descendente");
            }
        }
    }

    public void testBusquedaBinariaPorFila() {
        Brand[] paraOrdenar = generarDatosPrueba();

        setUp();
        controller.sortBubbleDesc(paraOrdenar);

        Brand resultado1 = controller.binarySearchByValidYears(paraOrdenar, 7, false);
        if (resultado1 == null || resultado1.getTotalValidYears() != 7) {
            throw new RuntimeException("Error: No se encontró la marca con 7 años válidos estando presente");
        }

        Brand resultado2 = controller.binarySearchByValidYears(paraOrdenar, 4, false);
        if (resultado2 != null) {
            throw new RuntimeException("Error: Se retornó un objeto para un criterio que no existe (4 años)");
        }
    }

    private Brand[] generarDatosPrueba() {
        CarYear[] corollaYears = {
            new CarYear(2019, false),
            new CarYear(2020, true),
            new CarYear(2021, true),
            new CarYear(2022, true),
            new CarYear(2023, true)
        };
        CarYear[] camryYears = {
            new CarYear(2018, true),
            new CarYear(2019, true),
            new CarYear(2020, true),
            new CarYear(2021, false),
            new CarYear(2022, false),
            new CarYear(2023, true)
        };
        CarModel[] toyotaModels = {
            new CarModel("Corolla", corollaYears),
            new CarModel("Camry", camryYears)
        };
        Brand toyota = new Brand("Toyota", toyotaModels);

        CarYear[] mustangYears = {
            new CarYear(2016, true),
            new CarYear(2017, false),
            new CarYear(2018, true),
            new CarYear(2019, false),
            new CarYear(2020, false),
            new CarYear(2021, false),
            new CarYear(2022, false)
        };
        CarYear[] f150Years = {
            new CarYear(2017, false),
            new CarYear(2018, true),
            new CarYear(2019, false),
            new CarYear(2020, true),
            new CarYear(2021, true),
            new CarYear(2022, false)
        };
        CarModel[] fordModels = {
            new CarModel("Mustang", mustangYears),
            new CarModel("F-150", f150Years)
        };
        Brand ford = new Brand("Ford", fordModels);

        Brand[] marcas = { toyota, ford };
        return marcas;
    }

    public static void main(String[] args) {
        BrandControllerTest prueba = new BrandControllerTest();
        try {
            prueba.testGetTotalValidYears();
            System.out.println("Test 1 (Cálculo): PASADO");
        } catch (Exception e) {
            System.out.println("Test 1 (Cálculo): FALLADO -> " + e.getMessage());
        }
        try {
            prueba.testMetodoOrdenamiento();
            System.out.println("Test 2 (Ordenamiento): PASADO");
        } catch (Exception e) {
            System.out.println("Test 2 (Ordenamiento): FALLADO -> " + e.getMessage());
        }
        try {
            prueba.testBusquedaBinariaPorFila();
            System.out.println("Test 3 (Búsqueda): PASADO");
        } catch (Exception e) {
            System.out.println("Test 3 (Búsqueda): FALLADO -> " + e.getMessage());
        }
    }
}
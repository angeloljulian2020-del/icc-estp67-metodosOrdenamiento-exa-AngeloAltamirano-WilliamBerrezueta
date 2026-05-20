package models;

public class Brand {
    private String brandName;
    private CarModel[] models;

    public Brand(String brandName, CarModel[] models) {
        this.brandName = brandName;
        this.models = models;
    }

    
    public int getTotalValidYears() {
        int totalValidYears = 0;
        
        if (models != null) {
            for (CarModel model : models) {
                if (model != null && model.getYears() != null) {
                    for (CarYear carYear : model.getYears()) {
                        if (carYear != null && carYear.isValid()) {
                            totalValidYears++;
                        }
                    }
                }
            }
        }
        return totalValidYears;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public CarModel[] getModels() {
        return models;
    }

    public void setModels(CarModel[] models) {
        this.models = models;
    }

   
    @Override
    public String toString() {
        return "Brand{" + "brandName='" + brandName + '\'' + ", totalValidYears=" + getTotalValidYears() + '}';
    }
}

package entity;

import java.util.Date;
import java.util.Objects;

public class Product {

    private int id;
    private int companyId;
    private int codeId;
    private String productName;
    private double value;
    private String productType;
    private String productDescription;
    private String productImage;
    private Date creationDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && companyId == product.companyId && codeId == product.codeId && Double.compare(value, product.value) == 0 && Objects.equals(productName, product.productName) && Objects.equals(productType, product.productType) && Objects.equals(productDescription, product.productDescription) && Objects.equals(productImage, product.productImage) && Objects.equals(creationDate, product.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, codeId, productName, value, productType, productDescription, productImage, creationDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", codeId=" + codeId +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                ", productType='" + productType + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}

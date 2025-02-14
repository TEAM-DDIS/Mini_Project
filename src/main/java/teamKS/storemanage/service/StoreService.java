package teamKS.storemanage.service;

import section01.storemanage.aggregate.Product;
import section01.storemanage.repository.StoreRepository;

import java.util.ArrayList;

public class StoreService {

    private final StoreRepository sr = new StoreRepository();

    public StoreService() {
    }

    public void findAllProducts() {

        ArrayList<Product> findProducts = sr.selectAllProducts();
        System.out.println("상품 조회 확인: ");
        for (Product product : findProducts) {
            System.out.println(product);
        }
    }

    public void findProductsBy(int choosenum) {
        System.out.println(sr.getProductsNum(choosenum));
    }


    public Product findProductupdate(int choosenum) {
        Product getProduct = sr.getProductsNum(choosenum);

        if (getProduct != null) {

            Product newInstance = new Product();
            newInstance.setProductID(getProduct.getProductID());
            newInstance.setPrice(getProduct.getPrice());
            newInstance.setProductName(getProduct.getProductName());
            newInstance.setProductAmount(getProduct.getProductAmount());
            newInstance.setCategory(getProduct.getCategory());
            newInstance.setReceiptDate(getProduct.getReceiptDate());
            newInstance.setExpirationDate(getProduct.getExpirationDate());

            System.out.println("조회된 상품은: " + newInstance);
            return newInstance;
        }  else {
            System.out.println("상품이 존재하지 않습니다.");
        }
        return getProduct;
    }

    public void modifyProducts(Product selected) {
        Product mdProduct = sr.modifyProducts(selected);
    }
}

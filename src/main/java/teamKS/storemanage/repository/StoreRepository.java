package teamKS.storemanage.repository;


import teamKS.storemanage.aggregate.Category;
import teamKS.storemanage.aggregate.Product;

import java.io.*;
import java.util.ArrayList;

public class StoreRepository {

    private final ArrayList<Product> productList = new ArrayList<>();

    private final File file = new File(
            "src/main/java/section01/storemanage/db/productDB.dat"
    );

    public StoreRepository() {

        if(!file.exists()) {
            ArrayList<Product> defaultProduct = new ArrayList<>();
            defaultProduct.add(new Product(1,"apple",3000,300, Category.FRUIT, "2025-02-12","2029-02-12"));
            defaultProduct.add(new Product(2,"shirts",50000,70, Category.CLOTHES, "2025-02-12"));
            defaultProduct.add(new Product(3,"pasta",4000,100, Category.FOOD, "2025-02-12","2029-02-12"));
            defaultProduct.add(new Product(4,"iphone",2000000,10, Category.DEVICE, "2025-02-12"));
            defaultProduct.add(new Product(5,"sofa",3000000,20, Category.FURNITURE, "2025-02-12"));

            saveProducts(defaultProduct);
        }

        loadProducts();
    }

    private void loadProducts() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {while (true) {
            productList.add((Product) ois.readObject());
        }

        } catch(EOFException e) {
            System.out.println("상품 정보를 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveProducts(ArrayList<Product> inputProduct) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );
            for (Product product : inputProduct ){
                oos.writeObject(product);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Product> selectAllProducts() {
        return productList;
    }

    public Product getProductsNum(int choosenum) {

        Product findbynumproduct = null;
        for (Product products : productList){
            if(products.getProductID() == choosenum) {
                findbynumproduct =  products;
            }
        }

        return findbynumproduct;

    }


    public Product modifyProducts(Product selected) {



    }
}


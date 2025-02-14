package teamKS.storemanage.run;


import teamKS.storemanage.aggregate.Category;
import teamKS.storemanage.aggregate.Product;
import teamKS.storemanage.service.StoreService;

import java.util.Scanner;

public class Application {

    private static final StoreService ss = new StoreService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("===== 상품 관리 프로그램 =====");
            System.out.println("1. 모든 상품 조회");
            System.out.println("2. 상품 찾기");
            System.out.println("3. 상품 수정");
            System.out.println("4. 상품 삭제");
            System.out.println("5. 상품 등록");
            System.out.println("9. 프로그램 종료");
            System.out.print("몇 번을 입력하시겠습니까? ");
            int input = sc.nextInt();

            switch (input) {
                case 1: ss.findAllProducts(); break;
                case 2: ss.findProductsBy(choosenum()); break;
                case 3:
                    Product selected = ss.findProductupdate(choosenum());
                    if(selected == null) continue;

                    ss.modifyProducts(updateProducts(selected));break;
                case 4: break;
                case 5: break;
                case 9:
                    System.out.println("상품관리 프로그램을 종료합니다. "); return;
                default:
                    System.out.println("숫자 입력 다시");
            }
        }
    }

    private static Product updateProducts(Product selected) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("어떤 항목을 수정하시겠습니까?");
            System.out.println("1. 상품명");
            System.out.println("2. 가격");
            System.out.println("3. 상품 양");
            System.out.println("4.카테고리");
            System.out.println("5. 입고날짜");
            System.out.println("6. 유통기한");
            System.out.println("9. 프로그램을 종료합니다.");
            int productNum = sc.nextInt();
            sc.nextLine();

            switch (productNum) {
                case 1:
                    System.out.println("수정 할 상품명을 입력하세요");
                    selected.setProductName(sc.nextLine());
                    break;
                case 2:
                    System.out.println("수정할 가격을 입력하세요");
                    selected.setPrice(sc.nextInt());
                    break;
                case 3:
                    System.out.println("수정할 상품 양을 입력하세요");
                    selected.setProductAmount(sc.nextInt());
                    break;
                case 4:
                    System.out.println("수정할 카테고리를 입력하세요");
                    selected.setCategory(categoryupdate());
                    break;
                case 5:
                    System.out.println("수정할 입고날짜를 입력하세요");
                    selected.setReceiptDate(sc.nextLine());
                    break;
                case 6:
                    System.out.println("수정할 유통기한을 입력하세요");
                    selected.setExpirationDate(sc.nextLine());
                    break;
                case 9:
                    System.out.println("상품 수정 프로그램을 종료합니다. "); return selected;
                default:
                    System.out.println("숫자 입력 다시");
            }
        }
    }

    private static Category categoryupdate() {
        Scanner sc = new Scanner(System.in);
        String category = sc.nextLine().toUpperCase();
        Category ct = null;
        switch (category) {
            case "FRUIT": ct = Category.FRUIT;
            case "CLOTHES": ct = Category.CLOTHES;
            case "FOOD": ct = Category.FOOD;
            case "DEVICE": ct = Category.DEVICE;
            case "FURNITURE": ct = Category.FURNITURE;
        }

        return ct;

    }

    private static int choosenum() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상품 번호를 입력하세요 : ");
        return sc.nextInt();


    }


}

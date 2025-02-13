package teamDA.catcafe.run;

import teamDA.catcafe.aggregate.Cat;
import teamDA.catcafe.service.CatService;

import java.util.Scanner;

public class Application1 {

    private static final CatService cs = new CatService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("====== 고양이 관리 프로그램 ======");
            System.out.println("1. 모든 고양이 정보 보기");
            System.out.println("2. 고양이 찾기");
            System.out.println("3. 고양이 등록");
            System.out.println("4. 고양이 정보 수정");
            System.out.println("5. 고양이 정보 삭제");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: cs.findAllCats(); break;
                case 2: cs.findCatBy(chooseCatNo()); break;
//                case 3: cs.registCat(signUp()); break;
                case 4:  break;
                case 5:  break;
                case 9:
                    System.out.println("회원관리 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private static Cat signUp() {
        Cat cat = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
//        String name = ;
//        String breeds = ;
//        String gender = ;
//        boolean isNeutered = sc.

        return cat;
    }

    private static int chooseCatNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("고양이 번호를 입력하세요: ");
        return sc.nextInt();
    }
}

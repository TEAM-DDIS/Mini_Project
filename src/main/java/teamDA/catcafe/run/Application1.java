package teamDA.catcafe.run;

import teamDA.catcafe.aggregate.Cat;
import teamDA.catcafe.aggregate.Gender;
import teamDA.catcafe.service.CatService;

import java.util.Scanner;

public class Application1 {

    private static final CatService cs = new CatService();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("====== 고양이 관리 프로그램 ======");
            System.out.println("1. 활성화 고양이 정보 보기");
            System.out.println("2. 고양이 찾기");
            System.out.println("3. 고양이 등록");
            System.out.println("4. 고양이 정보 수정");
            System.out.println("5. 고양이 정보 휴지통 넣기");
            System.out.println("6. 모든 고양이 정보 보기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴를 선택해 주세요: ");
            int input = sc.nextInt();

            switch (input) {
                case 1: cs.findAllCats(); break;
                case 2: cs.findCatBy(chooseCatNo()); break;
                case 3: cs.registCat(signUp()); break;
                case 4:
                    Cat selected = cs.findCatForMod(chooseCatNo());
                    if (selected == null) continue;
                    cs.modifyCat(reform(selected));
                break;
                case 5: cs.removeCat(chooseCatNo()); break;
                case 6: cs.pullCat(); break;
                case 9:
                    System.out.println("고양이 카페 관리 프로그램을 종료합니다."); return;
                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    //회원정보수정페이지
    private static Cat reform(Cat modifyCat) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" ==== 고양이 정보 수정 서브 메뉴 ==== ");
            System.out.println("1. 고양이 이름");
            System.out.println("2. 고양이 품종");
            System.out.println("3. 고양이 성별");
            System.out.println("4. 고양이 중성화 여부");
            System.out.println("9. 메인 메뉴로 돌아가기");
            System.out.println("내용을 선택하세요: ");
            int chooseNo = sc.nextInt();
            sc.nextLine();

            switch (chooseNo) {
                case 1:
                    System.out.print("수정 할 이름을 입력하세요.");
                    modifyCat.setName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("수정 할 품종을 입력하세요.");
                    modifyCat.setBreeds(sc.nextLine());
                    break;
                case 3:
                    System.out.print("수정 할 성별을 입력하세요. (F/M)");
                    modifyCat.setGender(resetGender());
                    break;
                case 4:
                    System.out.print("수정 할 중성화 여부를 입력하세요. (Y/N)");
                    modifyCat.setNeutered(resetIsNeutered());
                    break;
                case 9:
                    System.out.print("메인 메뉴로 돌아갑니다.");
                    return modifyCat;
                default:
                    System.out.println("번호를 다시 입력하세요.");
            }
        }
    }

    private static Gender resetGender() {
        Scanner sc = new Scanner(System.in);
        Gender gd = null;
        while(true) {
            String gender = sc.nextLine().toUpperCase();
            if (gender.equals("F")) {
                gd = Gender.FEMALE;
                System.out.println("변경되었습니다!");
                break;
            } else if (gender.equals("M")) {
                gd = Gender.MALE;
                System.out.println("변경되었습니다!");
                break;
            } else {
                System.out.println("다시 입력하세요!");
            }
        }
        return gd;
    }

    private static boolean resetIsNeutered() {
        Scanner sc = new Scanner(System.in);
        boolean isNeutered = false;

        while (true) {
            String uCheck = sc.nextLine().toUpperCase();

            if (uCheck.equals("Y")) {
                isNeutered = true;
                System.out.println("변경되었습니다!");
                break;
            } else if (uCheck.equals("N")) {
                isNeutered = false;
                System.out.println("변경되었습니다!");
                break;
            } else {
                System.out.println("다시 입력하세요!");
            }
        }
        return isNeutered;
    }


    private static Cat signUp() {
        Cat cat = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();

        System.out.println("품종을 입력하세요: ");
        String breeds = sc.nextLine();

        Gender gd = null;
        while(true) {
            System.out.print("성별을 입력하세요: (F/M)");
            String gender = sc.nextLine().toUpperCase();

            if (gender.equals("F")) {
                gd = Gender.FEMALE;
                break;
            } else if (gender.equals("M")) {
                gd = Gender.MALE;
                break;
            } else {
                System.out.println("다시 입력하세요!");
            }

        }

        boolean isNeutered = false;

        while(true) {
            System.out.print("중성화 여부를 입력하세요: (Y/N)");
            String nCheck = sc.nextLine().toUpperCase();

            if (nCheck.equals("Y")) {
                isNeutered = true;
                break;
            } else if (nCheck.equals("N")){
                isNeutered = false;
                break;
            } else {
                System.out.println("다시 입력하세요!");
            }
        }
        cat = new Cat(name, breeds, gd, isNeutered);

        return cat;
    }

    private static int chooseCatNo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("고양이 번호를 입력하세요: ");
        return sc.nextInt();
    }
}

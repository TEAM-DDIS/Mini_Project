package teamDA.catcafe.service;

import teamDA.catcafe.aggregate.Cat;
import teamDA.catcafe.repository.CatRepository;

import java.util.ArrayList;

public class CatService {

    private final CatRepository cr = new CatRepository();

    public void findAllCats() {
        ArrayList<Cat> findCats = cr.selectAllCats();

        System.out.println("Service에서 조회 확인: ");
        for (Cat cat : findCats) {
            System.out.println(cat);
        }
    }

    public void findCatBy(int catNo) {
        Cat findCat = cr.selectCatBy(catNo);

        if(findCat != null) {
            System.out.println("고양이 조회 성공: " + findCat);
        } else {
            System.out.println(catNo + "번 고양이는 없습니다.");
        }
    }
}

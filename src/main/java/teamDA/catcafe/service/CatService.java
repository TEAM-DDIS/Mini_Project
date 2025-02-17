package teamDA.catcafe.service;

import teamDA.catcafe.aggregate.Cat;
import teamDA.catcafe.aggregate.CatStatus;
import teamDA.catcafe.repository.CatRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CatService {

    private final CatRepository cr = new CatRepository();

    public void findAllCats() {
        ArrayList<Cat> findCats = cr.selectAllCats();

        System.out.println("Service에서 조회 확인: ");
        for (Cat cat : findCats) {
            if (cat.getCatStatus() == CatStatus.ACTIVE)
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

    public void registCat(Cat cat) {
//        System.out.println(cat);

        int lastCatNO = cr.selectCatNo();   //마지막 번호 받아옴
        cat.setCatNo(lastCatNO + 1);
        // 회원번호 추가
        cat.setCatStatus(CatStatus.ACTIVE);

        // 날짜 추가
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date = dateFormat.format(now);           //format string으로 되어있음
        cat.setRegDate(date);                           // 현재 추가된 내용을 cat에 넣기
        System.out.println("신규등록된 고양이 정보 " + cat);

        // 추가된 작업들 확인
        int result = cr.insertCat(cat);
        System.out.println("insert 성공 실패 여부: " + result);

        if (result == 1) {
            System.out.println("등록에 성공했습니다! " + cat.getName());
        } else {
            System.out.println("등록에 실패했습니다!");
        }
    }

    public Cat findCatForMod(int catNo) {
    Cat selectedCat = cr.selectCatBy(catNo);

        if (selectedCat != null) {
            //레포에 받아온
            Cat newInstance = new Cat();
            newInstance.setCatNo(selectedCat.getCatNo());
            newInstance.setName(selectedCat.getName());
            newInstance.setBreeds(selectedCat.getBreeds());
            newInstance.setGender(selectedCat.getGender());
            newInstance.setRegDate(selectedCat.getRegDate());
            newInstance.setCatStatus(selectedCat.getCatStatus());
            newInstance.setNeutered(selectedCat.isNeutered());

            System.out.println("조회된 고양이(사본) 조회: " + newInstance);
            return newInstance;
        } else {
            System.out.println("그런 회원은 없습니다. ");

        } return selectedCat;
    }


    public void modifyCat(Cat reformedCat) {
        int result = cr.updateCat(reformedCat);
        System.out.println("수정된 고양이 정보" + reformedCat);

        if (result == 1) {
            System.out.println(reformedCat.getName() + "고양이의 정보를 수정했습니다!" );
        } else {
            System.out.println("고양이 정보 수정에 실패하였습니다.");
        }
    }

    public void removeCat(int removeCatNo) {
        int result = cr.deleteCat(removeCatNo);
        if (result == 1) {
            System.out.println(removeCatNo + "번 고양이 정보를 휴지통에 넣었습니다..");
        } else {
            System.out.println("고양이 정보를 휴지통에 넣기 실패했습니다");
        }
    }

    public void pullCat() {
        ArrayList<Cat> pullCats = cr.selectAllCats();
        for (Cat cat : pullCats) {
            System.out.println(cat);
        }
    }
}
